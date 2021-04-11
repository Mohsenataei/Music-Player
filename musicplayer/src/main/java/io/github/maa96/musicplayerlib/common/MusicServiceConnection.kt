package io.github.maa96.musicplayerlib.common

import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.maa96.musicplayerlib.media.service.MusicPlayerService
import io.github.maa96.musicplayerlib.media.util.Event
import io.github.maa96.musicplayerlib.media.util.Resource

class MusicServiceConnection(context: Context) {
    private const val TAG = "MusicServiceConnection"
    private val _isConnected = MutableLiveData<Event<Resource<Boolean>>>()
    val isConnected: LiveData<Event<Resource<Boolean>>>
        get() = _isConnected

    private val _networkError = MutableLiveData<Event<Resource<Boolean>>>()
    val networkError: LiveData<Event<Resource<Boolean>>>
        get() = _networkError

    private val _playbackState = MutableLiveData<PlaybackStateCompat?>()
    val playbackState: LiveData<PlaybackStateCompat?>
        get() = _playbackState

    private val _curPlayingSong = MutableLiveData<MediaMetadataCompat?>()
    val curPlayingSong: LiveData<MediaMetadataCompat?>
        get() = _curPlayingSong

    lateinit var mediaController: MediaControllerCompat

    private val mediaBrowserConnectionCallback = MediaBrowserConnectionCallback(context)


    private val mediaBrowser = MediaBrowserCompat(
        context,
        ComponentName(
            context,
            MusicPlayerService::class.java
        ),
        mediaBrowserConnectionCallback,
        null
    ).apply { connect() }


    private inner class MediaBrowserConnectionCallback(private val context: Context) :
        MediaBrowserCompat.ConnectionCallback() {

        override fun onConnected() {
            Log.d(TAG, "onConnected: ")

            mediaController = MediaControllerCompat(context, mediaBrowser.sessionToken)
                .apply {
                    registerCallback(MediaControllerCallBack())
                }

        }

        override fun onConnectionSuspended() {
            Log.d(TAG, "onConnectionSuspended: ")
        }

        override fun onConnectionFailed() {
            Log.d(TAG, "onConnectionFailed: ")
            _isConnected.postValue(
                Event(
                    Resource.Error(
                        "Could not connect to Media browser service",
                        false
                    )
                )
            )
        }

    }

    private inner class MediaControllerCallBack : MediaControllerCompat.Callback() {
        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            _playbackState.postValue(state)
        }

        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            _curPlayingSong.postValue(metadata)
        }

        override fun onSessionEvent(event: String?, extras: Bundle?) {
            when (event) {
                "NetWorkError" -> _networkError.postValue(
                    Event(
                        Resource.Error(
                            "Couldn't connect to the server. Please check your internet connection.",
                            false
                        )
                    )
                )
            }
        }
    }
}
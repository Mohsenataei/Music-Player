package io.github.maa96.musicplayerlib.media.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import io.github.maa96.musicplayer.BuildConfig
import io.github.maa96.musicplayerlib.media.util.PlayListType
import javax.inject.Inject


//This Service is responsible for playing music in entire application
class MediaPlayerService : Service() {

    @Inject
    private lateinit var mediaPlayer: MediaPlayer
    private var currentMusicPath: String? = null;


    companion object {
        //Some Constants to indicate Action of service buttons
        const val ACTION_PLAY = BuildConfig.LIBRARY_PACKAGE_NAME + "PLAY_MUSIC"

        fun createIntent(
            context: Context,
            action: String = ACTION_PLAY,
            path: String? = null,
            playListType: PlayListType = PlayListType.ALL,
            trackProgressLvl: Int? = null,
            volumeProgressLvl: Int? = null
        ): Intent {
            val intent = Intent(context, MediaPlayerService::class.java)
            intent.action = action



            return intent
        }

    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

    }
}
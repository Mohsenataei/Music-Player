package io.github.maa96.musicplayerlib.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.maa96.musicplayearlib.data.model.Track
import io.github.maa96.musicplayerlib.data.datasource.MusicDataSource
import javax.inject.Inject


/**
 * This class is responsible for providing music source for service to play*/
class MusicRepository @Inject constructor(
    private val musicDataSource: MusicDataSource,
    private val context: Context
) {

    private val _playList: MutableLiveData<List<Track>> = MutableLiveData()

    /**
     * This is a custom getter for private property
     * */
    val playList: LiveData<List<Track>>
        get() = _playList


    suspend fun getPlayListFromAssets(playListName: String): List<Track> =
        musicDataSource.getPlayListFromAssets(playListName)
}
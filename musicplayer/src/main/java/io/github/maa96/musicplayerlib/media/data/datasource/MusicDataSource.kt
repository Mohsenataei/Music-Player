package io.github.maa96.musicplayerlib.media.data.datasource

import android.content.Context
import io.github.maa96.musicplayearlib.data.model.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

class MusicDataSource @Inject constructor(
    private val context: Context
) {


    suspend fun getPlayListFromAssets(playListName: String): List<Track> {
        return withContext(Dispatchers.IO) {
            val tracks: MutableList<Track> = mutableListOf()
            val trackNames = context.assets.list(playListName)?.toList() ?: emptyList()
            trackNames.forEach { trackName ->
                val file = getMusicFile(trackName)
                val musicFile = Track(
                    path = file!!.absolutePath,
                    name = file.name,
                    isLiked = false,
                    duration = getMusicDuration(file),
                )


                tracks.add(musicFile)

            }



            tracks
        }
    }


    // TODO: 3/22/21 implement this later
    private fun getMusicFile(trackName: String): File? {
        return null
    }

    private fun getMusicDuration(file: File): String? {
        return null
    }


}
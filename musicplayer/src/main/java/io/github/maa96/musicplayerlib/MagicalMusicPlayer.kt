package io.github.maa96.musicplayerlib

import android.content.Context
import java.io.File
import javax.inject.Inject


data class Person(val name:String){

}

class MagicalMusicPlayer @Inject constructor(
    private val context: Context
) {

    private val dataSource: MutableList<String> = mutableListOf()

    fun setMediaDataSource(dataSource: List<String>) {
        dataSource.forEach {
            this.dataSource.add(it)
        }
    }

    @JvmName("setMediaDataSource1")
     fun setMediaDataSource(dataSource: List<File>) {
        val paths: MutableList<String> = mutableListOf()

        dataSource.forEach {
            paths.add(it.absolutePath)
        }
        setMediaDataSource(paths)
    }


    /**
     * This method start [MediaPlayerService]
     * */
    fun play() {

    }

    fun stop() {

    }

    fun playNext() {

    }

    fun playPrev() {

    }

    fun toggle() {

    }


}
package io.github.maa96.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.maa96.musicplayerlib.MagicalMusicPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var magicalMusicPlayer: MagicalMusicPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        magicalMusicPlayer = MagicalMusicPlayer(this)

        magicalMusicPlayer.setMediaDataSource(listOf("http://81.4.110.89/Puzzle-Sunami-320.mp3"))

    }
}
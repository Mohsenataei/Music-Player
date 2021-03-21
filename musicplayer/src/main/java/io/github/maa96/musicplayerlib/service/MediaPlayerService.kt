package io.github.maa96.musicplayerlib.service

import android.app.Service
import android.content.Intent
import android.os.IBinder


//This Service is responsible for playing music in entire application
class MediaPlayerService : Service() {

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()

    }
}
package io.github.maa96.musicplayerlib

import android.app.Application
import io.github.maa96.musicplayerlib.di.component.AppComponent
import io.github.maa96.musicplayerlib.di.component.DaggerAppComponent

class MusicApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().application(this).create()
    }
}
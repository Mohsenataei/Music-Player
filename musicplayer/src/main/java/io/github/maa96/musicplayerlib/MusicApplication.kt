package io.github.maa96.musicplayerlib

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.github.maa96.musicplayerlib.di.AppInjector
import io.github.maa96.musicplayerlib.di.component.AppComponent
import io.github.maa96.musicplayerlib.di.component.DaggerAppComponent

class MusicApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent


    override fun onCreate() {
        super.onCreate()
        AppInjector.initInjector(this)

    }

}
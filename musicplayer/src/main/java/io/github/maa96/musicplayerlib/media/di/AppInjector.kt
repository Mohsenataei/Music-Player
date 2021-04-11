package io.github.maa96.musicplayerlib.media.di

import io.github.maa96.musicplayerlib.MusicApplication
import io.github.maa96.musicplayerlib.media.di.component.AppComponent
import io.github.maa96.musicplayerlib.media.di.component.DaggerAppComponent

class AppInjector {

    companion object {
        fun initInjector(app: MusicApplication){
            DaggerAppComponent
                .factory()
                .create(app)
                .apply {
                    app.appComponent = this as AppComponent
                }
        }
    }
}
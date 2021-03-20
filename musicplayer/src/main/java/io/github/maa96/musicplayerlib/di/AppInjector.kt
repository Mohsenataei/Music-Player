package io.github.maa96.musicplayerlib.di

import dagger.android.DaggerApplication
import io.github.maa96.musicplayerlib.MusicApplication
import io.github.maa96.musicplayerlib.di.component.AppComponent
import io.github.maa96.musicplayerlib.di.component.DaggerAppComponent

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
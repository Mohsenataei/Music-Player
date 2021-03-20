package io.github.maa96.musicplayerlib.di.component

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.github.maa96.musicplayerlib.MusicApplication
import io.github.maa96.musicplayerlib.di.module.AppModule
import io.github.maa96.musicplayerlib.service.MediaPlayerService

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SubComponentModule::class,
        AppModule::class,
        AndroidInjectionModule::class
    ]
)
// This is Also ApplicationGraph so do not get Confused.
interface AppComponent : AndroidInjector<MusicApplication> {


    fun serviceComponent(): MusicPlayerSubComponent.Factory

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MusicApplication> {
        interface Factory {
            fun create(@BindsInstance application: Context): AppComponent
        }
    }
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application): Builder
//        fun create(): AppComponent
//
//    }
}
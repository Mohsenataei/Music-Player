package io.github.maa96.musicplayerlib.di.component

import dagger.Subcomponent
import io.github.maa96.musicplayerlib.service.MediaPlayerService

@Subcomponent
interface MusicPlayerSubComponent {
    fun inject(mediaPlayerService: MediaPlayerService)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MusicPlayerSubComponent
    }
}
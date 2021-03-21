package io.github.maa96.musicplayerlib.data.model

import android.os.Parcelable
import io.github.maa96.musicplayearlib.data.model.Track
import kotlinx.android.parcel.Parcelize
import java.time.Duration


@Parcelize
data class TrackDetail(
    val track: Track,
    val currentPosition: Int,
    val duration: Int,
    val isPlaying: Boolean,
    val isLooping: Boolean
) : Parcelable
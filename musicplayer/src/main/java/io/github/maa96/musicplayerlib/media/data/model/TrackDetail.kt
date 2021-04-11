package io.github.maa96.musicplayerlib.media.data.model

import android.os.Parcelable
import io.github.maa96.musicplayearlib.data.model.Track
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TrackDetail(
    val track: Track,
    val currentPosition: Int,
    val duration: Int,
    val isPlaying: Boolean,
    val isLooping: Boolean 
) : Parcelable
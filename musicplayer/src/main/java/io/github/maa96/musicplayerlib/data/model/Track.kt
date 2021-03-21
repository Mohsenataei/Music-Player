package io.github.maa96.musicplayearlib.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Track(
    val path: String,
    val name: String,
    val isLiked: Boolean,
    val duration: String?
) : Parcelable



package io.github.maa96.musicplayerlib.media.util

sealed class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    class Loading<out T>(data: T?) : Resource<T>(Status.LOADING, data, null)
    class Success<out T>(data: T?) : Resource<T>(Status.LOADING, data, null)
    class Error<out T>(message: String, data: T?) : Resource<T>(Status.ERROR, data, message)

//    companion object {
//        fun <T> success(data: T?) = Resource(Status.SUCCESS, data, null)
//
//        fun <T> error(message: String, data: T?) = Resource(Status.ERROR, data, message)
//
//        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)
//    }
}


enum class Status {
    LOADING,
    ERROR,
    SUCCESS
}
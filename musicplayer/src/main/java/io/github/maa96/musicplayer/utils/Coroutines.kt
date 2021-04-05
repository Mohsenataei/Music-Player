package io.github.maa96.musicplayer.utils

import kotlinx.coroutines.*


@FlowPreview
@OptIn(ExperimentalCoroutinesApi::class)
typealias CompletionBlock<T> = Coroutines.Request<T>.() -> Unit


@FlowPreview
@ExperimentalCoroutinesApi
object Coroutines {

    fun <T : Any> ioThenMain(
        work: suspend (() -> T),
        completionBlock: CompletionBlock<T>? = null
    ): Job {
        val callback = Request<T>().apply { completionBlock?.let { it() } }


        val handler = CoroutineExceptionHandler { _, exception ->

            callback.invoke(exception)
            callback.invokeFinally()
        }

        return CoroutineScope(Dispatchers.Main + handler).launch {
            callback.invokeExecute()
            val data = CoroutineScope(Dispatchers.IO).async {
                return@async work()
            }.await()
            callback.invoke(data)
            callback.invokeFinally()
        }
    }


    class Request<T> {
        private var onComplete: ((T) -> Unit)? = null
        private var onError: ((Throwable) -> Unit)? = null
        private var onCancel: ((CancellationException) -> Unit)? = null
        private var onExecute: (() -> Unit)? = null
        private var finally: (() -> Unit)? = null

        fun onComplete(block: (T) -> Unit) {
            onComplete = block
        }

        fun onError(block: (Throwable) -> Unit) {
            onError = block
        }

        fun onCancel(block: (CancellationException) -> Unit) {
            onCancel = block
        }

        @Synchronized
        fun onExecute(block: () -> Unit) {
            onExecute = block
        }

        @Synchronized
        fun finally(block: () -> Unit) {
            finally = block
        }

        operator fun invoke(result: T) {
            onComplete?.invoke(result)
        }

        fun invokeExecute() {
            onExecute?.invoke()
        }

        fun invokeFinally() {
            finally?.invoke()
        }

        operator fun invoke(error: Throwable) {
            onError?.invoke(error)
        }

        operator fun invoke(cancel: CancellationException) {
            onCancel?.invoke(cancel)
        }

    }
}
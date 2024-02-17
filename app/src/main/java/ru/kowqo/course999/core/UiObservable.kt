package ru.kowqo.course999.core

interface UiObservable<T : Any> : UiUpdate<T>, UpdateObserver<T> {
    abstract class Single<T : Any> : UiObservable<T> {
        private var cache: T? = null

        private var observer: UiObserver<T> = UiObserver.Empty()

        override fun invoke(data: T) {
            if (observer.isEmpty()) {
                cache = data
            } else {
                cache = null
                observer.invoke(data)
            }
        }

        override fun updateObserver(uiObserver: UiObserver<T>) {
            observer = uiObserver

            if (!observer.isEmpty()) {
                cache?.let {
                    observer.invoke(it)
                    cache = null
                }
            }
        }
    }
}

interface UiUpdate<T : Any> {
    fun invoke(data: T)
}

interface UpdateObserver<T : Any> {
    fun updateObserver(uiObserver: UiObserver<T> = UiObserver.Empty())
}

interface UiObserver<T : Any> : UiUpdate<T> {
    fun isEmpty(): Boolean = false

    class Empty<T : Any> : UiObserver<T> {
        override fun isEmpty(): Boolean = true

        override fun invoke(data: T) = Unit
    }
}

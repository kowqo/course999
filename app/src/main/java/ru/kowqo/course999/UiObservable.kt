package ru.kowqo.course999

interface UiObservable<T : Any> : UiUpdate<T> {
    fun updateObserver(uiObserver: UiObserver<T> = UiObserver.Empty())

    class Single<T : Any> : UiObservable<T> {
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

interface UiObserver<T : Any> : UiUpdate<T> {
    fun isEmpty(): Boolean = false

    class Empty<T : Any> : UiObserver<T> {
        override fun isEmpty(): Boolean = true

        override fun invoke(data: T) = Unit
    }
}

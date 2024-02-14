package ru.kowqo.course999


interface MainRepresentative {
    fun startGettingUpdates(observer: UiObserver<String>)

    fun stopGettingUpdates()

    fun startAsync(data: String)


    class Base(
        private val observable: UiObservable<String>,
    ) : MainRepresentative {

        override fun startGettingUpdates(observer: UiObserver<String>) {
            observable.updateObserver(observer)
        }

        override fun stopGettingUpdates() = observable.updateObserver()

        override fun startAsync(data: String) {
            Thread {
                Thread.sleep(2000)
                observable.invoke(data)
            }.start()
        }

    }
}

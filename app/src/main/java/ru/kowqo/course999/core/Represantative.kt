package ru.kowqo.course999.core

interface Represantative<T : Any> {
    fun startGettingUpdates(callback: UiObserver<T>) = Unit

    fun stopGettingUpdates() = Unit
}

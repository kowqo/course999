package ru.kowqo.course999.core

import android.util.Log

interface Represantative<T : Any> {
    fun startGettingUpdates(callback: UiObserver<T>) = Unit

    fun stopGettingUpdates() = Unit

    class Base() {
        private val handleDeath = HandleDeath.Base()

        fun activityCreated(firstOpening: Boolean) {
            if (firstOpening) {
                handleDeath.firstOpening()
                Log.d("qwe", "First Time")
            } else {
                if (handleDeath.wasDeathHappened()) {
                    Log.d("qwe", "Death happened")
                    handleDeath.handleDeath()
                } else {
                    Log.d("qwe", "just activity recreated")
                }
            }
        }
    }
}

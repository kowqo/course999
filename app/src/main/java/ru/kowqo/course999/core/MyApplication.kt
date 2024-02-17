package ru.kowqo.course999.core

import android.app.Application
import android.util.Log
import ru.kowqo.course999.main.MainRepresentative

class MyApplication : Application() {
    private val handleDeath = HandleDeath.Base()

    lateinit var mainRepresentative: MainRepresentative

    override fun onCreate() {
        super.onCreate()
        mainRepresentative = MainRepresentative.Base(UiObservable.Single())
    }

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

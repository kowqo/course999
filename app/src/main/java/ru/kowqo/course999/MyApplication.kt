package ru.kowqo.course999

import android.app.Application
import android.util.Log

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
            Log.d("kowA", "First Time")
        } else {
            if (handleDeath.wasDeathHappened()) {
                Log.d("kowA", "Death happened")
                handleDeath.handleDeath()
            } else {

                Log.d("kowA", "just activity recreated")
            }
        }
    }
}
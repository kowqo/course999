package ru.kowqo.course999

import android.app.Application
import android.util.Log

class MyApplication : Application() {

    private val handleDeath = HandleDeath.Base()


    fun activityCreated(firstOpening: Boolean) {
        if (firstOpening) {
            handleDeath.firstOpening()
            Log.d("kow","First Time")
        } else {
            if (handleDeath.wasDeathHappened()) {
                Log.d("kow", "Death happened")
                handleDeath.handleDeath()
            } else {

                Log.d("kow", "just activity recreated")
            }
        }
    }
}
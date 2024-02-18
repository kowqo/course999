package ru.kowqo.course999.core

import android.app.Application
import android.util.Log

class MyApplication : Application(), ProvideRepresentative, ClearRepresentative {
    private val representativeMap = mutableMapOf<Class<out Represantative<*>>, Represantative<*>>()

    private lateinit var core: Core
    private lateinit var factory: ProvideRepresentative.Factory

    private val handleDeath = HandleDeath.Base()

    override fun onCreate() {
        super.onCreate()
        core = Core.Base(this)
        factory = ProvideRepresentative.Factory(core, this)
    }

    override fun <T : Represantative<*>> provideRepresentative(clazz: Class<T>): T {
        return if (representativeMap.containsKey(clazz)) {
            representativeMap[clazz] as T
        } else {
            val representative = factory.provideRepresentative(clazz)
            representativeMap[clazz] = representative
            representative
        }
    }

    override fun clear(clazz: Class<out Represantative<*>>) {
        representativeMap.remove(clazz)
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

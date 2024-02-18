package ru.kowqo.course999.core

import android.app.Application

class MyApplication : Application(), ProvideRepresentative, ClearRepresentative {
    private val representativeMap = mutableMapOf<Class<out Represantative<*>>, Represantative<*>>()

    private lateinit var core: Core
    private lateinit var factory: ProvideRepresentative.Factory

    override fun onCreate() {
        super.onCreate()
        core = Core.Base(this)
        factory = ProvideRepresentative.Factory(core, this)
    }

    override fun <T : Represantative<*>> provideRepresentative(clazz: Class<T>): T =
        if (representativeMap.containsKey(clazz)) {
            representativeMap[clazz] as T
        } else {
            factory.provideRepresentative(clazz).let {
                representativeMap[clazz] = it
                it
            }
        }

    override fun clear(clazz: Class<out Represantative<*>>) {
        representativeMap.remove(clazz)
    }
}

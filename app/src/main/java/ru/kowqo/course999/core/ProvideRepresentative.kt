package ru.kowqo.course999.core

import ru.kowqo.course999.dashboard.DashboardModule
import ru.kowqo.course999.dashboard.DashboardRepresentative
import ru.kowqo.course999.main.MainModule
import ru.kowqo.course999.main.MainRepresentative
import ru.kowqo.course999.subscription.SubscriptionModule
import ru.kowqo.course999.subscription.SubscriptionRepresentative
import java.lang.IllegalStateException

interface ProvideRepresentative {
    fun <T : Represantative<*>> provideRepresentative(clazz: Class<T>): T

    class Factory(
        private val core: Core,
        private val clear: ClearRepresentative,
    ) : ProvideRepresentative {
        override fun <T : Represantative<*>> provideRepresentative(clazz: Class<T>): T =
            when (clazz) {
                MainRepresentative::class.java -> MainModule(core).representative()
                DashboardRepresentative::class.java -> DashboardModule(core).representative()
                SubscriptionRepresentative::class.java ->
                    SubscriptionModule(
                        core,
                        clear,
                    ).representative()

                else -> throw IllegalStateException("unknown class $clazz")
            } as T
    }
}

package ru.kowqo.course999.subscription

import ru.kowqo.course999.core.ClearRepresentative
import ru.kowqo.course999.core.Represantative
import ru.kowqo.course999.dashboard.DashboardRepresentative
import ru.kowqo.course999.dashboard.DashboardScreen
import ru.kowqo.course999.main.Navigation
import ru.kowqo.course999.main.UserPremiumCache

interface SubscriptionRepresentative : Represantative<Unit> {
    fun subscribe()

    class Base(
        private val clear: ClearRepresentative,
        private val userPremiumCache: UserPremiumCache.Save,
        private val navigation: Navigation.Navigate,
    ) : SubscriptionRepresentative {
        override fun subscribe() {
            userPremiumCache.saveUserPremium()
            clear.clear(DashboardRepresentative::class.java)
            clear.clear(SubscriptionRepresentative::class.java)
            navigation.invoke(DashboardScreen)
        }
    }
}

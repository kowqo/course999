package ru.kowqo.course999.dashboard

import ru.kowqo.course999.core.Represantative
import ru.kowqo.course999.core.UiObserver
import ru.kowqo.course999.main.Navigation
import ru.kowqo.course999.subscription.SubscriptionScreen

interface DashboardRepresentative : Represantative<PremiumDashboardUiState> {
    fun play()

    class Base(private val navigation: Navigation.Navigate) : DashboardRepresentative {
        override fun play() = navigation.invoke(SubscriptionScreen)
    }

    class Premium(private val observable: PremiumDashboardObservable) : DashboardRepresentative {
        override fun play() {
            // todo update via observable
            observable.invoke(PremiumDashboardUiState.Playing)
        }

        override fun startGettingUpdates(callback: UiObserver<PremiumDashboardUiState>) {
            observable.updateObserver(callback)
        }

        override fun stopGettingUpdates() {
            observable.updateObserver()
        }
    }
}

package ru.kowqo.course999.main

import ru.kowqo.course999.core.Represantative
import ru.kowqo.course999.core.UiObserver

interface MainRepresentative : Represantative<Screen> {
    fun showDashboard(firstTime: Boolean)

    class Base(
        private val navigation: Navigation.Mutable,
    ) : MainRepresentative {
        override fun startGettingUpdates(observer: UiObserver<Screen>) {
            navigation.updateObserver(observer)
        }

        override fun stopGettingUpdates() = navigation.updateObserver()

        override fun showDashboard(firstTime: Boolean) {
            if (firstTime) {
                navigation.invoke(Screen.Dashboard)
            }
        }
    }
}

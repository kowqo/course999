package ru.kowqo.course999.dashboard

import ru.kowqo.course999.core.HideAndShow

interface PremiumDashboardUiState {
    fun show(
        button: HideAndShow,
        textView: HideAndShow,
    )

    object Playing : PremiumDashboardUiState {
        override fun show(
            button: HideAndShow,
            textView: HideAndShow,
        ) {
            button.hide()
            textView.show()
        }
    }
}

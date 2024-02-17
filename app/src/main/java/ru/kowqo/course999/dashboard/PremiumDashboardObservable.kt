package ru.kowqo.course999.dashboard

import ru.kowqo.course999.core.UiObservable

interface PremiumDashboardObservable : UiObservable<PremiumDashboardUiState> {
    class Base : UiObservable.Single<PremiumDashboardUiState>(), PremiumDashboardObservable
}

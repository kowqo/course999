package ru.kowqo.course999.dashboard

import ru.kowqo.course999.core.Core
import ru.kowqo.course999.core.Module
import ru.kowqo.course999.main.UserPremiumCache

class DashboardModule(private val core: Core) :
    Module<DashboardRepresentative> {
    override fun representative(): DashboardRepresentative {
        val cache =
            UserPremiumCache.Base(core.sharedPrefrerences()).isUserPremium()

        return if (cache) {
            DashboardRepresentative.Premium(PremiumDashboardObservable.Base())
        } else {
            DashboardRepresentative.Base(core.navigation())
        }
    }
}

package ru.kowqo.course999.subscription

import ru.kowqo.course999.core.ClearRepresentative
import ru.kowqo.course999.core.Core
import ru.kowqo.course999.core.Module
import ru.kowqo.course999.main.UserPremiumCache

class SubscriptionModule(private val core: Core, private val clear: ClearRepresentative) :
    Module<SubscriptionRepresentative> {
    override fun representative(): SubscriptionRepresentative =
        SubscriptionRepresentative.Base(
            clear,
            UserPremiumCache.Base(core.sharedPrefrerences()),
            core.navigation(),
        )
}

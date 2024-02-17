package ru.kowqo.course999.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.kowqo.course999.dashboard.DashboardFragment
import ru.kowqo.course999.subscription.SubscriptionFragment

interface Screen {
    fun show(
        fragmentManager: FragmentManager,
        containerId: Int,
    )

    abstract class Add(private val fragmentClass: Class<out Fragment>) : Screen {
        override fun show(
            fragmentManager: FragmentManager,
            containerId: Int,
        ) {
            fragmentManager.beginTransaction()
                .add(containerId, fragmentClass.getDeclaredConstructor().newInstance())
                .addToBackStack(fragmentClass.name)
                .commit()
        }
    }

    abstract class Replace(private val fragmentClass: Class<out Fragment>) : Screen {
        override fun show(
            fragmentManager: FragmentManager,
            containerId: Int,
        ) {
            fragmentManager.beginTransaction()
                .replace(containerId, fragmentClass.getDeclaredConstructor().newInstance())
                .commit()
        }
    }

    object Dashboard : Replace(DashboardFragment::class.java)

    object Subscription : Add(SubscriptionFragment::class.java)
}

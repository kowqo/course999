package ru.kowqo.course999.subscription

import android.os.Bundle
import android.view.View
import android.widget.Button
import ru.kowqo.course999.R
import ru.kowqo.course999.main.BaseFragment

class SubscriptionFragment :
    BaseFragment<SubscriptionRepresentative>(R.layout.fragment_subscription) {
    override val clazz = SubscriptionRepresentative::class.java

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.subscribe_button)

        button.setOnClickListener {
            representative.subscribe()
        }
    }
}

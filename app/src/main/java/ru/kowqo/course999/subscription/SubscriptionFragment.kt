package ru.kowqo.course999.subscription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.kowqo.course999.R
import ru.kowqo.course999.core.ProvideRepresentative

class SubscriptionFragment : Fragment() {
    private lateinit var representative: SubscriptionRepresentative

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        representative =
            (requireActivity() as ProvideRepresentative).provideRepresentative(
                SubscriptionRepresentative::class.java,
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_subscription, container, false)
    }

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

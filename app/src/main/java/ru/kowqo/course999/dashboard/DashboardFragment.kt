package ru.kowqo.course999.dashboard

import android.os.Bundle
import android.view.View
import ru.kowqo.course999.R
import ru.kowqo.course999.core.CustomButton
import ru.kowqo.course999.core.CustomTextView
import ru.kowqo.course999.core.UiObserver
import ru.kowqo.course999.main.BaseFragment

class DashboardFragment : BaseFragment<DashboardRepresentative>(R.layout.fragment_dashboard) {
    private lateinit var callback: UiObserver<PremiumDashboardUiState>
    override val clazz: Class<DashboardRepresentative> = DashboardRepresentative::class.java

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<CustomButton>(R.id.playButton)
        val textView = view.findViewById<CustomTextView>(R.id.showPlayingTextView)
        button.setOnClickListener {
            representative.play()
        }

        callback =
            object : UiObserver<PremiumDashboardUiState> {
                override fun invoke(data: PremiumDashboardUiState) {
                    data.show(button, textView)
                }
            }
    }

    override fun onResume() {
        super.onResume()
        representative.startGettingUpdates(callback)
    }

    override fun onPause() {
        super.onPause()
        representative.stopGettingUpdates()
    }
}

package ru.kowqo.course999.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.kowqo.course999.R
import ru.kowqo.course999.core.ProvideRepresentative
import ru.kowqo.course999.core.UiObserver

class DashboardFragment : Fragment() {
    private lateinit var representative: DashboardRepresentative
    private lateinit var callback: UiObserver<PremiumDashboardUiState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        representative =
            (requireActivity() as ProvideRepresentative).provideRepresentative(
                DashboardRepresentative::class.java,
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.playButton)
        val textView = view.findViewById<TextView>(R.id.showPlayingTextView)
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

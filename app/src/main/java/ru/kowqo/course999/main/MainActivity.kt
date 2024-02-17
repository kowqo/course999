package ru.kowqo.course999.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.kowqo.course999.R
import ru.kowqo.course999.core.MyApplication
import ru.kowqo.course999.core.UiObserver

class MainActivity : AppCompatActivity() {
    private lateinit var mainRepresentative: MainRepresentative
    private lateinit var activityCallback: ActivityCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRepresentative = (application as MyApplication).mainRepresentative

        mainRepresentative.showDashboard(savedInstanceState == null)

        activityCallback =
            object : ActivityCallback {
                override fun invoke(data: Screen) =
                    runOnUiThread {
                        data.show(supportFragmentManager, R.id.container)
                    }
            }
    }

    override fun onResume() {
        super.onResume()
        mainRepresentative.startGettingUpdates(activityCallback)
    }

    override fun onPause() {
        super.onPause()
        mainRepresentative.stopGettingUpdates()
    }
}

interface ActivityCallback : UiObserver<Screen>

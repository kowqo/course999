package ru.kowqo.course999.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.kowqo.course999.R
import ru.kowqo.course999.core.ProvideRepresentative
import ru.kowqo.course999.core.Represantative
import ru.kowqo.course999.core.UiObserver

class MainActivity : AppCompatActivity(), ProvideRepresentative {
    private lateinit var mainRepresentative: MainRepresentative
    private lateinit var activityCallback: ActivityCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRepresentative = provideRepresentative(MainRepresentative::class.java)

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

    override fun <T : Represantative<*>> provideRepresentative(clazz: Class<T>): T {
        return (application as ProvideRepresentative).provideRepresentative(clazz)
    }
}

interface ActivityCallback : UiObserver<Screen>

package ru.kowqo.course999

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainRepresentative: MainRepresentative
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)
        mainRepresentative = (application as MyApplication).mainRepresentative

        textView.setOnClickListener {
            mainRepresentative.startAsync("Hello from thread")
        }
    }

    override fun onResume() {
        super.onResume()
        mainRepresentative.startGettingUpdates(
            object : ActivityCallback {
                override fun invoke(data: String) =
                    runOnUiThread {
                        textView.text = data
                    }
            },
        )
    }

    override fun onPause() {
        super.onPause()
        mainRepresentative.stopGettingUpdates()
    }
}

interface ActivityCallback : UiObserver<String>

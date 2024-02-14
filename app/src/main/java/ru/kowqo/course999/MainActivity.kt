package ru.kowqo.course999

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var mainRepresentative: MainRepresentative
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)
        mainRepresentative = (application as MyApplication).mainRepresentative

        textView.setOnClickListener {
            Log.d("qwe", "sdsaas")
            mainRepresentative.startAsync()
        }

    }

    override fun onResume() {
        super.onResume()
        mainRepresentative.startGettingUpdates(
            object : ActivityCallback {
                override fun invoke(data: String) =
                    runOnUiThread {
                        Log.d("qwe", "here")
                        textView.text = "21321321321"
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
package hu.autsoft.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pin.*
import kotlinx.android.synthetic.main.content_pin.*

class PinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        setSupportActionBar(toolbar)

        submitPin.setOnClickListener {
            if (pinInputField.text.toString() == "7878") {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                pinInputContainer.error = getString(R.string.pin_invalid)
            }
        }
    }

}

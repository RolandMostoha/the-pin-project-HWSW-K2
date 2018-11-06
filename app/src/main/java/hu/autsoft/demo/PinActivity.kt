package hu.autsoft.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pin.*
import kotlinx.android.synthetic.main.content_pin.*

class PinActivity : AppCompatActivity() {

    private val pinValidator = PinValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        setSupportActionBar(toolbar)

        submitPin.setOnClickListener {
            val result = pinValidator.validatePin(pinInputField.text.toString())
            when (result) {
                is PinValidator.ValidationResult.Success -> startActivity(Intent(this, MainActivity::class.java))
                is PinValidator.ValidationResult.Error -> pinInputContainer.error = getString(result.messageId)
            }
        }
    }

}

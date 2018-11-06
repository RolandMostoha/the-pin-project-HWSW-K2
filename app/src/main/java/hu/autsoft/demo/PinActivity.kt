package hu.autsoft.demo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pin.*
import kotlinx.android.synthetic.main.content_pin.*

class PinActivity : AppCompatActivity() {

    private lateinit var pinValidatorApi: PinValidatorApi

    private val pinValidator = PinValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        setSupportActionBar(toolbar)

        pinValidatorApi = Injection.provideValidatorApi()

        submitPin.setOnClickListener {
            val pin = pinInputField.text.toString()
            val result = pinValidator.validatePin(pin)
            when (result) {
                is PinValidator.ValidationResult.Success -> handleSuccess(pin)
                is PinValidator.ValidationResult.Error -> pinInputContainer.error = getString(result.messageId)
            }
        }
    }

    private fun handleSuccess(pin: String) {
        pinValidatorApi.validatePin(pin) { isPinValid ->
            if (isPinValid) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                pinInputContainer.error = getString(R.string.pin_invalid)
            }
        }
    }

}

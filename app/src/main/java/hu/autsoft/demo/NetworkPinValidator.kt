package hu.autsoft.demo

import android.os.Handler
import kotlin.random.Random

class NetworkPinValidator {

    fun validatePin(pin: String, resultCallback: (Boolean) -> Unit) {
        Handler().postDelayed({
            resultCallback.invoke(Random.nextBoolean())
        }, Random.nextLong(500, 1000))
    }

}

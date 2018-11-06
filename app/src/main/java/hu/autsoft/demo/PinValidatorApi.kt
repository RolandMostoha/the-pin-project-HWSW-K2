package hu.autsoft.demo

interface PinValidatorApi {

    fun validatePin(pin: String, resultCallback: (Boolean) -> Unit)

}
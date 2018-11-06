package hu.autsoft.demo

class MockPinValidator : PinValidatorApi {

    override fun validatePin(pin: String, resultCallback: (Boolean) -> Unit) {
        resultCallback.invoke(true)
    }

}
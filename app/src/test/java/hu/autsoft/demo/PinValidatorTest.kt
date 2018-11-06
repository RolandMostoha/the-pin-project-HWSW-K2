package hu.autsoft.demo

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PinValidatorTest {

    private lateinit var pinValidator: PinValidator

    @Before
    fun setUp() {
        pinValidator = PinValidator()
    }

    @Test
    fun `Given correct PIN code, when we validate it, success result should be returned`() {
        val pin = "7878"

        val validationResult = pinValidator.validatePin(pin)

        assertEquals(PinValidator.ValidationResult.Success, validationResult)
    }

    @Test
    fun `Given incorrect PIN code, when we validate it, invalid error result should be returned`() {
        val pin = "6868"

        val validationResult = pinValidator.validatePin(pin)

        assertTrue(validationResult is PinValidator.ValidationResult.Error)
        assertEquals(R.string.pin_invalid, (validationResult as PinValidator.ValidationResult.Error).messageId)
    }

    @Test
    fun `Given not numeric PIN code, when we validate it, not numeric error result should be returned`() {
        val pin = "asdf"

        val validationResult = pinValidator.validatePin(pin)

        assertTrue(validationResult is PinValidator.ValidationResult.Error)
        assertEquals(R.string.pin_not_numeric, (validationResult as PinValidator.ValidationResult.Error).messageId)
    }

}
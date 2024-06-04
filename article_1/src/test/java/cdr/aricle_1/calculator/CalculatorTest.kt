package cdr.aricle_1.calculator

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * Тест для [Calculator]
 */
internal class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun `5 plus 3 equal 8`() {
        // arrange
        val firstNumber = 5.0
        val secondNumber = 3.0
        val expected = 8.0

        // act
        val actual = calculator.calculateTwoNumbers(firstNumber, secondNumber)

        // assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `5 plus 3 not equal 10`() {
        // arrange
        val firstNumber = 5.0
        val secondNumber = 3.0
        val expected = 10.0

        // act
        val actual = calculator.calculateTwoNumbers(firstNumber, secondNumber)

        // assert
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    fun `10 subtract 3 equal 7`() {
        // arrange
        val firstNumber = 10.0
        val secondNumber = 3.0
        val expected = 7.0

        // act
        val actual = calculator.subtractTwoNumbers(firstNumber, secondNumber)

        // assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `12 subtract 5 not equal 8`() {
        // arrange
        val firstNumber = 12.0
        val secondNumber = 5.0
        val expected = 8.0

        // act
        val actual = calculator.subtractTwoNumbers(firstNumber, secondNumber)

        // assert
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    fun `5 multiply 5 equal 25`() {
        // arrange
        val firstNumber = 5.0
        val secondNumber = 5.0
        val expected = 25.0

        // act
        val actual = calculator.multiplyTwoNumbers(firstNumber, secondNumber)

        // assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `6 multiply 8 not equal 46`() {
        // arrange
        val firstNumber = 6.0
        val secondNumber = 8.0
        val expected = 46.0

        // act
        val actual = calculator.multiplyTwoNumbers(firstNumber, secondNumber)

        // assert
        assertThat(actual).isNotEqualTo(expected)
    }

    @Test
    fun `15 divide 5 equals 3`() {
        val firstNumber = 15.0
        val secondNumber = 5.0
        val expected = 3.0

        val actual = calculator.divideTwoNumbers(firstNumber, secondNumber)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `cannot divide by zero`() {
        val firstNumber = 15.0
        val secondNumber = 0.0
        val expectedMessage = "Делить на ноль нельзя!"

        assertThrows<ArithmeticException> {
            calculator.divideTwoNumbers(firstNumber, secondNumber)
        }.also { exception ->
            assertThat(exception.message).isEqualTo(expectedMessage)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1.0, 2.0, 3.0",
        "-1.0, 1.0, 0.0",
        "0.0, 0.0, 0.0",
        "10.0, -5.0, 5.0"
    )
    fun `calculateTwoNumbers using parameterized test`(first: Double, second: Double, expected: Double) {
        val actual = calculator.calculateTwoNumbers(first, second)

        assertThat(actual).isEqualTo(expected)
    }
}
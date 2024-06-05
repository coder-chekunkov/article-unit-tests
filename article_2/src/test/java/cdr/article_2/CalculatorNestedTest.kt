package cdr.article_2

import com.google.common.truth.Truth
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Вложенные тесты для [Calculator]
 */
internal class CalculatorNestedTest {

    private val calculator = Calculator()

    @Nested
    inner class CalculatorCalculateTest {

        @Test
        fun `5 calculate 3 equal 8`() {
            // arrange
            val firstNumber = 5.0
            val secondNumber = 3.0
            val expected = 8.0

            // act
            val actual = calculator.calculateTwoNumbers(firstNumber, secondNumber)

            // assert
            Truth.assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `5 calculate 3 not equal 10`() {
            // arrange
            val firstNumber = 5.0
            val secondNumber = 3.0
            val expected = 10.0

            // act
            val actual = calculator.calculateTwoNumbers(firstNumber, secondNumber)

            // assert
            Truth.assertThat(actual).isNotEqualTo(expected)
        }
    }

    @Nested
    inner class CalculatorSubtractTest {

        @Test
        fun `10 subtract 3 equal 7`() {
            // arrange
            val firstNumber = 10.0
            val secondNumber = 3.0
            val expected = 7.0

            // act
            val actual = calculator.subtractTwoNumbers(firstNumber, secondNumber)

            // assert
            Truth.assertThat(actual).isEqualTo(expected)
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
            Truth.assertThat(actual).isNotEqualTo(expected)
        }
    }

    @Nested
    inner class CalculatorMultiplyTest {

        @Test
        fun `5 multiply 5 equal 25`() {
            // arrange
            val firstNumber = 5.0
            val secondNumber = 5.0
            val expected = 25.0

            // act
            val actual = calculator.multiplyTwoNumbers(firstNumber, secondNumber)

            // assert
            Truth.assertThat(actual).isEqualTo(expected)
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
            Truth.assertThat(actual).isNotEqualTo(expected)
        }
    }

    @Nested
    inner class CalculatorDivideTest {

        @Test
        fun `15 divide 5 equals 3`() {
            // arrange
            val firstNumber = 15.0
            val secondNumber = 5.0
            val expected = 3.0

            // act
            val actual = calculator.divideTwoNumbers(firstNumber, secondNumber)

            // assert
            Truth.assertThat(actual).isEqualTo(expected)
        }

        @Test
        fun `cannot divide by zero`() {
            // arrange
            val firstNumber = 15.0
            val secondNumber = 0.0
            val expectedMessage = "Делить на ноль нельзя!"

            // act
            assertThrows<ArithmeticException> {
                calculator.divideTwoNumbers(firstNumber, secondNumber)
            }.also { exception ->
                Truth.assertThat(exception.message).isEqualTo(expectedMessage)
            }
        }
    }
}
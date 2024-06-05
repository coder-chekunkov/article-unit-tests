package cdr.article_2

import com.google.common.truth.Truth
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.condition.EnabledIf
import org.junit.jupiter.api.condition.EnabledOnJre
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.JRE

/**
 * Условное выполнение тестов для [Calculator]
 */
internal class CalculatorConditionalTest {

    private val calculator = Calculator()

    // Тест запуститься только на операционной системе MacOS
    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.MAC)
    fun `test for mac os`() {
        // arrange
        val firstNumber = 6.0
        val secondNumber = 8.0
        val expected = 48.0

        // act
        val actual = calculator.multiplyTwoNumbers(firstNumber, secondNumber)

        // assert
        Truth.assertThat(actual).isEqualTo(expected)
    }

    // Тест запуститься только на версии Java 11
    @Test
    @EnabledOnJre(JRE.JAVA_11)
    fun `test for Java 11`() {
        // arrange
        val firstNumber = 10.0
        val secondNumber = 3.0
        val expected = 7.0

        // act
        val actual = calculator.subtractTwoNumbers(firstNumber, secondNumber)

        // assert
        Truth.assertThat(actual).isEqualTo(expected)
    }

    // Тест запуститься только при выполнении какого-то кастомного условия
    // ВАЖНО ОТМЕТИТЬ: в аннотациии необходимо указывать полный путь к методу
    @Test
    @EnabledIf("cdr.article_2.CalculatorConditionalTest#isCustomCondition")
    fun `test with custom condition`() {
        val firstNumber = 15.0
        val secondNumber = 0.0
        val expectedMessage = "Делить на ноль нельзя!"

        assertThrows<ArithmeticException> {
            calculator.divideTwoNumbers(firstNumber, secondNumber)
        }.also { exception ->
            Truth.assertThat(exception.message).isEqualTo(expectedMessage)
        }
    }

    private fun isCustomCondition(): Boolean = true

}
package cdr.article_2

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

/**
 * Параметризированные тесты для [Calculator]
 */
internal class CalculatorParameterizedTest {

    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(
        "1.0, 2.0, 3.0",
        "-1.0, 1.0, 0.0",
        "0.0, 0.0, 0.0",
        "10.0, -5.0, 5.0"
    )
    fun `parameterized calculate test`(first: Double, second: Double, expected: Double) {
        val actual = calculator.calculateTwoNumbers(first, second)

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "15.0, 22.0, -7.0",
        "-1.0, -1.0, 0.0",
        "0.0, 0.0, 0.0"
    )
    fun `parameterized subtract test`(first: Double, second: Double, expected: Double) {
        val actual = calculator.subtractTwoNumbers(first, second)

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ArgumentsSource(DivisionArgumentsProvider::class)
    fun `parameterized divide test`(first: Double, second: Double, expected: Double) {
        val actual = calculator.divideTwoNumbers(first, second)

        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForMultiplication")
    fun `parameterized multiply test`(first: Double, second: Double, expected: Double) {
        val actual = calculator.multiplyTwoNumbers(first, second)

        assertThat(actual).isEqualTo(expected)
    }

    class DivisionArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<Arguments> = Stream.of(
            Arguments.of(6.0, 3.0, 2.0),
            Arguments.of(10.0, 2.0, 5.0),
            Arguments.of(-4.0, 2.0, -2.0),
            Arguments.of(0.0, 1.0, 0.0)
        )
    }

    companion object {
        @JvmStatic
        fun provideNumbersForMultiplication() = listOf(
            Arguments.of(2.0, 3.0, 6.0),
            Arguments.of(-1.0, 1.0, -1.0),
            Arguments.of(0.0, 5.0, 0.0),
            Arguments.of(-2.0, -2.0, 4.0)
        )
    }
}
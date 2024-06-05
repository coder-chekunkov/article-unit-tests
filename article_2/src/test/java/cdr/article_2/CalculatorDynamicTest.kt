package cdr.article_2

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

/**
 * Динамические тесты для [Calculator]
 */
internal class CalculatorDynamicTest {

    private val calculator = Calculator()

    @TestFactory
    fun `dynamic test`(): List<DynamicTest> {
        val testData = listOf(
            Triple(2.0, 2.0, 4.0),
            Triple(-1.0, 1.0, 0.0),
            Triple(5.0, -6.0, -1.0)
        )

        return testData.map { (first, second, expected) ->
            DynamicTest.dynamicTest("Test $first + $second = $expected") {

                val actual = calculator.calculateTwoNumbers(first, second)

                assertThat(actual).isEqualTo(expected)
            }
        }
    }
}

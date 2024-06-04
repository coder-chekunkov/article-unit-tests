package cdr.aricle_1.calculator

/**
 * Класс калькулятор, который используется для выполнения операций над числами. <br/>
 *
 * Существует четыре основных метода:
 *  - [calculateTwoNumbers] - операция сложения
 *  - [subtractTwoNumbers] - операция вычитания
 *  - [multiplyTwoNumbers] - операция умножения
 *  - [divideTwoNumbers] - операция деления (при делении на ноль получаем ArithmeticException).
 */
internal class Calculator {

    fun calculateTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber + secondNumber
    }

    fun subtractTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber - secondNumber
    }

    fun multiplyTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber * secondNumber
    }

    fun divideTwoNumbers(firstNumber: Double, secondNumber: Double): Double {
        if (secondNumber == 0.0) throw ArithmeticException("Делить на ноль нельзя!")
        return firstNumber / secondNumber
    }
}
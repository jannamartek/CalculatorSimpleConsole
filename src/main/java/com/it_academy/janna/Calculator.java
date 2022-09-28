package com.it_academy.janna;


public class Calculator {
    public static double addition(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtraction(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiplication(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double division(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Division by 0 can't be done");
        } else
            return firstNumber / secondNumber;
    }

    public static double calculate(double numberOne, double numberTwo, char operation) {
        double answer;

        switch (operation) {
            case '+':
                answer = addition(numberOne, numberTwo);
                break;
            case '-':
                answer = subtraction(numberOne, numberTwo);
                break;
            case '*':
                answer = multiplication(numberOne, numberTwo);
                break;
            case '/':
                answer = division(numberOne, numberTwo);
                break;
            default:
                System.out.println("Error enter the operand. Please, try again.");
                answer = calculate(numberOne, numberTwo, CalculatorUserActions.getOperand());
        }
        return answer;
    }
}


package com.it_academy.janna;

import java.util.Locale;
import java.util.Scanner;

public class CalculatorUserActions {
    public static double getNumber() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Error enter the number. Please, try again.");
            scanner.next();
            number = getNumber();
        }
        return number;
    }

    public static char getOperand() {
        Scanner scanner = new Scanner(System.in);
        char operand;
        if (scanner.hasNext()) {
            operand = scanner.next().charAt(0);
        } else {
            System.out.println("Error enter the operand. Please, try again.");
            return getOperand();
        }
        return operand;
    }

    public static double getUserInput() {
        System.out.println("Enter the first number: ");
        double numberOne = getNumber();
        System.out.println("Enter operator (+, -, *, /):");
        char operation = getOperand();
        System.out.println("Enter the second number: ");
        double numberTwo = getNumber();
        double answer = Calculator.calculate(numberOne, numberTwo, operation);
        System.out.println("Answer: " + answer);
        return numberOne;
    }

    public static void printWelcomeMessage() {
        System.out.println("Welcome to the console calculator !");
        System.out.println("Available operations: ");
        System.out.println("Addition(+), Subtraction(-), Multiplication(*), Division(/),");
        System.out.println();
    }

    public static void getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("Do you wish to continue? (Y/N)");
        String userChoice = scanner.next();
        while (true) {
            if (userChoice.equalsIgnoreCase("N")) {
                System.out.println("Bye Bye!");
                break;
            } else {
                if (userChoice.equalsIgnoreCase("Y")) {
                    getUserInput();
                    getUserChoice();
                }
            }
        }
    }
}



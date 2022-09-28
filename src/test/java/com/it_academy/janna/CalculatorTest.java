package com.it_academy.janna;

import org.testng.Assert;

import org.testng.annotations.*;


public class CalculatorTest extends AnnotationTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "additionDataProvider")
    public Object[][] additionLocalData() {
        return new Object[][]{
                {0, 0, 0},
                {86, 63, 149},
                {-25, 15, -10.0},
                {-856, -625, -1481.0},
                {-8.65, -6.25, -14.9},
                {-2.3, 2, -0.2999999999999998},
                {61.08, 1269, 1330.08,},};
    }

    @Test(dataProvider = "additionDataProvider", groups = {"Regression"})
    public void testAddition(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.addition(firstNumber, secondNumber), expected);
    }

    @DataProvider(name = "subtractionDataProvider")
    public Object[][] subtractionLocalData() {
        return new Object[][]{
                {0, 0, 0},
                {86, 63, 23.0},
                {-25, 15, -40.0},
                {-856, -625, -231.0},
                {-8.65, -6.25, -2.4000000000000004},
                {-2.2, 2, -4.2},
                {61.08, 1269, -1207.92},
                {3000, 7000, -4000.0},};
    }

    @Test(dataProvider = "subtractionDataProvider", groups = {"Regression"})
    public void testSubtraction(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.subtraction(firstNumber, secondNumber), expected);
    }

    @DataProvider(name = "multiplicationDataProvider")
    public Object[][] multiplicationLocalData() {
        return new Object[][]{
                {0, 0, 0},
                {86, 63, 5418.0},
                {-25, 15, -375.0},
                {-856, -625, 535000.0},
                {-8.65, -6.25, 54.0625},
                {-2.9, 2, -5.8},
                {61.08, 1269, 77510.52},
                {3000, 7000, 21000000},};
    }

    @Test(dataProvider = "multiplicationDataProvider", groups = {"Regression"})
    public void testMultiplication(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.multiplication(firstNumber, secondNumber), expected);
    }

    @DataProvider(name = "divisionDataProvider")
    public Object[][] divisionLocalData() {
        return new Object[][]{
                {86, 63, 1.3650793650793651},
                {-25, 15, -1.6666666666666667},
                {-856, -625, 1.3696},
                {-8.65, -6.25, 1.3840000000000001},
                {-2, 2, -1.0},
                {61.08, 1269, 0.04813238770685579},
                {3000, 7000, 0.42857142857142855},};
    }

    @Test(dataProvider = "divisionDataProvider", groups = {"Regression"})
    public void testDivision(double firstNumber, double secondNumber, double expected) {
        Assert.assertEquals(calculator.division(firstNumber, secondNumber), expected);
    }

    @DataProvider(name = "divisionByZeroDataProvider")
    public Object[][] exceptionDivisionByZeroLocalData() {
        return new Object[][]{
                {0, 0, '/', "Division by 0 can't be done"},
                {-10, 0, '/', "Division by 0 can't be done"},};
    }

    @Test(dataProvider = "divisionByZeroDataProvider", groups = {"Regression"}, expectedExceptions = ArithmeticException.class)
    public void testExceptionDivisionByZero(double numberOne, double numberTwo, char operation, String result) throws ArithmeticException {
        Assert.assertEquals(calculator.calculate(numberOne, numberTwo, operation), result, "Division by 0 can't be done");
    }

    @DataProvider(name = "testBorderDataProvider")
    public Object[][] borderLocalData() {
        return new Object[][]{
                {Integer.MAX_VALUE, 1, '+', 2.147483648E9},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, '+', 4.294967294E9},
                {Integer.MAX_VALUE, 1.5, '+', 2.1474836485E9},
                {Double.MAX_VALUE, 1, '+', 1.7976931348623157E308},
                {Double.MAX_VALUE, Double.MAX_VALUE, '+', 999999999},


                {Integer.MAX_VALUE, 1, '-', 2.147483646E9},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, '-', 0},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, '-', 0.0},
                {Integer.MAX_VALUE, Double.MAX_VALUE, '-', -1.7976931348623157E308},
                {Double.MIN_VALUE, 1, '-', -1.0},
                {Double.MIN_VALUE, Double.MIN_VALUE, '-', 0.0},
                {Double.MAX_VALUE, Integer.MAX_VALUE, '-', 1.7976931348623157E308},


                {Integer.MAX_VALUE, 1, '/', 2.147483647E9},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, '/', 1.0},
                {Integer.MAX_VALUE, Double.MIN_VALUE, '/', 999999999},
                {Double.MAX_VALUE, 1, '/', 1.7976931348623157E308},
                {Double.MAX_VALUE, Double.MAX_VALUE, '/', 1.0},
                {Double.MAX_VALUE, Integer.MAX_VALUE, '/', 8.371160997540839E298},


                {Integer.MAX_VALUE, 1, '*', 2.147483647E9},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, '*', 4.6116860141324206E18},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, '*', 4.611686018427388E18},
                {Integer.MAX_VALUE, Double.MAX_VALUE, '*', 999999999},
                {Double.MIN_VALUE, 1, '*', 4.9E-324},
                {Double.MIN_VALUE, Double.MIN_VALUE, '*', 0.0},
                {Double.MAX_VALUE, Integer.MAX_VALUE, '*', 999999999},};
    }

    @Test(dataProvider = "testBorderDataProvider", groups = {"Regression"})
    public void testBorder(double numberOne, double numberTwo, char operation, double result) {
        Assert.assertEquals(calculator.calculate(numberOne, numberTwo, operation), result , "Infinity");
    }
}

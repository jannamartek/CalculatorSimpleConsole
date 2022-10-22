package com.it_academy.janna;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;


public class CalculatorUserActionsTest extends AnnotationTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "getOperandErrorMessageDataProvider")
    public Object[][] getOperandErrorMessageLocalData() {
        return new Object[][]{
                {12, 1.2, ')', "Error enter the operand. Please, try again."},
                {46, -45, '=', "Error enter the operand. Please, try again."},};
    }

    @Test(dataProvider = "getOperandErrorMessageDataProvider", groups = {"Regression"},
            timeOut = 100, expectedExceptions = ThreadTimeoutException.class)
    public void testGetOperandErrorMessage(double numberOne, double numberTwo, char operation, String result) throws Exception {
        System.out.println("ExpectedExceptions = ThreadTimeoutException");
        Assert.assertEquals(calculator.calculate(numberOne, numberTwo, operation), result);
        Thread.sleep(99);
    }

    @DataProvider(name = "getUserInputNumberErrorMessageDataProvider")
    public Object[][] getUserInputNumberErrorMessageLocalData() {
        return new Object[][]{
                {"fv", 1.2, '*', "Error enter the number. Please, try again."},};
    }

    @Test(dataProvider = "getUserInputNumberErrorMessageDataProvider", groups = {"Regression"},
            expectedExceptions = NumberFormatException.class)
    public void testGetUserInputNumberErrorMessage(String numberOne, double numberTwo, char operation, String result) throws NumberFormatException {
        Assert.assertEquals(calculator.calculate(Double.parseDouble(numberOne), numberTwo, operation), result);

    }
}



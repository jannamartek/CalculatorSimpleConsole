package com.it_academy.janna;

import org.testng.annotations.*;

import java.lang.reflect.Method;

public class AnnotationTest {
    protected Calculator calculator;

    @BeforeSuite(description = "Before suite preparations")
    public void beforeSuite() {
        System.out.println("Suite started");
        System.out.println();
    }

    @BeforeClass(description = "Before class preparations")
    public void beforeClass() {
        System.out.println("Class started: " + getClass());
        System.out.println("Create instance of Calculator");
        calculator = new Calculator();
        System.out.println();
    }

    @BeforeGroups(description = "Before groups preparations", value = {"Regression"})
    public void beforeGroup() {
        System.out.println();
    }

    @BeforeMethod(description = "Before method preparations")
    public void beforeMethod(Method method) {
        String testName = method.getName();
        System.out.println("Method started: " + testName);
    }

    @AfterMethod(description = "After method preparations")
    public void afterMethod(Method method) {
        String testName = method.getName();
        System.out.println("Method finished: " + testName);
    }

    @AfterClass(description = "After class preparations")
    public void afterClass() {
        System.out.println("Class finished: " + getClass());
        System.out.println();
    }

    @AfterSuite(description = "After suite preparations")
    public void afterSuite() {
        System.out.println("Suite finished");
        System.out.println();
    }
}



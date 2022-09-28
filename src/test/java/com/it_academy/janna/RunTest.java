package com.it_academy.janna;

import org.testng.TestNG;


import java.util.ArrayList;
import java.util.List;

public class RunTest {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = new ArrayList<String>();

        suites.add("calculator.RegressionTest1.xml");
        suites.add("calculator.RegressionTest2.xml");
        testng.setTestSuites(suites);
        testng.run();

    }
}


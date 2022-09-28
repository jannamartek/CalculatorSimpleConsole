package com.it_academy.janna;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.jq.ResultsByClass;


public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("START TEST " + result.getMethod().getMethodName());
        System.out.println();
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " PASSED ");
        System.out.println();
    }

    // When Test case get failed, this method is called.
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " FAILURE ");
        System.out.println();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " SKIPPED ");
        System.out.println();
    }
}

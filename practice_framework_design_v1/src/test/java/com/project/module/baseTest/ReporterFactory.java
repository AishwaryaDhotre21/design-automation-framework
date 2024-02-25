package com.project.module.baseTest;

import com.aventstack.extentreports.ExtentTest;

public class ReporterFactory {
    ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<ExtentTest>();
    private ReporterFactory(){}
    private static ReporterFactory reporterFactoryInstance=new ReporterFactory();

    public static ReporterFactory getReporterFactoryInstance() {
        return reporterFactoryInstance;
    }

    public ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    public void setExtentTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }
}

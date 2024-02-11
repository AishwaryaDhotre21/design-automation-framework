package com.mystore.utills;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class GenerateExtentReport {
    protected ExtentSparkReporter sparkReporter;
    protected ExtentReports extent;
    public void createReport()
    {
        String htmlFile=System.getProperty("user.dir") + File.separator + "extentReport" + File.separator +"index.html";
        sparkReporter = new ExtentSparkReporter(htmlFile);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("AutomationReport");
        sparkReporter.config().setReportName("Automation test Results");
    }
    public ExtentReports getExtent()
    {
         return extent;
    }
}

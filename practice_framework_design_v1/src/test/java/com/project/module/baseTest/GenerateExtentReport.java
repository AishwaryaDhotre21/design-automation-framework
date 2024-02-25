package com.project.module.baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateExtentReport {
    private ExtentSparkReporter extentSparkReporter;
    private static ExtentReports extentReports;
    public void createExtentSparkReport()
    {
        LocalDateTime currentDateTime= LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String formattedDateTime=currentDateTime.format(formatter);
        extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator + "report" + File.separator +"ExtentReport-"+formattedDateTime+".html") ;
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("Automation-Report");
        extentSparkReporter.config().setReportName("Automation Report");
    }
    public ExtentReports getExtentReports()
    {
        return extentReports;
    }
}

package com.bugraptors.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.bugraptors.base.TestBaseClass.getDriver;

public class AllureListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(AllureListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void saveScreenShot(String fileName) {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File scr = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr, new File(System.getProperty("user.dir") + "/screenshot/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("I am in onFinish method " + iTestContext.getName());
    }

    public void onTestStart(ITestResult iTestResult) {
        logger.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        logger.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
        saveScreenShot(getTestMethodName(iTestResult));
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/screenshot/" + getTestMethodName(iTestResult) + ".png");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Allure.addAttachment("Failed Test Screenshot", inputStream);
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
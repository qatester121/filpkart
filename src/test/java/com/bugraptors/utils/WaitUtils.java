/*
@ Vipin
*/

package com.bugraptors.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.bugraptors.base.TestBaseClass.getDriver;

public class WaitUtils {


    public static void waitForElementClickable(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void threadWait(int countSecond) {
        try {
            Thread.sleep(countSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void waitForPageTitle(String title) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitForElementVisibility(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

}

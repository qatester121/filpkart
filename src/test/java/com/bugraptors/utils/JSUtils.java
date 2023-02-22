package com.bugraptors.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.bugraptors.base.TestBaseClass.getDriver;

public class JSUtils {
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click()", element);
    }

    public static JavascriptExecutor getJSExecutor(){
        return ((JavascriptExecutor)getDriver());
    }

    public static void jsScrollToTop() {
        getJSExecutor().executeScript("window.scrollTo(0, 0);");
    }

    public static void jsScrollToBottom() {
        getJSExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void jsScrollToElement(WebElement webElement) {
        getJSExecutor().executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
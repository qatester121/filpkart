package com.bugraptors.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.bugraptors.base.TestBaseClass.getDriver;

public class WebUtils {

    private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);
public static void hoverOnElectronicsLnk(WebElement element){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(element).build().perform();
}

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click()", element);
    }

    public static JavascriptExecutor getJSExecutor(){
        return ((JavascriptExecutor)getDriver());
    }
}

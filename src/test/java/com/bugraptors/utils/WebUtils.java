package com.bugraptors.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

import static com.bugraptors.base.TestBaseClass.getDriver;

public class WebUtils {

    private static final Logger logger = LoggerFactory.getLogger(WebUtils.class);

    public static void switchWindowByIndex(int index) {
        int startIndex = 0;
        Set<String> tabs = getDriver().getWindowHandles();
        for (String tab : tabs){
            if (startIndex == index){
                getDriver().switchTo().window(tab);
                break;
            }
            startIndex++;
        }
    }

    public static void switchWindowByTitle(String title) {
        Set<String> tabs = getDriver().getWindowHandles();
        Iterator<String> tabsIterators = tabs.iterator();
        while (tabsIterators.hasNext()) {
            String tab = tabsIterators.next();
            getDriver().switchTo().window(tab);
            if (getDriver().getTitle().trim().equalsIgnoreCase(title)) {
                break;

            }
        }
    }
public static void hoverOnElectronicsLnk(WebElement element){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(element).build().perform();
}
}

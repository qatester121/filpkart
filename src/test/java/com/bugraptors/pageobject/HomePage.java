package com.bugraptors.pageobject;

import com.bugraptors.utils.WebUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.bugraptors.base.TestBaseClass.getDriver;
import static com.bugraptors.utils.JSUtils.jsClick;
import static com.bugraptors.utils.WaitUtils.waitForElementClickable;
import static com.bugraptors.utils.WaitUtils.waitForElementVisibility;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "._2KpZ6l._2doB4z")
    private WebElement login_popup;

    public void closeLoginPopup() {
        login_popup.click();
    }

    @FindBy(xpath = "//div[@class='_1bEAQy _2iN8uD']//img[@class='_2OHU_q aA9eLq' and @alt='Sofas']")
    private WebElement sofasBanner;

    public void clickOnSofasBanner() {
        waitForElementVisibility(sofasBanner);
        waitForElementClickable(sofasBanner);
        jsClick(sofasBanner);
    }

    @FindBy(css = "._1kidPb span._2I9KP_:nth-child(1)")
    private WebElement electronicsLnk;

    public void hoverOnElectronicsLnk() {
        WebUtils.hoverOnElectronicsLnk(electronicsLnk);
    }

    @FindBy(css = "._1fwVde:nth-child(1) a._3QN6WI._1MMnri._32YDvl~a")
    private List<WebElement> mobileBrands;

    public List getMobileBrands() {
        String txt = null;
        List list = new ArrayList<>();
        for (WebElement w : mobileBrands) {
            txt = w.getText();
            list.add(txt);
        }
        return list;
    }
}
/*
@ vipin
*/

package com.bugraptors.tests;

import com.bugraptors.base.TestBaseClass;
import com.bugraptors.utils.AllureListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({AllureListener.class})
public class HomeTest extends TestBaseClass {

    private static final Logger logger = LogManager.getLogger(HomeTest.class);

    @Test
    public void printAllElementOfElectronics() {
        homePage.closeLoginPopup();
        homePage.clickOnSofasBanner();
        homePage.hoverOnElectronicsLnk();
        List s = homePage.getMobileBrands();
        for (int i = 0; i < s.size(); i++) {
            logger.info(s.get(i));
        }
    }
}
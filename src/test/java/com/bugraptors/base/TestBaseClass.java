package com.bugraptors.base;

import com.bugraptors.pageobject.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBaseClass {

    public static Properties properties;
    private static WebDriver driver;
    public static FileReader fileReader;
    private static final Logger logger = LogManager.getLogger(TestBaseClass.class);
    public static HomePage homePage;


    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void loadData() {
        loadPropertiesFile();
    }

    @BeforeMethod
    public void openApplication() {
        launchBrowser();
        logger.info("open url - "+properties.getProperty("URL"));
        getDriver().get(properties.getProperty("URL"));
        homePage = new HomePage();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
    public void loadPropertiesFile() {

        try {
            fileReader = new FileReader("src/test/resources/QA.properties");
            properties = new Properties();
            properties.load(fileReader);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void launchBrowser() {
        logger.info("browser name is - "+properties.getProperty("BrowserName"));
        if (properties.getProperty("BrowserName").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.logfile", "./logs/chromeLogs.txt");
            driver = new ChromeDriver();
        } else if (properties.getProperty("BrowserName").equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./logs/FirefoxLogs.txt");
            options.setLogLevel(FirefoxDriverLogLevel.TRACE);
            driver = new FirefoxDriver(options);
        } else if (properties.getProperty("BrowserName").equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
           throw new RuntimeException("Invalid Browser name - "+properties.getProperty("BrowserName"));
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }
}
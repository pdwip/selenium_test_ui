package com.hmh.technicalTest.ui.config;

import com.hmh.technicalTest.dto.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Arrays;

public class DriverBase {

    private RemoteWebDriver driver;
    private final String DRIVER_PATH_BASE = "src/test/resources/";

    public RemoteWebDriver setupDriver(Browser browser){

        if(browser.getName().equalsIgnoreCase("chrome")){
          driver = initChromeDriver(browser);
        }else {
            driver = initFirefoxDriver(browser);
        }

        driver.manage().window().maximize();
        return driver;
    }

    private RemoteWebDriver initChromeDriver(Browser browser){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");

        String driverPath = DRIVER_PATH_BASE+ browser.getDriverLocation();
        System.setProperty(browser.getWebDriverProperty(), driverPath);
        return new ChromeDriver(options);
    }

    private RemoteWebDriver initFirefoxDriver(Browser browser){
        String driverPath = DRIVER_PATH_BASE+ browser.getDriverLocation();
        System.setProperty(browser.getWebDriverProperty(), driverPath);
        return new FirefoxDriver();
    }

    public void closeDriver(RemoteWebDriver driver){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

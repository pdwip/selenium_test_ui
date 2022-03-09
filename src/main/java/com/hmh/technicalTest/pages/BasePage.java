package com.hmh.technicalTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {

    RemoteWebDriver driver;

    protected Duration EXPLICIT_WAIT = Duration.ofSeconds(15);
    protected Duration IMPLICIT_WAIT = Duration.ofSeconds(15);

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
    }

    protected String clickOnGivenElementAndReturnPageLink(WebElement element){
        element.click();
        return driver.getCurrentUrl();
    }

    protected WebDriverWait explicitWait(){
        return new WebDriverWait(driver, EXPLICIT_WAIT);
    }

    protected void fluentWait(WebElement webElement){
        FluentWait<RemoteWebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}

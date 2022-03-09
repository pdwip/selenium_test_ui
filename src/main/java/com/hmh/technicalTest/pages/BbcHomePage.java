package com.hmh.technicalTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BbcHomePage extends BasePage {

    public BbcHomePage(RemoteWebDriver driver) {
        super(driver);
    }

    //page elements

    @FindBy(id = "orb-nav-links")
    WebElement topNavigation;

    @FindBy(tagName = "a")
    WebElement links;

    @FindBy(xpath = "/html/body/div[8]/div[2]/div[1]/div[2]/div[2]/button[1]/p")
    WebElement consentButton;

    @FindBy(xpath = "//*[@id='page']/section[2]/h2")
    WebElement header2;

    @FindBy(xpath = "//*[text()='News']")
    WebElement newsTab;

    @FindBy(id = "orbit-search-button")
    WebElement searchButton;

    @FindBy(id = "search-input")
    WebElement searchInput;


    //page actions

    public List<String> validateNavigationBar() {
        List<WebElement> navigationLinks = topNavigation.findElements(By.tagName("a"));

        Iterator<WebElement> it = navigationLinks.iterator();

        List<String> expectedUrls = new ArrayList<>();
        String url = "";
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            expectedUrls.add(url);
            System.out.println("url:: " + url);
        }
        return expectedUrls;
    }

    public void giveConsent() {
        consentButton.click();
    }

    public String getDateAndTime() {
        fluentWait(header2);
        String text = header2.getText();
        String date = text.split("\n")[1];
        return date;
    }

    public String clickNewsTab() {
        String url = newsTab.getAttribute("href");
        newsTab.click();
        return url;
    }

    public SearchResultPage performSearch(String searchString) {
        searchButton.click();
        searchInput.sendKeys(searchString);
        return new SearchResultPage(driver);
    }
}

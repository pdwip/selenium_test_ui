package com.hmh.technicalTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(RemoteWebDriver driver){
        super(driver);
    }

    //page actions

    public List<String> getSearchResultLinks(){
        List<WebElement> navigationLinks = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = navigationLinks.iterator();

        List<String> expectedUrls = new ArrayList<>();
        String url = "";
        while (it.hasNext()){
            url = it.next().getAttribute("href");
            expectedUrls.add(url);
            System.out.println("url:: "+url);
        }
        return expectedUrls;
    }
}

package com.hmh.technicalTest.ui.helpers;

import io.qameta.allure.Step;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestFlowHelpers {

    private final int SUCCESS_RESPONSE_CODE = 200;

    //assert date and time

    @Step("Check the navigation links")
    public void validateBrokenLinks(List<String> navigationLinks, String homePageUrl){
        HttpURLConnection huc = null;
        for(String url: navigationLinks){
            if(url == null || url.isEmpty()){
                System.out.println("url is not configured to the anchor tag!!!");
                continue;
            } if(! url.startsWith(homePageUrl)){
                System.out.println("Belongs to other domain!!!");
                continue;
            }
            try{
                huc = (HttpURLConnection) new URL(url).openConnection();
                huc.setRequestMethod("HEAD");
                huc.connect();
                int responseCode = huc.getResponseCode();
                assertThat("The "+url+" is broken", responseCode, is(SUCCESS_RESPONSE_CODE));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Step("Validating the results")
    public void assertResultsAreSame(Object expectedResult, Object actualResult){
        assertThat("expected result not match with actual result", actualResult,is(expectedResult));
    }
}

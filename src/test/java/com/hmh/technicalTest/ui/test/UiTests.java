package com.hmh.technicalTest.ui.test;

import com.hmh.technicalTest.pages.SearchResultPage;
import com.hmh.technicalTest.ui.config.TestBase;
import com.hmh.technicalTest.ui.helpers.CommonHelpers;
import com.hmh.technicalTest.ui.helpers.TestFlowHelpers;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;


public class UiTests extends TestBase {

    private TestFlowHelpers testFlowHelpers = new TestFlowHelpers();
    private CommonHelpers commonHelpers = new CommonHelpers();

    @Description("Test the navigation links are not broken")
    @Test
    public void validateNavigationBar(){
        //verify top navigation links
       List<String> navigationLinks = bbcHomePageThreadLocal.get().validateNavigationBar();
       testFlowHelpers.validateBrokenLinks(navigationLinks, BASE_URL);
    }

    @Description("Validate date and time on the page")
    @Test
    public void validateDate(){
        //verify time and date on the page
        String date = bbcHomePageThreadLocal.get().getDateAndTime();
        testFlowHelpers.assertResultsAreSame(date.toLowerCase(), commonHelpers.getCurrentDateAndTime().toLowerCase());
    }

    @Description("Check news tab is correct")
    @Test
    public void testNewsTab(){
        //navigate to news and verify the url is correct
        String expectedUrl = bbcHomePageThreadLocal.get().clickNewsTab();
        String currentUrl = driverThreadLocal.get().getCurrentUrl();
        testFlowHelpers.assertResultsAreSame(expectedUrl, currentUrl);
        driverThreadLocal.get().navigate().back();
    }

    @Description("perform search and validate search results")
    @Test
    public void validateSearchResult(){

        //perform search for “Houghton Mifflin Harcourt”
        String searchString = "Houghton Mifflin Harcourt";

        SearchResultPage searchResultPage = bbcHomePageThreadLocal.get().performSearch(searchString);
        List<String> searchElements = searchResultPage.getSearchResultLinks();
        testFlowHelpers.validateBrokenLinks(searchElements, BASE_URL);
    }
}

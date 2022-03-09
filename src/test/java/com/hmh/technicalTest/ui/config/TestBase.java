package com.hmh.technicalTest.ui.config;

import com.hmh.technicalTest.dto.Browser;
import com.hmh.technicalTest.pages.BbcHomePage;
import com.hmh.technicalTest.pages.NewsPage;
import com.hmh.technicalTest.pages.SearchResultPage;
import com.hmh.technicalTest.ui.listeners.TestListeners;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

@Listeners({TestListeners.class})
public class TestBase {

    public String BASE_URL;
    public Browser BROWSER;
    public ThreadLocal<RemoteWebDriver> driverThreadLocal = new InheritableThreadLocal<>();
    public ThreadLocal<DriverBase> threadLocalDriverBase = new InheritableThreadLocal<>();
    public ThreadLocal<BbcHomePage> bbcHomePageThreadLocal = new InheritableThreadLocal<>();
    public ThreadLocal<NewsPage> newsPageThreadLocal = new InheritableThreadLocal<>();
    public ThreadLocal<SearchResultPage> searchResultPageThreadLocal = new InheritableThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    @Parameters({"baseUrl", "browser"})
    public void setup(
            @Optional(ApplicationProperties.BASE_URL) String baseUrl,
            @Optional(ApplicationProperties.BROWSER) String browser
    ) {

        BASE_URL = baseUrl;
        BROWSER = Browser.valueOfBrowser(browser);

        threadLocalDriverBase.set(new DriverBase());
        driverThreadLocal.set(threadLocalDriverBase.get().setupDriver(BROWSER));

        //open bbc.com
        driverThreadLocal.get().get(BASE_URL);

        bbcHomePageThreadLocal.set(new BbcHomePage(driverThreadLocal.get()));
        bbcHomePageThreadLocal.get().giveConsent();

    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        //Deleting all the driver instance
        threadLocalDriverBase.get().closeDriver(driverThreadLocal.get());

    }

    //@AfterTest(alwaysRun = true)
    public void cleanup() {
        driverThreadLocal.remove();
    }
}

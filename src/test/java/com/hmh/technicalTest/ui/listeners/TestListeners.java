package com.hmh.technicalTest.ui.listeners;

import com.hmh.technicalTest.ui.config.TestBase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult iTestResult){
        System.out.println("\n************************ started test "+getTestMethodName(iTestResult)+" ********************************");
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("\n Test case "+getTestMethodName(result)+" was successful\n");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("\n Test case "+getTestMethodName(result)+" was failed\n");

        Object testClass = result.getInstance();
        RemoteWebDriver driver = ((TestBase) testClass).driverThreadLocal.get();

        if(driver instanceof RemoteWebDriver){
            System.out.println("Screenshot captured for "+getTestMethodName(result));
            saveScreenShot(driver);
        }
    }

    /**
     * allure annotation to capture screen shot for test failure
     * @param driver
     * @return
     */
    @Attachment(value = "Failure screenshot", type = "image/png")
    public byte[] saveScreenShot(RemoteWebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

package com.titanium.framework.ui.utils;

import com.titanium.framework.general.PropertyManager;
import com.titanium.framework.ui.base.DriverFactory;
import com.titanium.framework.ui.base.RemoteDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.*;

public class WaitUtil {
    private static WebDriverWait wait;
    public static WebDriverWait explicytWait(){
        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            wait = new WebDriverWait(RemoteDriverFactory.getInstance().getDriver(),30, 1000);
        }else{
            wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),30, 1000);
        }
        return wait;
    }


    private static String pageLoadStatus;

    public static void sync(){
        JavascriptExecutor js;

        do {
            if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
                js = (JavascriptExecutor) RemoteDriverFactory.getInstance().getDriver();
            }else{
                js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            }
            pageLoadStatus = (String) js.executeScript("return document.readyState");
        } while (!pageLoadStatus.equals("complete"));
    }

    public static void waitForElementVisible(final WebElement element){
        explicytWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAlert(){
        explicytWait().until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForElementTextVisible(final WebElement element, String text){
        explicytWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilTextDisplayed(final WebElement element, String text){
        explicytWait().until(textDisplayed(element, text));
    }

    private static Function<? super WebDriver, Object> textDisplayed(final WebElement element, String text){
        return webdriver -> element.getText().contains(text);
    }

    public static void waitForElementDisplayed(WebElement element){
        await("Wait for element to be displayed").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isDisplayed, is(true));
    }

    public static void waitForElementNotDisplayed(WebElement element){
        await("Wait for element to be displayed").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isDisplayed, is(false));
    }

    public static void waitForElementEnabled(WebElement element){
        await("Wait for element to be enabled").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isEnabled, is(true));
    }

    public static void waitForElementSelected(WebElement element){
        await("Wait for element to be selected").atLeast(2, TimeUnit.SECONDS)
                .and()
                .atMost(20, TimeUnit.SECONDS)
                .ignoreExceptions()
                .until(element::isSelected, is(true));
    }

    public static void waitTime(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            Assert.fail(e.getMessage());
        }
    }

    public static void waitForElementsNumberBeMoreThan(By selector, int numberCountBefore){
        explicytWait().until(ExpectedConditions.numberOfElementsToBeMoreThan(selector, numberCountBefore));
    }
}

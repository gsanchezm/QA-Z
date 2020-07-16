package com.titanium.framework.ui.utils;

import com.titanium.framework.general.PropertyManager;
import com.titanium.framework.ui.base.DriverFactory;
import com.titanium.framework.ui.base.RemoteDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SeleniumUtils {
    public static String SSDate;
    public static String SSDateTime;
    public static String file;

    /**
     * Method to higlight a webelement  using JavaScript
     * @param element
     */
    public static void highLight(WebElement element) {
        WaitUtil.waitForElementVisible(element);
        JavascriptExecutor js;
        for (int i = 0; i < 3; i++) {
            try {
                //Creating JavaScriptExecuter Interface
                if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
                    js = (JavascriptExecutor) RemoteDriverFactory.getInstance().getDriver();
                }else{
                    js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
                }

                for (int iCnt = 0; iCnt < 3; iCnt++) {
                    //Execute javascript
                    try {
                        js.executeScript("arguments[0].setAttribute('style','background: yellow')", element);
                        Thread.sleep(20);
                        js.executeScript("arguments[0].setAttribute('style','background:')", element);
                    } catch (InterruptedException e) {
                        Assert.fail("Class SeleniumUtils | Method fnHighlightMe | Exception desc: Exception", e);
                    }
                }
            } catch (StaleElementReferenceException e) {
            }
        }

    }

    /**
     * Method that scroll to webelement using JavaScript
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        WaitUtil.waitForElementVisible(element);
        JavascriptExecutor js;
        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            js = (JavascriptExecutor) RemoteDriverFactory.getInstance().getDriver();
        }else{
            js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        }

        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Assert.fail("Class SeleniumUtils | Method fnScrollToElement | Exception desc: Exception", e);
        }
    }

    /**
     * Method that scroll to top using JavaScript
     */
    public static void scroll(String verhor, String updown) {
        JavascriptExecutor js;

        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            js = (JavascriptExecutor) RemoteDriverFactory.getInstance().getDriver();
        }else{
            js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        }

        try {
            js.executeScript("window.scrollBy("+ verhor +"," + updown +")", "");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Assert.fail("Class SeleniumUtils | Method fnScrollToElement | Exception desc: Exception", e);
        }
    }

    /**
     * Method that refresh a webpage
     */
    public static void refresh() {

        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            RemoteDriverFactory.getInstance().getDriver().navigate().refresh();
        }else{
            DriverFactory.getInstance().getDriver().navigate().refresh();
        }
    }
}

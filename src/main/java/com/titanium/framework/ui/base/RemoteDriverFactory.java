package com.titanium.framework.ui.base;

import com.titanium.framework.general.PropertyManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteDriverFactory {
    private static RemoteDriverFactory instance = new RemoteDriverFactory();

    public static RemoteDriverFactory getInstance(){
        return instance;
    }

    // Thread local driver object for webdriver
    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    /**
     * Method to get the driver object and launch the browser
     * @return
     */
    public RemoteWebDriver getDriver(){
        return driver.get();
    }

    /**
     * Method to set the driver object and select the browser
     * @param browser
     * @return
     */
    public RemoteWebDriver setDriver(BrowserType browser) throws MalformedURLException {
        String getOS = System.getProperty("os.name").toLowerCase();

        ChromeOptions chromeOptions = null;
        FirefoxOptions firefoxOptions = null;
        EdgeOptions edgeOptions = null;

        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                driver.set(new RemoteWebDriver(new URL(PropertyManager.getInstance().getProperty("Zalenium_Grid_Port")), chromeOptions));
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                driver.set(new RemoteWebDriver(new URL(PropertyManager.getInstance().getProperty("Zalenium_Grid_Port")), firefoxOptions));
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                driver.set(new RemoteWebDriver(new URL(PropertyManager.getInstance().getProperty("Zalenium_Grid_Port")), edgeOptions));
                break;
        }

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.get();
    }

    /**
     * Method to quits the driver and closes the browser
     */
    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}

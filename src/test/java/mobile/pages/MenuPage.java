package mobile.pages;

import com.titanium.framework.mobile.base.BasePage;
import com.titanium.framework.mobile.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MenuPage extends BasePage {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView\n" +
            "")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
    private MobileElement settingsBtn;

    public SettingsPage pressSettingsBtn() {
        click(settingsBtn, "press Settings button");
        return new SettingsPage();
    }
}

package mobile.pages;

import com.titanium.framework.mobile.base.BasePage;
import com.titanium.framework.mobile.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingsPage extends BasePage {
    TestUtils utils = new TestUtils();

    @AndroidFindBy(accessibility="test-LOGOUT")
    @iOSXCUITFindBy(id = "test-LOGOUT")
    private MobileElement logoutBtn;

    public LoginPage pressLogoutBtn() {
        click(logoutBtn, "press Logout button");
        return new LoginPage();
    }
}

package ui.pages;

import com.titanium.framework.ui.base.Base;
import com.titanium.framework.ui.base.DriverFactory;
import com.titanium.framework.ui.controls.elements.Button;
import com.titanium.framework.ui.controls.elements.HyperLink;
import com.titanium.framework.ui.controls.elements.Label;
import com.titanium.framework.ui.controls.elements.TextBox;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static com.titanium.framework.ui.utils.SeleniumUtils.scroll;

public class HomePage extends Base {

    @FindBy(linkText = "Dismiss")
    private HyperLink lnkDismiss;

    @FindBy(linkText = "My Account")
    private HyperLink lnkMyAccount;

    @FindBy(linkText = "PINK DROP SHOULDER OVERSIZED T SHIRT")
    private HyperLink lnkPinkDropShoulderTShirt;

    @FindBy(id = "username")
    private TextBox txtEmail;

    @FindBy(id = "password")
    private TextBox txtPassword;

    @FindBy(name = "login")
    private Button btnLogin;

    @FindBy(xpath = "(//*[text()='gsanchez19'])[1]")
    private Label lblHello;

    public String getPageTitle(){
        return DriverFactory.getInstance().getDriver().getTitle();
    }

    public void clickOnDismiss(){
        try{
            DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            lnkDismiss.clickLink();
        }catch (NoSuchElementException e){}
    }

    public void clickMyAccount(){
        lnkMyAccount.clickLink();
    }

    public LoginCommand loginAs(String userName){
        return new LoginCommand(userName);
    }

    public String getWelcomeLabel(){
        scroll("0","250");
        return lblHello.waitForVisible().getElementText();
    }

    public void clickPinkDropShoulderOversizedTShirt(){
        scroll("0","200");
        lnkPinkDropShoulderTShirt.clickLink();
    }

    public class LoginCommand{
        private String userName;
        private String password;

        public LoginCommand(String userName){
            this.userName = userName;
        }

        public LoginCommand withPassword(String password){
            this.password = password;
            return  this;
        }

        public void login(){
            txtEmail.waitForVisible().clear();
            txtEmail.enterText(userName);
            txtPassword.waitForVisible().clear();
            txtPassword.waitForVisible().enterText(password);
            btnLogin.waitForVisible().performClick();
        }
    }
}

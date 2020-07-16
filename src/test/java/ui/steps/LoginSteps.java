package ui.steps;

import com.titanium.framework.ui.base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui.pages.HomePage;

import java.util.List;

public class LoginSteps extends Base {

    @And("I enter UserName and Password")
    public void i_enter_UserName_and_Password(DataTable userData) {
        List<List<String>> data = userData.asLists();
        var user = data.get(1).get(0);
        var password = data.get(1).get(1);
        currentPage.as(HomePage.class).loginAs(user).withPassword(password).login();
    }

    @Then("I should see the username with hello")
    public void i_should_see_the_username_with_hello() {
        Assert.assertTrue(currentPage.as(HomePage.class).getWelcomeLabel().contains("gsanchez19"));
    }
}

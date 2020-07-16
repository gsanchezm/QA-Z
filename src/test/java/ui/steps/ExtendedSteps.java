package ui.steps;

import com.titanium.framework.ui.base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui.pages.HomePage;
import ui.pages.ProductTShirtPage;

public class ExtendedSteps extends Base {

    @Given("I see application opened")
    public void i_see_application_opened() {
        currentPage = getInstance(HomePage.class);
        currentPage.as(HomePage.class).clickOnDismiss();
        Assert.assertTrue(currentPage.as(HomePage.class).getPageTitle().contains("ToolsQA Demo"));
    }

    @When("I click {string} link")
    public void i_click_link(String link) {
        switch (link){
            case "My Account":
                currentPage.as(HomePage.class).clickMyAccount();
                break;
            case "pink drop shoulder oversized t shirt":
                currentPage.as(HomePage.class).clickPinkDropShoulderOversizedTShirt();
                break;
        }
    }

    @When("I select from drop down {string}")
    public void i_select_from_dropDown(String selection) {
    }

    @And("I type {string} as {string}")
    public void i_type_as(String option, String text) {
    }

    @And("I click on {string}")
    public void i_click_on(String element) {
    }
}

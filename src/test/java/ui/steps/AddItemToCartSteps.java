package ui.steps;

import com.titanium.framework.ui.base.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ui.pages.ProductTShirtPage;

public class AddItemToCartSteps extends Base {
    @When("I add to cart an element with color {string}, size {string} and quantity {string}")
    public void I_add_to_cart_an_element_with_color_size_quantity(String color, String size, String quantity) {
        currentPage = getInstance(ProductTShirtPage.class);
        currentPage.as(ProductTShirtPage.class).SelectItemWithColor(color).withSize(size).withQty(quantity).AddToCart();
    }

    @Then("I should see the items added and the total")
    public void i_should_see_the_items_added_and_the_total() {
        Assert.assertTrue(currentPage.as(ProductTShirtPage.class).getCartItemNumber().contains("2"));
        Assert.assertTrue(currentPage.as(ProductTShirtPage.class).getCartItemNumber().contains("30"));
    }
}

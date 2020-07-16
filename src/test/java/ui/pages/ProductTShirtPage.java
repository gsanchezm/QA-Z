package ui.pages;

import com.titanium.framework.ui.base.Base;
import com.titanium.framework.ui.controls.elements.Button;
import com.titanium.framework.ui.controls.elements.DropDown;
import com.titanium.framework.ui.controls.elements.Span;
import com.titanium.framework.ui.controls.elements.TextBox;
import org.openqa.selenium.support.FindBy;

import static com.titanium.framework.ui.utils.SeleniumUtils.scroll;

public class ProductTShirtPage extends Base {
    @FindBy(id = "pa_color")
    DropDown drpColor;

    @FindBy(id = "pa_size")
    DropDown drpsize;

    @FindBy(name = "quantity")
    TextBox txtQuantity;

    @FindBy(xpath = "//*[text()='Add to cart']")
    Button btnAddToCart;

    @FindBy(xpath = "//span[contains(text(),'Cart')]")
    Span spnCartItemNumber;

    public AddCartCommand SelectItemWithColor(String color){
        return new AddCartCommand(color);
    }

    public String getCartItemNumber(){
        return spnCartItemNumber.waitForVisible().getElementText();
    }

    public class AddCartCommand{
        private String color;
        private String size;
        private String quantity;

        public AddCartCommand(String color){
            this.color = color;
        }

        public AddCartCommand withSize(String size){
            this.size = size;
            return this;
        }

        public AddCartCommand withQty(String quantity){
            this.quantity = quantity;
            return this;
        }

        public void AddToCart(){
            scroll("0","170");
            drpColor.waitForVisible().selectElement(color);
            drpsize.selectElement(size);
            txtQuantity.clear();
            txtQuantity.enterText(quantity);
            btnAddToCart.performClick();
        }
    }

}

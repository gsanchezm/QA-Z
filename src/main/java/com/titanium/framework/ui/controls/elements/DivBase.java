package com.titanium.framework.ui.controls.elements;

import com.titanium.framework.ui.controls.internals.ControlBase;
import com.titanium.framework.ui.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

public class DivBase extends ControlBase implements Div{
    public DivBase(WebElement element) {
        super(element);
    }

    // Click on one div
    @Override
    public void clickDiv() {
        SeleniumUtils.highLight(getWrappedElement());
        click();
    }

    // Get the text from div
    @Override
    public String getDivText() {
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }

    // Check partial text exist on one div
    @Override
    public boolean checkDivContains(String containsText) {
        SeleniumUtils.highLight(getWrappedElement());
        if (getText().contains(containsText))
            return true;
        else
            return false;
    }
}

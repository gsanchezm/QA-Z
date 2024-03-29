package com.titanium.framework.ui.controls.elements;

import com.titanium.framework.ui.controls.internals.ControlBase;
import com.titanium.framework.ui.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;

public class HyperLinkBase extends ControlBase implements HyperLink{
    public HyperLinkBase(WebElement element) {
        super(element);
    }

    // Click on one hyperlink
    @Override
    public void clickLink() {
        SeleniumUtils.highLight(getWrappedElement());
        click();
    }

    // Get the text from link
    @Override
    public String getLinkText() {
        SeleniumUtils.highLight(getWrappedElement());
        return getText();
    }

    // Check partial text exist on one link
    @Override
    public boolean checkLinkTextContains(String containsText) {
        SeleniumUtils.highLight(getWrappedElement());
        if (getText().contains(containsText))
            return true;
        else
            return false;
    }
}

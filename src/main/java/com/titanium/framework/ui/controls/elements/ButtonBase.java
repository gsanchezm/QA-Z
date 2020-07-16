package com.titanium.framework.ui.controls.elements;

import com.titanium.framework.ui.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class ButtonBase extends ControlBase implements Button{
    public ButtonBase(WebElement element) {
        super(element);
    }

    // Verify if a button is enabled or not
    @Override
    public boolean getButtonIsEnabled() {
        return isEnabled();
    }
}

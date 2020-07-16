package com.titanium.framework.ui.controls.elements;

import com.titanium.framework.ui.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class TextBoxBase extends ControlBase implements TextBox{
    public TextBoxBase(WebElement element) {
        super(element);
    }
}

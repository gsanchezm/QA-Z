package com.titanium.framework.ui.controls.elements;

import com.titanium.framework.ui.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class LabelBase extends ControlBase implements Label {
    public LabelBase(WebElement element) {
        super(element);
    }
}

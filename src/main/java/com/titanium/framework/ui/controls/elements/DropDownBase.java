package com.titanium.framework.ui.controls.elements;

import com.titanium.framework.ui.controls.internals.ControlBase;
import com.titanium.framework.ui.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownBase extends ControlBase implements DropDown{
    public DropDownBase(WebElement element) {
        super(element);
    }

    @Override
    public void selectElement(int index) {
        SeleniumUtils.highLight(getWrappedElement());
        new Select(getWrappedElement()).selectByIndex(index);
    }
}

package com.titanium.framework.ui.controls.internals;

import com.google.inject.ImplementedBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {
    ControlBase waitFor();

    ControlBase waitForVisible();

    ControlBase scrollUp();

    ControlBase scrollDown();

    ControlBase scrollToElement();

    String getElementText();

    // Type text in textbox
    ControlBase enterText(String text);

    // Perform a click on a button
    void performClick();

    // Perform a click an submit a form when the input type is submit
    void performSubmit();

    //Select an element from drop down by text
    void selectElement(String element);
}

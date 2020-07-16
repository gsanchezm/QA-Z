package com.titanium.framework.ui.controls.elements;

import com.google.inject.ImplementedBy;
import com.titanium.framework.ui.controls.internals.Control;

@ImplementedBy(DivBase.class)
public interface Div extends Control {
    // Click on one hyperlink
    void clickDiv();
    // Get the text from link
    String getDivText();
    // Check partial text exist on one link
    boolean checkDivContains(String containsText);
}

package com.titanium.framework.ui.controls.elements;

import com.google.inject.ImplementedBy;
import com.titanium.framework.ui.controls.internals.Control;

@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {
    // Click on one hyperlink
    void clickLink();
    // Get the text from link
    String getLinkText();
    // Check partial text exist on one link
    boolean checkLinkTextContains(String containsText);
}

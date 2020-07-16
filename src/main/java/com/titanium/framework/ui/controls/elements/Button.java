package com.titanium.framework.ui.controls.elements;

import com.google.inject.ImplementedBy;
import com.titanium.framework.ui.controls.internals.Control;

@ImplementedBy(ButtonBase.class)
public interface Button extends Control {
    // Verify if a button is enabled or not
    boolean getButtonIsEnabled();
}

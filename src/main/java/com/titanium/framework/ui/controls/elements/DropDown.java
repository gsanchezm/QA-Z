package com.titanium.framework.ui.controls.elements;

import com.google.inject.ImplementedBy;
import com.titanium.framework.ui.controls.internals.Control;

@ImplementedBy(DropDownBase.class)
public interface DropDown extends Control {
    void selectElement(String text);
    void selectElement(int index);
}

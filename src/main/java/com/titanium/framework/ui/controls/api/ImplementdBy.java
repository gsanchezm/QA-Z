package com.titanium.framework.ui.controls.api;

import com.titanium.framework.ui.controls.internals.ControlBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImplementdBy {
    Class<?> value() default ControlBase .class;
}

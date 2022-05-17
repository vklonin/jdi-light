package com.epam.jdi.light.vuetify.elements.complex.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

public class ClearableTextField extends TextField {
    private static final String CLEAR_TEXT_BUTTON = ".//button[@aria-label='clear icon']";

    @JDIAction("Clear '{name}' by click on clear button")
    public void clear() {
        find(CLEAR_TEXT_BUTTON).click();
    }

}

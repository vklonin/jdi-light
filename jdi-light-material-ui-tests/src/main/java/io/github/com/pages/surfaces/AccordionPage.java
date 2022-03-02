package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.material.elements.surfaces.Accordion;
import io.github.com.custom.elements.ControlledAccordion;

public class AccordionPage extends WebPage {

    @JDropdown(
            root = ".MuiAccordion-root[1]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            list = ".MuiAccordionDetails-root",
            expand = ".MuiIconButton-label")
    public static ControlledAccordion generalSettingsAccordion;

    @JDropdown(
            root = ".MuiAccordion-root[2]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            list = ".MuiAccordionDetails-root",
            expand = ".MuiIconButton-label")
    public static ControlledAccordion usersAccordion;

    @JDropdown(
            root = ".MuiAccordion-root[3]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            list = ".MuiAccordionDetails-root",
            expand = ".MuiIconButton-label")
    public static ControlledAccordion advancedSettingsAccordion;

    @JDropdown(
            root = ".MuiAccordion-root[4]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            list = ".MuiAccordionDetails-root",
            expand = ".MuiIconButton-label")
    public static Accordion personalDataAccordion;

    @JDropdown(
            root = ".MuiAccordion-root[5]",
            value = ".MuiButtonBase-root.MuiAccordionSummary-root",
            expand = ".MuiIconButton-label")
    public static Accordion disabledAccordion;

}


package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;

public class DataIteratorsPage extends VuetifyPage {

    @UI("#DefaultTable")
    public static DataIterator defaultDataIterator;

    @UI("#HeaderFooterTable")
    public static DataIterator headerFooterDataIterator;

    @UI("#FilterTable")
    public static DataIterator filterDataIterator;
}
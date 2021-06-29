package io.github.epam.material.tests.displaydata;
import static org.hamcrest.Matchers.hasToString;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.ListPage;

public class ListsTests extends TestsInit{

    @Test
    public void simpleList() {
        ListPage.open();

        ListPage.firstListItem.is().enabled();
        ListPage.firstListItem.is().text(hasToString("List item 1"));
        ListPage.secondListItem.is().enabled();
        ListPage.secondListItem.is().text(hasToString("List item 2"));
    }

    @Test
    public void checkboxList() {
        ListPage.open();

        ListPage.lineItemFirst.is().enabled();
        ListPage.lineItemFirst.is().text(hasToString("Line item 1"));
        ListPage.checkboxLineItemFirst.is().checked();

        ListPage.checkboxLineItemFirst.uncheck();
        ListPage.checkboxLineItemFirst.is().unchecked();

        ListPage.checkboxLineItemFirst.check();
        ListPage.checkboxLineItemFirst.is().checked();
    }

    @Test
    public void pinnedSubHeaderList() {
        ListPage.open();

        ListPage.stickyZero.is().enabled();
        ListPage.stickyZero.is().text(hasToString("I'm sticky 0"));
        ListPage.stickyOne.is().enabled();
        ListPage.stickyOne.is().text(hasToString("I'm sticky 1"));
    }
}

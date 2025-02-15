package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.dialog;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class DialogUnitTests extends TestsInit {
    @BeforeClass(alwaysRun = true)
    public void before() {
        skipForFirefox();
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        dialog.show();
    }

    @Test
    public void openedTest() {
        dialog.open();
        assertTrue(dialog.isOpened());
        dialog.close();
    }

    @Test
    public void closedTest() {
        dialog.open();
        dialog.close();
        assertTrue(dialog.isClosed());
    }

    @Test
    public void verifySendKeysToNameFormFieldTest() {
        dialog.sendKeysToNameFormField("EPAM Systems");
        dialog.open();
        assertTrue(dialog.nameText("EPAM Systems"));
        dialog.close();
    }

    @Test
    public void verifySendKeysToAnswerFormFieldTest() {
        dialog.open();
        dialog.sendKeysToAnswerFormField("Lion");
        dialog.submitAnswer();
        assertTrue(dialog.answerText("Lion"));
    }
}

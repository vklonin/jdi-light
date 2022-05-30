package com.epam.jdi.light.material.asserts.feedback;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Dialog}
 */
public class DialogAssert extends UIAssert<DialogAssert, Dialog> {

    private final Timer TIMER = new Timer(5000L, 500L);

    /**
     * Checks that dialog has scrollable content.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction("Assert that '{name}' has scrollable content")
    public DialogAssert scrollableContent() {
        TIMER.wait(() -> element().isDisplayed());
        jdiAssert(element().hasScrollableContent() ? "has scrollable content" : "does not have scrollable content",
                Matchers.is("has scrollable content"));
        return this;
    }

    /**
     * Checks that dialog has scrollable body.
     *
     * @return this {@link DialogAssert} instance
     */
    @JDIAction("Assert that '{name}' has scrollable body")
    public DialogAssert scrollableBody() {
        TIMER.wait(() -> element().isDisplayed());
        jdiAssert(element().hasScrollableBody() ? "has scrollable body" : "does not have scrollable body",
                Matchers.is("has scrollable body"));
        return this;
    }

    @JDIAction("Assert that '{name}' is hidden")
    public DialogAssert hidden() {
        TIMER.wait(() -> element().isNotVisible());
        jdiAssert(element().isHidden(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is displayed")
    public DialogAssert displayed() {
        TIMER.wait(() -> element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }
}

package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.PaginationAssert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * To see an example of Pagination web element please visit
 * https://vuetifyjs.com/en/components/paginations/
 */
public class Pagination extends UIListBase<PaginationAssert> {

    private static final String CORE_CLASS_DISABLED = "v-pagination--disabled";
    private static final String ITEM_CLASS_SELECTED = "v-pagination__item--active";

    private int startIndex = 1;

    @JDIAction("Get left navigation button from '{name}'")
    public Button leftNavigation() {
        return new Button().setCore(Button.class, core().find(".v-pagination__navigation[1]"));
    }

    @JDIAction("Get right navigation button from '{name}'")
    public Button rightNavigation() {
        return new Button().setCore(Button.class, core().find(".v-pagination__navigation[2]"));
    }

    @Override
    @JDIAction("Get web list of all buttons from {name}")
    public WebList list() {
        return core().finds("button.v-pagination__item");
    }

    @JDIAction("Get list of all buttons from {name}")
    public List<Button> buttons() {
        return list().map(uiElement -> new Button().setCore(Button.class, uiElement));
    }

    @Override
    @JDIAction("Get start index from {name}")
    public int getStartIndex() {
        return startIndex;
    }

    @Override
    @JDIAction("Set start index '{0}' for {name}")
    public void setStartIndex(int i) {
        startIndex = i;
    }

    @Override
    @JDIAction("Get selected button from {name}")
    public String selected() {
        return list().stream()
                .filter(button -> button.hasClass(ITEM_CLASS_SELECTED))
                .findFirst()
                .map(UIElement::getText)
                .orElse(null);
    }

    @Override
    @JDIAction("Check if button from {name} by name '{0}' is selected")
    public boolean selected(String option) {
        return list().get(option).hasClass(ITEM_CLASS_SELECTED);
    }

    @Override
    @JDIAction("Check if button from {name} by index '{0}' is selected")
    public boolean selected(int index) {
        return list().get(index).hasClass(ITEM_CLASS_SELECTED);
    }

    @Override
    @JDIAction("Check if pagination {name} is enabled")
    public boolean isEnabled() {
        return !core().hasClass(CORE_CLASS_DISABLED);
    }

    @JDIAction("Check if pagination {name} is on start")
    public boolean isStart() {
        return list().first().hasClass(ITEM_CLASS_SELECTED);
    }

    @JDIAction("Check if pagination {name} is on end")
    public boolean isEnd() {
        return list().last().hasClass(ITEM_CLASS_SELECTED);
    }

    @JDIAction("Check if pagination {name} is on end")
    public boolean hasHiddenButtons() {
        return core().finds(By.className("v-pagination__more")).size() > 0;
    }

    @Override
    public PaginationAssert is() {
        return new PaginationAssert().set(this);
    }

    public ListIterator<String> listIterator() {
        return new PaginationIterator();
    }

    private class PaginationIterator implements ListIterator<String> {

        boolean next = size() > 0;
        boolean previous = size() > 0;

        private OptionalInt getCurrentIndex() {
            if (!hasHiddenButtons()) {
                return IntStream.range(getStartIndex(), size() + getStartIndex())
                        .filter(buttonId -> list().get(buttonId).hasClass(ITEM_CLASS_SELECTED))
                        .findFirst();
            }
            return OptionalInt.empty();
        }

        private int getFollowingIndex(boolean isThereFollowingElement, int indexShift) {
            OptionalInt currentIndex = getCurrentIndex();
            if (currentIndex.isPresent()) {
                if (isThereFollowingElement) {
                    return currentIndex.getAsInt();
                }
                return currentIndex.getAsInt() + indexShift;
            }
            return -1;
        }

        @Override
        public boolean hasNext() {
            return next;
        }

        @Override
        public String next() {
            if (!next && !rightNavigation().isEnabled()) {
                throw new NoSuchElementException("Can't find next element");
            } else if (next && !rightNavigation().isEnabled()) {
                next = false;
                return selected();
            } else {
                next = true;
                String current = selected();
                rightNavigation().click();
                return current;
            }
        }

        @Override
        public boolean hasPrevious() {
            return previous;
        }

        @Override
        public String previous() {
            if (!previous && !leftNavigation().isEnabled()) {
                throw new NoSuchElementException("Can't find previous element");
            } else if (previous && !leftNavigation().isEnabled()) {
                previous = false;
                return selected();
            } else {
                previous = true;
                String current = selected();
                leftNavigation().click();
                return current;
            }
        }

        @Override
        public int nextIndex() {
            return getFollowingIndex(next, 1);
        }

        @Override
        public int previousIndex() {
            return getFollowingIndex(previous, -1);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(String button) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(String button) {
            throw new UnsupportedOperationException();
        }
    }
}
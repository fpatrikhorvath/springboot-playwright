package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;

@ScenarioScope
public abstract class BaseForm {

    /** The root element, forced to be defined by subclasses */
    protected final Locator rootElement;

    protected BaseForm(PwFactory pwFactory) {
        // Call abstract method to get the root element
        this.rootElement = defineRootElement(pwFactory);
        if (this.rootElement == null) {
            throw new IllegalStateException(
                    "Subclasses must provide a non-null root element via defineRootElement()");
        }
    }

    /** Concrete subclasses MUST implement this to define their root element */
    protected abstract Locator defineRootElement(final PwFactory pwFactory);

    public boolean isPresent() {
        return rootElement.isVisible();
    }

    public void sendFormButton() {
        rootElement.locator("button[type='submit']").click();
    }
}

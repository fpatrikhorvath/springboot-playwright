package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;

@ScenarioScope
public abstract class BaseForm {

    protected final Locator rootElement;
    protected final Locator sendButton;

    protected BaseForm(final PwFactory pwFactory) {
        this.rootElement = pwFactory.getPage().locator(getDefineRootElement());

        if (this.rootElement == null) {
            throw new IllegalStateException("Subclasses must provide a non-null root element via defineRootElement()");
        }

        this.sendButton = rootElement.locator("//input[@type='submit']");
    }

    protected abstract String getDefineRootElement();

    public boolean isPresent() {
        return rootElement.isVisible();
    }

    public void sendForm() {
        sendButton.click();
    }
}
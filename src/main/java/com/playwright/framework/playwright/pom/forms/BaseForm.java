package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Page;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;

@ScenarioScope
public abstract class BaseForm {
    protected final Page page;

    protected BaseForm(final PwFactory pwFactory) {
        this.page = pwFactory.getPage();
    }

    public abstract boolean isPresent();
    public abstract void sendFormButton();
}

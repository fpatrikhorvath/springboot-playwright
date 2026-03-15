package com.playwright.framework.playwright.pom;

import com.microsoft.playwright.Page;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;

@ScenarioScope
public abstract class BasePage {
    protected final PwFactory pwFactory;
    protected final Page      page;

    protected BasePage(final PwFactory pwFactory) {
        this.pwFactory = pwFactory;
        this.page      = pwFactory.getPage();
    }

}

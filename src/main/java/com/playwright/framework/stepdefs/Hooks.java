package com.playwright.framework.stepdefs;

import com.microsoft.playwright.Page;
import com.playwright.framework.context.ScenarioCxt;
import com.playwright.framework.playwright.PageObjectFactory;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks extends TestCore {
    private final PwFactory pwFactory;

    public Hooks(final ScenarioCxt scenarioContext, final PageObjectFactory pageObjectFactory, final PwFactory pwFactory) {
        super(scenarioContext, pageObjectFactory);
        this.pwFactory = pwFactory;
    }


    @After
    public void tearDown(final Scenario scenario) {
        if (scenario.isFailed()) {
            final Path path = Paths.get("screenshot.png");
            pwFactory.getPage().screenshot(new Page.ScreenshotOptions().setPath(path));

        }
        pwFactory.destroy();
    }
}

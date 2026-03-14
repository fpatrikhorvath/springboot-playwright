package com.playwright.framework.stepdefs;

import com.playwright.framework.context.ScenarioContext;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.stores.ParabankPageStore;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends TestCore {
    private final PwFactory pwFactory;

    public Hooks(final ScenarioContext scenarioContext, final ParabankPageStore parabankPageStore,
                 final PwFactory pwFactory) {
        super(scenarioContext, parabankPageStore);
        this.pwFactory = pwFactory;
    }


    @After
    public void tearDown(final Scenario scenario) {
        if (scenario.isFailed()) {
//            Path path = Paths.get("screenshot.png");
//            pwFactory.getPage().screenshot(new Page.ScreenshotOptions().setPath(path));

        }
        pwFactory.destroy();
    }
}

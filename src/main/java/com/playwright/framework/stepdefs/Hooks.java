package com.playwright.framework.stepdefs;

import com.playwright.framework.context.ScenarioContext;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.pom.IndexPage;
import com.playwright.framework.playwright.pom.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends TestCore {
    private final PwFactory pwFactory;

    public Hooks(final ScenarioContext scenarioContext, final IndexPage indexPage, final RegisterPage registerPage,
                 final PwFactory pwFactory) {
        super(scenarioContext, indexPage, registerPage);
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

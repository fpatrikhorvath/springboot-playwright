package com.playwright.framework.stepdefs;

import com.playwright.framework.context.ScenarioContext;
import com.playwright.framework.playwright.pom.IndexPage;
import com.playwright.framework.playwright.pom.RegisterPage;
import com.playwright.framework.stores.ParabankPageStore;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration(loader = SpringBootContextLoader.class, value = {"classpath:spring.xml"})
@SpringBootTest(classes = TestCore.class)
public class TestCore {

    protected final ScenarioContext scenarioContext;

    private final ParabankPageStore parabankPageStore;

    public TestCore(final ScenarioContext scenarioContext, final ParabankPageStore parabankPageStore) {
        this.scenarioContext   = scenarioContext;
        this.parabankPageStore = parabankPageStore;
    }

    protected IndexPage getIndexPage() {
        return parabankPageStore.getIndexPage();
    }

    protected RegisterPage getRegisterPage() {
        return parabankPageStore.getRegisterPage();
    }
}
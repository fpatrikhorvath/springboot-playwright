package com.playwright.framework.stepdefs;

import com.playwright.framework.context.ScenarioCxt;
import com.playwright.framework.playwright.PageObjectFactory;
import com.playwright.framework.playwright.pom.IndexPage;
import com.playwright.framework.playwright.pom.RegisterPage;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@ContextConfiguration(loader = SpringBootContextLoader.class, value = {"classpath:spring.xml"})
@SpringBootTest(classes = TestCore.class)
public class TestCore {
    protected final ScenarioCxt       cxt;
    protected final PageObjectFactory pageFactory;
    protected final IndexPage         indexPage;
    protected final RegisterPage      registerPage;

    public TestCore(final ScenarioCxt scenarioContext, final PageObjectFactory pageFactory) {
        this.cxt          = scenarioContext;
        this.pageFactory  = pageFactory;
        this.indexPage    = pageFactory.getPage(IndexPage.class);
        this.registerPage = pageFactory.getPage(RegisterPage.class);
    }
}
package com.playwright.framework.stores;

import com.playwright.framework.playwright.pom.IndexPage;
import com.playwright.framework.playwright.pom.RegisterPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class ParabankPageStore {
    private final IndexPage    indexPage;
    private final RegisterPage registerPage;

    public ParabankPageStore(final IndexPage indexPage, final RegisterPage registerPage) {
        this.indexPage    = indexPage;
        this.registerPage = registerPage;
    }

    public IndexPage getIndexPage() {
        return indexPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }
}

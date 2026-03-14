package com.playwright.framework.stores;

import com.playwright.framework.playwright.handler.IndexPageHandler;
import com.playwright.framework.playwright.handler.RegisterPageHandler;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class ParabankPageStore {
    private final IndexPageHandler    indexPageHandler;
    private final RegisterPageHandler registerPageHandler;

    public ParabankPageStore(final IndexPageHandler loginPageHandler, final RegisterPageHandler registerPageHandler) {
        this.indexPageHandler    = loginPageHandler;
        this.registerPageHandler = registerPageHandler;
    }

    public IndexPageHandler getIndexPageHandler() {
        return indexPageHandler;
    }

    public RegisterPageHandler getRegisterPageHandler() {
        return registerPageHandler;
    }
}

package com.playwright.framework.playwright.handler;

import com.playwright.framework.config.ParabankConfig;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.pom.IndexPage;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public class IndexPageHandler extends BasePageHandler {
    private static final String PAGE_NAME = "index";

    private final IndexPage indexPage;

    protected IndexPageHandler(final ParabankConfig parabankConfig, final IndexPage indexPage, final PwFactory pwFactory) {
        super(parabankConfig, pwFactory);
        this.indexPage = indexPage;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}

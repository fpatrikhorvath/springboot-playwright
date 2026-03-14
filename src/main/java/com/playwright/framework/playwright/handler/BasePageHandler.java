package com.playwright.framework.playwright.handler;

import com.playwright.framework.config.ParabankConfig;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Service;

@ScenarioScope
@Service
public abstract class BasePageHandler {
    protected final ParabankConfig parabankConfig;
    protected final PwFactory      pwFactory;

    protected BasePageHandler(final ParabankConfig parabankConfig, final PwFactory pwFactory) {
        this.parabankConfig = parabankConfig;
        this.pwFactory      = pwFactory;
    }

    public abstract boolean isAt();
}

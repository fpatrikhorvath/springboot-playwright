package com.playwright.framework.playwright;

import com.microsoft.playwright.*;
import com.playwright.framework.config.ParabankConfig;
import com.playwright.framework.config.PlaywrightConfig;
import io.cucumber.spring.ScenarioScope;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class PwFactory implements DisposableBean {
    private static Browser browser;

    private final ParabankConfig   parabankConfig;
    private final PlaywrightConfig playwrightConfig;

    private Playwright playwright = null;
    private Page       page       = null;

    public PwFactory(final ParabankConfig parabankConfig, final PlaywrightConfig playwrightConfig) {
        this.parabankConfig   = parabankConfig;
        this.playwrightConfig = playwrightConfig;

        if (!PwInitializationListener.isInitialized()) {
            PwInitializationListener.setIsInitialized(true);
            playwright = Playwright.create();
            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
            launchOptions.setHeadless(playwrightConfig.isHeadless());

            switch (playwrightConfig.getBrowserType()) {
                case "chromium" -> browser = getChromiumBrowser(launchOptions);
                case "firefox" -> browser = getFirefoxBrowser(launchOptions);
                case "webkit" -> browser = getWebkitBrowser(launchOptions);
                default -> throw new RuntimeException("Not a browser type");
            }
            BrowserContext context = browser.newContext();
            page = context.newPage();
        }
    }

    public void goTo(final String pageName) {
        String url = parabankConfig.getUrl().replace("{pageName}", pageName);
        page.navigate(url);
    }

    public Page getPage() {
        return page;
    }

    @Override
    public void destroy() {
        if (PwInitializationListener.isInitialized()) {
            browser.close();
            playwright.close();
            PwInitializationListener.setIsInitialized(false);
        }
    }

    private Browser getChromiumBrowser(final BrowserType.LaunchOptions launchOptions) {
        return playwright.chromium().launch(launchOptions);
    }

    private Browser getFirefoxBrowser(final BrowserType.LaunchOptions launchOptions) {
        return playwright.firefox().launch(launchOptions);
    }

    private Browser getWebkitBrowser(final BrowserType.LaunchOptions launchOptions) {
        return playwright.webkit().launch(launchOptions);
    }
}
package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class LoginForm extends BaseForm {
    protected final String ROOT_ELEMENT = "id=loginPanel";

    final Locator usernameInput;
    final Locator passwordInput;
    final Locator loginButton;
    final Locator navigateForgotPasswordButton;
    final Locator navigateRegisterButton;

    protected LoginForm(final PwFactory pwFactory) {
        super(pwFactory);

        usernameInput                = rootElement.locator("//input[@name='username']");
        passwordInput                = rootElement.locator("//input[@name='password']");
        loginButton                  = rootElement.locator("//input[@type='submit']");
        navigateForgotPasswordButton = rootElement.locator("//a[@href='lookup.htm']");
        navigateRegisterButton       = rootElement.locator("//a[@href='register.htm']");
    }

    @Override
    protected String getDefineRootElement() {
        return ROOT_ELEMENT;
    }

    @Override
    public boolean isPresent() {
        // add wait time
        return loginButton.isVisible();
    }
}
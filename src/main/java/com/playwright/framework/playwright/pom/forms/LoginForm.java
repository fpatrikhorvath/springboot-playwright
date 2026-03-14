package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class LoginForm extends BaseForm {

    private static final String USERNAME_INPUT_XPATH                  = "//input[@name='username']";
    private static final String PASSWORD_INPUT_XPATH                  = "//input[@name='password']";
    private static final String LOGIN_BUTTON_XPATH                    = "//input[@type='submit']";
    private static final String NAVIGATE_FORGOT_PASSWORD_BUTTON_XPATH = "//a[@href='lookup.htm']";
    private static final String NAVIGATE_REGISTER_BUTTON_XPATH        = "//a[@href='register.htm']";

    final Locator usernameInput;
    final Locator passwordInput;
    final Locator loginButton;
    final Locator navigateForgotPasswordButton;
    final Locator navigateRegisterButton;

    protected LoginForm(final PwFactory pwFactory) {
        super(pwFactory);
        usernameInput                = page.locator(USERNAME_INPUT_XPATH);
        passwordInput                = page.locator(PASSWORD_INPUT_XPATH);
        loginButton                  = page.locator(LOGIN_BUTTON_XPATH);
        navigateForgotPasswordButton = page.locator(NAVIGATE_FORGOT_PASSWORD_BUTTON_XPATH);
        navigateRegisterButton       = page.locator(NAVIGATE_REGISTER_BUTTON_XPATH);
    }

    @Override
    public boolean isPresent() {
        //add wait time
        return loginButton.isVisible();
    }

    @Override
    public void sendFormButton() {
        return; //todo
    }
}
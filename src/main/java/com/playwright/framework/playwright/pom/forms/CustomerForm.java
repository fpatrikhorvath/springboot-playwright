package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class CustomerForm extends LookUpForm {

    private final String USERNAME_INPUT_ID       = "#customer\\.username";
    private final String PASSWORD_INPUT_ID       = "#customer\\.password";
    private final String PASSWORD_AGAIN_INPUT_ID = "#repeatedPassword";

    private static final String REGISTER_BUTTON_XPATH = "//input[@value='Register']";

    private final Locator registerButton;

    protected CustomerForm(final PwFactory pwFactory) {
        super(pwFactory);

        registerButton = rootElement.locator(REGISTER_BUTTON_XPATH);
    }
    @Override
    protected Locator defineRootElement(final PwFactory pwFactory) {
        // Must define the root element — compiler will force this
        return pwFactory.getPage().locator("id=customerForm");
    }

    @Override
    public boolean isPresent() {
        return registerButton.isVisible();
    }

    @Override
    public void sendFormButton() {
        return; //todo
    }

    public Locator getUsernameInputField() {
        return rootElement.locator(USERNAME_INPUT_ID);
    }

    public Locator getPasswordInputField() {
        return rootElement.locator(PASSWORD_INPUT_ID);
    }

    public Locator getPasswordAgainInputField() {
        return rootElement.locator(PASSWORD_AGAIN_INPUT_ID);
    }

    public Locator getRegisterButton() {
        return rootElement.locator(REGISTER_BUTTON_XPATH);
    }
}
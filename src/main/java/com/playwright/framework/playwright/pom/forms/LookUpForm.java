package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class LookUpForm extends BaseForm {

    protected static final String FIRST_NAME_INPUT_ID = "#customer\\.firstName";
    protected static final String LAST_NAME_INPUT_ID  = "#customer\\.lastName";
    protected static final String STREET_INPUT_ID     = "#customer\\.address\\.street";
    protected static final String CITY_INPUT_ID       = "#customer\\.address\\.city";
    protected static final String STATE_INPUT_ID      = "#customer\\.address\\.state";
    protected static final String ZIP_CODE_INPUT_ID   = "#customer\\.address\\.zipCode";
    protected static final String PHONE_INPUT_ID      = "#customer\\.phoneNumber";
    protected static final String SSN_INPUT_ID        = "#customer\\.ssn";

    private static final String REGISTER_BUTTON_XPATH = "//input[@value='Register']";

    protected final Locator firstNameInput;
    protected final Locator lastNameInput;
    protected final Locator streetInput;
    protected final Locator cityInput;
    protected final Locator stateInput;
    protected final Locator zipCodeInput;
    protected final Locator phoneInput;
    protected final Locator ssnInput;
    protected final Locator registerButton;

    protected LookUpForm(final PwFactory pwFactory) {
        super(pwFactory);

        firstNameInput = page.locator(FIRST_NAME_INPUT_ID);
        lastNameInput  = page.locator(LAST_NAME_INPUT_ID);
        streetInput    = page.locator(STREET_INPUT_ID);
        cityInput      = page.locator(CITY_INPUT_ID);
        stateInput     = page.locator(STATE_INPUT_ID);
        zipCodeInput   = page.locator(ZIP_CODE_INPUT_ID);
        phoneInput     = page.locator(PHONE_INPUT_ID);
        ssnInput       = page.locator(SSN_INPUT_ID);
        registerButton = page.locator(REGISTER_BUTTON_XPATH);
    }

    @Override
    public boolean isPresent() {
        return registerButton.isVisible();
    }

    @Override
    public void sendFormButton() {
        return; //todo
    }
}
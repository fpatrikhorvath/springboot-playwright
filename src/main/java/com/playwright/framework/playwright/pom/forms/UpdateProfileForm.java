package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class UpdateProfileForm extends BaseForm {
    protected final String ROOT_ELEMENT = "id=updateProfileForm";

    protected final Locator firstNameInput;
    protected final Locator lastNameInput;
    protected final Locator streetInput;
    protected final Locator cityInput;
    protected final Locator stateInput;
    protected final Locator zipCodeInput;
    protected final Locator phoneInput;
    protected final Locator ssnInput;

    protected UpdateProfileForm(final PwFactory pwFactory) {
        super(pwFactory);

        firstNameInput = rootElement.locator("#customer\\.firstName");
        lastNameInput  = rootElement.locator("#customer\\.lastName");
        streetInput    = rootElement.locator("#customer\\.address\\.street");
        cityInput      = rootElement.locator("#customer\\.address\\.city");
        stateInput     = rootElement.locator("#customer\\.address\\.state");
        zipCodeInput   = rootElement.locator("#customer\\.address\\.zipCode");
        phoneInput     = rootElement.locator("#customer\\.phoneNumber");
        ssnInput       = rootElement.locator("#customer\\.ssn");
    }

    @Override
    protected String getDefineRootElement() {
        return ROOT_ELEMENT;
    }

    @Override
    public boolean isPresent() {
        return firstNameInput.isVisible();
    }

    public void fill(final String firstName, final String lastName, final String street, final String city,
                     final String state, final String zipCode, final String phone, final String ssn) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        streetInput.fill(street);
        cityInput.fill(city);
        stateInput.fill(state);
        zipCodeInput.fill(zipCode);
        phoneInput.fill(phone);
        ssnInput.fill(ssn);
    }
}
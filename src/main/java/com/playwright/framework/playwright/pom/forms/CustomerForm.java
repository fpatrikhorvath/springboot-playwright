package com.playwright.framework.playwright.pom.forms;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class CustomerForm extends UpdateProfileForm {

    protected final String ROOT_ELEMENT = "id=customerForm";

    protected final Locator usernameInput;
    protected final Locator passwordInput;
    protected final Locator passwordAgainInput;

    protected CustomerForm(final PwFactory pwFactory) {
        super(pwFactory);

        usernameInput      = rootElement.locator("#customer\\.username");
        passwordInput      = rootElement.locator("#customer\\.password");
        passwordAgainInput = rootElement.locator("#repeatedPassword");
    }

    @Override
    protected String getDefineRootElement() {
        return ROOT_ELEMENT;
    }

    public void fill(final String firstName, final String lastName, final String street, final String city,
                     final String state, final String zipCode, final String phone, final String ssn,
                     final String username, final String password) {
        super.fill(firstName, lastName, street, city, state, zipCode, phone, ssn);

        usernameInput.fill(username);
        passwordInput.fill(password);
        passwordAgainInput.fill(password);
    }
}
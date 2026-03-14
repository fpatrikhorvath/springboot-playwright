package com.playwright.framework.playwright.pom;

import com.microsoft.playwright.Locator;
import com.playwright.framework.config.ParabankConfig;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.model.ContextUser;
import com.playwright.framework.playwright.pom.forms.CustomerForm;
import com.playwright.framework.service.util.ExtendedFakerService;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class RegisterPage extends BasePage {
    private static final String PAGE_NAME = "register";

    final CustomerForm         customerForm;
    final ExtendedFakerService fakerService;
    final ParabankConfig       parabankConfig;

    protected RegisterPage(final PwFactory pwFactory, final CustomerForm customerForm,
                           final ExtendedFakerService fakerService, final ParabankConfig parabankConfig) {
        super(pwFactory);
        this.customerForm   = customerForm;
        this.fakerService   = fakerService;
        this.parabankConfig = parabankConfig;
    }

    public CustomerForm getCustomerForm() {
        return customerForm;
    }

    public boolean isAt() {
        return customerForm.getSendButton().isVisible();
    }

    public ContextUser initContextUser() {
        return new ContextUser(fakerService);
    }

    public void fillRegisterForm(final ContextUser user) {
        customerForm.getFirstNameInput().fill(user.getFirstName());
        customerForm.getLastNameInput().fill(user.getLastName());
        customerForm.getStreetInput().fill(user.getStreet());
        customerForm.getCityInput().fill(user.getCity());
        customerForm.getStateInput().fill(user.getState());
        customerForm.getZipCodeInput().fill(String.valueOf(user.getZipCode()));
        customerForm.getPhoneInput().fill(String.valueOf(user.getPhone()));
        customerForm.getSsnInput().fill(user.getSsn());

        customerForm.getUsernameInputField().fill(user.getUsername());
        customerForm.getPasswordInputField().fill(user.getPassword());
        customerForm.getPasswordAgainInputField().fill(user.getPassword());

        customerForm.getSendButton().click();
    }

    public boolean isLogoutButtonVisible() {
        return false;
    }

    public void open() {
        pwFactory.goTo(PAGE_NAME);
    }
}
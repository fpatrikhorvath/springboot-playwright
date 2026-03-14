package com.playwright.framework.playwright.pom;

import com.microsoft.playwright.Locator;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.pom.forms.CustomerForm;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class RegisterPage extends BasePage {
    final CustomerForm customerForm;

    protected RegisterPage(final PwFactory pwFactory, final CustomerForm customerForm) {
        super(pwFactory);
        this.customerForm = customerForm;
    }

    public CustomerForm getCustomerForm() {
        return customerForm;
    }
}

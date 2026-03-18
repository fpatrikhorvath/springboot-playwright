package com.playwright.framework.playwright.pom;

import com.playwright.framework.config.ParabankConfig;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.model.ContextUser;
import com.playwright.framework.playwright.pom.forms.CustomerForm;
import com.playwright.framework.service.util.ExtendedFakerService;
import io.cucumber.spring.ScenarioScope;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class RegisterPage extends BasePage {
    private static final String PAGE_NAME = "register";

    protected final CustomerForm         customerForm;
    protected final ExtendedFakerService fakerService;
    protected final ParabankConfig       parabankConfig;

    protected RegisterPage(final PwFactory pwFactory, final CustomerForm customerForm,
                           final ExtendedFakerService fakerService, final ParabankConfig parabankConfig) {
        super(pwFactory);
        this.customerForm   = customerForm;
        this.fakerService   = fakerService;
        this.parabankConfig = parabankConfig;
    }

    public boolean isAt() {
        return customerForm.isPresent();
    }

    public ContextUser initContextUser() {
        return new ContextUser(fakerService);
    }

    public void fillRegisterForm(final ContextUser user) {
        customerForm.fill(user.getFirstName(), user.getLastName(), user.getStreet(), user.getCity(), user.getState(),
                String.valueOf(user.getZipCode()), String.valueOf(user.getPhone()), user.getSsn(), user.getUsername(),
                          user.getPassword());
        customerForm.sendForm();
    }

    public boolean isUserRegistered(final String username) {
        final String locator = StringUtils.replace("//h1[@class='title' and text()='Welcome {{username}}']",
                                                   "{{username}}", username);
        return page.locator(locator).isVisible();
    }

    public void open() {
        pwFactory.goTo(PAGE_NAME);
    }
}
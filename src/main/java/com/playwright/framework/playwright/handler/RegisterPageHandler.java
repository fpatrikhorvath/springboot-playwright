package com.playwright.framework.playwright.handler;

import com.playwright.framework.config.ParabankConfig;
import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.model.ContextUser;
import com.playwright.framework.playwright.pom.RegisterPage;
import com.playwright.framework.service.util.ExtendedFakerService;
import io.cucumber.spring.ScenarioScope;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@ScenarioScope
@Service
//TODO WE DONT NEED THIS
public class RegisterPageHandler extends BasePageHandler {
    private static final Logger LOG       = LogManager.getLogger(RegisterPageHandler.class);
    private static final String PAGE_NAME = "register";

    private final RegisterPage         registerPage;
    private final ExtendedFakerService fakerService;

    protected RegisterPageHandler(final ParabankConfig parabankConfig, final RegisterPage registerPage,
                                  final ExtendedFakerService fakerService, final PwFactory pwFactory) {
        super(parabankConfig, pwFactory);
        this.registerPage = registerPage;
        this.fakerService = fakerService;
    }

    @Override
    public boolean isAt() {
        return registerPage.getCustomerForm().getSendButton().isVisible();
    }

    public ContextUser initContextUser() {
        return new ContextUser(fakerService);
    }

    public void fillRegisterForm(final ContextUser user) {
        registerPage.getCustomerForm().getFirstNameInput().fill(user.getFirstName());
        registerPage.getCustomerForm().getLastNameInput().fill(user.getLastName());
        registerPage.getCustomerForm().getStreetInput().fill(user.getStreet());
        registerPage.getCustomerForm().getCityInput().fill(user.getCity());
        registerPage.getCustomerForm().getStateInput().fill(user.getFirstName());
        registerPage.getCustomerForm().getZipCodeInput().fill(String.valueOf(user.getZipCode()));
        registerPage.getCustomerForm().getPhoneInput().fill(String.valueOf(user.getPhone()));
        registerPage.getCustomerForm().getSsnInput().fill(user.getSsn());

        registerPage.getCustomerForm().getUsernameInputField().fill(user.getUsername());
        registerPage.getCustomerForm().getPasswordInputField().fill(user.getPassword());
        registerPage.getCustomerForm().getPasswordAgainInputField().fill(user.getPassword());

        registerPage.getCustomerForm().getSendButton().click();
    }

    public boolean isLogoutButtonVisible() {
       return false;
    }

    public void open() {
        pwFactory.goTo(PAGE_NAME);
    }
}

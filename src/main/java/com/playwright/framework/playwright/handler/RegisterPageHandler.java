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
        return registerPage.getRegisterButton().isVisible();
    }

    public ContextUser initContextUser() {
        ContextUser user = new ContextUser();

        user.setFirstName(fakerService.name().firstName());
        user.setLastName(fakerService.name().lastName());
        user.setStreet(fakerService.address().streetAddress());
        user.setCity(fakerService.address().city());
        user.setState(fakerService.address().state());
        user.setZipCode(fakerService.address().zipCode());
        user.setPhone(fakerService.phoneNumber().phoneNumber());
        user.setSsn(fakerService.generateSsn());

        user.setUsername(fakerService.name().username());
        user.setPassword(fakerService.generatePassword());

        LOG.info("User: {}", user);

        return user;
    }

    public void fillRegisterForm(final ContextUser user) {

        registerPage.getFirstNameInputField().fill(user.getFirstName());
        registerPage.getLastNameInputField().fill(user.getLastName());
        registerPage.getStreetInputField().fill(user.getStreet());
        registerPage.getCityInputField().fill(user.getCity());
        registerPage.getStateInputField().fill(user.getFirstName());
        registerPage.getZipCodeInputField().fill(String.valueOf(user.getZipCode()));
        registerPage.getPhoneInputField().fill(String.valueOf(user.getPhone()));
        registerPage.getSsnInputField().fill(user.getSsn());

        registerPage.getUsernameInputField().fill(user.getUsername());
        registerPage.getPasswordInputField().fill(user.getPassword());
        registerPage.getPasswordAgainInputField().fill(user.getPassword());

        registerPage.getRegisterButton().click();
    }

    public void logOut() {
        registerPage.getLogoutButton().click();
    }

    public boolean isLogoutButtonVisible() {
        try {
            return registerPage.getLogoutButton().isVisible();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }


    public String getWelcomeMessage() {
        return registerPage.getWelcomeTitle().textContent();
    }

    public void open() {
        pwFactory.goTo(PAGE_NAME);
    }

}

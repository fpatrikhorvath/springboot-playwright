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

//    private final String FIRST_NAME_INPUT_ID     = "#customer\\.firstName";
//    private final String LAST_NAME_INPUT_ID      = "#customer\\.lastName";
//    private final String STREET_INPUT_ID         = "#customer\\.address\\.street";
//    private final String CITY_INPUT_ID           = "#customer\\.address\\.city";
//    private final String STATE_INPUT_ID          = "#customer\\.address\\.state";
//    private final String ZIP_CODE_INPUT_ID       = "#customer\\.address\\.zipCode";
//    private final String PHONE_INPUT_ID          = "#customer\\.phoneNumber";
//    private final String SSN_INPUT_ID            = "#customer\\.ssn";
//    private final String USERNAME_INPUT_ID       = "#customer\\.username";
//    private final String PASSWORD_INPUT_ID       = "#customer\\.password";
//    private final String PASSWORD_AGAIN_INPUT_ID = "#repeatedPassword";
//
//    private final String REGISTER_BUTTON_XPATH = "//input[@value='Register']";
//    private final String LOGOUT_BUTTON_XPATH   = "//a[@href='logout.htm']";
//    private final String WELCOME_TITLE_XPATH   = "//div[@id='rightPanel']/h1";

    protected RegisterPage(final PwFactory pwFactory, final CustomerForm customerForm) {
        super(pwFactory);
        this.customerForm = customerForm;
    }

    public CustomerForm getCustomerForm() {
        return customerForm;
    }
//    public Locator getFirstNameInputField() {
//        return page.locator(FIRST_NAME_INPUT_ID);
//    }
//
//    public Locator getLastNameInputField() {
//        return page.locator(LAST_NAME_INPUT_ID);
//    }
//
//    public Locator getStreetInputField() {
//        return page.locator(STREET_INPUT_ID);
//    }
//
//    public Locator getCityInputField() {
//        return page.locator(CITY_INPUT_ID);
//    }
//
//    public Locator getStateInputField() {
//        return page.locator(STATE_INPUT_ID);
//    }
//
//    public Locator getZipCodeInputField() {
//        return page.locator(ZIP_CODE_INPUT_ID);
//    }
//
//    public Locator getPhoneInputField() {
//        return page.locator(PHONE_INPUT_ID);
//    }
//
//    public Locator getSsnInputField() {
//        return page.locator(SSN_INPUT_ID);
//    }
//
//    public Locator getUsernameInputField() {
//        return page.locator(USERNAME_INPUT_ID);
//    }
//
//    public Locator getPasswordInputField() {
//        return page.locator(PASSWORD_INPUT_ID);
//    }
//
//    public Locator getPasswordAgainInputField() {
//        return page.locator(PASSWORD_AGAIN_INPUT_ID);
//    }
//
//    public Locator getRegisterButton() {
//        return page.locator(REGISTER_BUTTON_XPATH);
//    }
//
//    public Locator getLogoutButton() {
//        return page.locator(LOGOUT_BUTTON_XPATH);
//    }
//
//    public Locator getWelcomeTitle() {
//        return page.locator(WELCOME_TITLE_XPATH);
//    }
}

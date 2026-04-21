package com.playwright.framework.stepdefs.pageSteps;

import com.playwright.framework.context.ScenarioCxt;
import com.playwright.framework.playwright.PageObjectFactory;
import com.playwright.framework.stepdefs.TestCore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;


public class RegisterPageSteps extends TestCore {

    public RegisterPageSteps(final ScenarioCxt scenarioContext, final PageObjectFactory pageObjectFactory) {
        super(scenarioContext, pageObjectFactory);
    }

    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        registerPage.open();
        registerPage.isAt();
    }

    @When("I sign up with correct credentials and store it as {word}")
    public void iSignUpWithCorrectCredentialsAndStoreItAs(final String identifier) {
        cxt.storeCxtUser(identifier, registerPage.initContextUser());
        registerPage.fillRegisterForm(cxt.getCxtUser(identifier));
    }

    @Then("verify that the user {word} is registered")
    public void verifyThatTheUserIsRegistered(final String identifier) {
        assertTrue("User is not registered!",
                   registerPage.isUserRegistered(cxt.getCxtUser(identifier).getUsername()));
    }
}
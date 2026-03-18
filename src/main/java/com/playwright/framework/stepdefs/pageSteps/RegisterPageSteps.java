package com.playwright.framework.stepdefs.pageSteps;

import com.playwright.framework.context.ScenarioContext;
import com.playwright.framework.playwright.model.ContextUser;
import com.playwright.framework.playwright.pom.IndexPage;
import com.playwright.framework.playwright.pom.RegisterPage;
import com.playwright.framework.stepdefs.TestCore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;


public class RegisterPageSteps extends TestCore {

    public RegisterPageSteps(final ScenarioContext scenarioContext, final IndexPage indexPage,
                             final RegisterPage registerPage) {
        super(scenarioContext, indexPage, registerPage);
    }

    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        registerPage.open();
        registerPage.isAt();
    }

    @When("I sign up with correct credentials and store it as {word}")
    public void iSignUpWithCorrectCredentialsAndStoreItAs(final String identifier) {
        final ContextUser user = registerPage.initContextUser();
        registerPage.fillRegisterForm(user);
        scenarioContext.storeContextObject(identifier, user);
    }

    @Then("verify that the user {word} is registered")
    public void verifyThatTheUserIsRegistered(final String identifier) {
        assertTrue(registerPage.isLogoutButtonVisible());
    }
}
package com.playwright.framework.playwright.pom;

import com.playwright.framework.playwright.PwFactory;
import com.playwright.framework.playwright.pom.forms.LoginForm;
import io.cucumber.spring.ScenarioScope;
import org.springframework.stereotype.Component;

@ScenarioScope
@Component
public class IndexPage extends BasePage {
    private final LoginForm loginForm;

    protected IndexPage(final PwFactory pwFactory, final LoginForm loginForm) {
        super(pwFactory);
        this.loginForm = loginForm;
    }

    public boolean isLoggedIn() {
        //add wait
        return loginForm.isPresent();
    }

    @Override
    public boolean isAt() {
        return false;
    }
}

package com.fxhive.pages;

import com.fxhive.constants.ElementRepository;

/**
 * Page Object for the FXhive login screen.
 */
public class LoginPage extends BasePage {

    /* ---------- Page actions ---------- */

    /** Open the login URL */
    public LoginPage open(String url) {
        navigateTo(url);
        return this;
    }

    /** Type username */
    public LoginPage enterUsername(String user) {
        type(ElementRepository.LOGIN_EMAIL_TEXTBOX, user);
        return this;                   // fluent
    }

    /** Type password */
    public LoginPage enterPassword(String pass) {
        type(ElementRepository.LOGIN_PASSWORD_TEXTBOX, pass);
        return this;
    }

    /** Click Login and land on the next page */
    public HomePage clickLogin() {
        click(ElementRepository.LOGIN_BUTTON);
        return new HomePage();         // stub for now
    }

    /** Convenience method that performs a full login */
    public HomePage loginAs(String user, String pass, String url) {
        return open(url)
                .enterUsername(user)
                .enterPassword(pass)
                .clickLogin();
    }
}

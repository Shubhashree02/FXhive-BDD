package com.fxhive.pages;

import com.fxhive.constants.ElementRepository;
import com.fxhive.utils.ConfigUtil;

/**
 * Page Object for the FXhive login screen.
 */
public class LoginPage extends BasePage {

    /* ---------- Page actions ---------- */

    /** Open the login URL */
    public LoginPage open() {
        String url = ConfigUtil.getDefaultBaseUrl();
        navigateTo(url);
        return this;
    }

    /** Type username */
    public LoginPage enterUsername(String username) {
        type(ElementRepository.LOGIN_EMAIL_TEXTBOX, username);
        return this;                   // fluent
    }

    /** Type password */
    public LoginPage enterPassword(String password) {
        type(ElementRepository.LOGIN_PASSWORD_TEXTBOX, password);
        return this;
    }

    /** Click Login and land on the next page */
    public HomePage clickLogin() {
        click(ElementRepository.LOGIN_BUTTON);
        return new HomePage();         // stub for now
    }

    /** Convenience method that performs a full login */
    public HomePage loginAs(String username, String password) {
        return open()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }
}

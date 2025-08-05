package com.fxhive.pages;

/** Placeholder – we’ll flesh this out later */
public class HomePage extends BasePage {

    public boolean isWelcomeMessageDisplayed() {
        // update the locator later with your real one
        return isDisplayed(com.fxhive.constants.ElementRepository.HOME_WELCOME_MESSAGE);
    }
}

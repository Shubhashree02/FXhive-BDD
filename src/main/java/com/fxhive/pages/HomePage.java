package com.fxhive.pages;

import com.fxhive.constants.ElementRepository;

public class HomePage extends BasePage {

    // Check if dashboard URL is loaded
    public boolean isAtDashboard() {
        return getCurrentUrl().equals("https://stage.fxhive.site/dashboard.html");
    }

    // Get any login message text (success or error)
    public String getLoginMessageText() {
        if (isDisplayed(ElementRepository.LOGIN_MESSAGE)) {
            return getText(ElementRepository.LOGIN_MESSAGE).trim();
        }
        return "";
    }
}

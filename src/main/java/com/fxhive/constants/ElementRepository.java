package com.fxhive.constants;

import org.openqa.selenium.By;

/**
 * Central repository for all UI element locators
 * Store all textboxes, buttons, checkboxes, dropdowns here
 */
public final class ElementRepository {

    private ElementRepository() {}

    // ============== LOGIN PAGE ELEMENTS ==============
    public static final By LOGIN_EMAIL_TEXTBOX = By.id("username");
    public static final By LOGIN_PASSWORD_TEXTBOX = By.cssSelector("input[type='password']");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit' and text()='Login']");
    public static final By LOGIN_REMEMBER_CHECKBOX = By.id("remember-me");
    public static final By LOGIN_FORGOT_PASSWORD_LINK = By.linkText("Forgot Password?");

    // ============== HOME PAGE ELEMENTS ==============
    public static final By HOME_WELCOME_MESSAGE = By.className("welcome-message");
    public static final By HOME_LOGOUT_BUTTON = By.xpath("//button[text()='Logout']");
    public static final By HOME_USER_DROPDOWN = By.id("user-dropdown");
    public static final By HOME_PROFILE_LINK = By.linkText("Profile");

    // ============== COMMON ELEMENTS ==============
    public static final By LOADING_SPINNER = By.className("loading-spinner");
    public static final By ERROR_MESSAGE_TOAST = By.className("toast-error");
    public static final By SUCCESS_MESSAGE_TOAST = By.className("toast-success");
    public static final By CLOSE_MODAL_BUTTON = By.xpath("//button[@class='modal-close']");

    // ============== FORM ELEMENTS ==============
    public static final By SEARCH_TEXTBOX = By.name("search");
    public static final By SEARCH_BUTTON = By.xpath("//button[contains(@class,'search-btn')]");
    public static final By FILTER_DROPDOWN = By.id("filter-select");
    public static final By SUBMIT_BUTTON = By.xpath("//input[@type='submit']");
    public static final By CANCEL_BUTTON = By.xpath("//button[text()='Cancel']");

    // ============== TABLE ELEMENTS ==============
    public static final By DATA_TABLE = By.id("data-table");
    public static final By TABLE_ROWS = By.xpath("//table[@id='data-table']//tr");
    public static final By FIRST_ROW_EDIT_BUTTON = By.xpath("(//table[@id='data-table']//tr)[1]//button[text()='Edit']");

    // Add more elements as needed for your application
    // Example: public static final By YOUR_ELEMENT = By.locator("value");
}

package com.fxhive.stepdefinitions;

import com.fxhive.core.DriverManager;
import com.fxhive.pages.HomePage;
import com.fxhive.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;

/**
 * Step definitions that bind Gherkin steps in login.feature
 * to Selenium actions implemented in page objects.
 */
public class LoginSteps {

    private LoginPage loginPage;
    private HomePage  homePage;

    /* ---------- Hooks run before & after every scenario ---------- */

    @Before
    public void setUp() {
        DriverManager.initDriver("chrome");   // or read from config
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    /* ----------------- Gherkin step bindings -------------------- */

    @Given("the browser is open")
    public void the_browser_is_open() {
        // Nothing to do – handled in @Before
    }

    @When("user navigates to {string}")
    public void user_navigates_to(String url) {
        loginPage.open(url);
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {
        homePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }

    @Then("welcome message should be displayed")
    public void welcome_message_should_be_displayed() {
        Assert.assertTrue(
                homePage.isWelcomeMessageDisplayed(),
                "Welcome message NOT displayed – login failed");
    }
}

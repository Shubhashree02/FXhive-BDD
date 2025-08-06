package com.fxhive.stepdefinitions;

import com.fxhive.core.DriverManager;
import com.fxhive.pages.HomePage;
import com.fxhive.pages.LoginPage;
import com.fxhive.utils.ExcelUtil;
import com.fxhive.constants.ElementRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    private static Object[][] allLoginData;

    static {
        allLoginData = ExcelUtil.readSheet(
                "src/test/resources/testdata/LoginData.xlsx",
                "Sheet1"
        );
    }

    @Before
    public void setUp() {
        DriverManager.initDriver("chrome");
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Given("the browser is open")
    public void the_browser_is_open() {
        // handled in @Before
    }

    @When("user navigates to the login page")
    public void user_navigates_to_the_login_page() {
        loginPage.open();
    }

    @When("user logs in with excel row {int}")
    public void user_logs_in_with_excel_row(int excelRow) {
        if (excelRow < 0 || excelRow >= allLoginData.length) {
            throw new IllegalArgumentException("Excel row " + excelRow + " is out of range!");
        }
        String username = allLoginData[excelRow][0].toString();
        String password = allLoginData[excelRow][1].toString();
        homePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }

    @Then("a login message should be displayed")
    public void a_login_message_should_be_displayed() {
        String msg = homePage.getLoginMessageText().trim();
        Assert.assertFalse(
                msg.isEmpty(),
                "Expected a login message to be displayed, but no message was found!"
        );
    }

//    @Then("dashboard should be displayed")
//    public void dashboard_should_be_displayed() {
//        Assert.assertTrue(
//                homePage.isAtDashboard(),
//                "Dashboard was NOT displayed – login failed"
//        );
//    }

}

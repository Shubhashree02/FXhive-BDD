Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given the browser is open
    When user navigates to "https://testapp/login"
    And user logs in with "user1" and "pass1"
    Then welcome message should be displayed

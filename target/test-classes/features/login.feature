Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given the browser is open
    When user navigates to the login page
    And user logs in with excel row 0
    Then a login message should be displayed
    



#  Scenario: Failed login with invalid credentials
#    Given the browser is open
#    When user navigates to the login page
#    And user logs in with excel row 1
#    Then a login message should be displayed
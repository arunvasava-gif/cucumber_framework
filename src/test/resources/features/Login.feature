Feature: Login functionality

  Scenario: Valid login
    Given user is on login page
    When user enters valid username and password
    Then user should be navigated to the home page

  Scenario: inValid login
    Given user is on login page
    When user enters invalid username and password
    Then User should get no match found message
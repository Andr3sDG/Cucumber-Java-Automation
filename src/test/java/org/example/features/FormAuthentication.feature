Feature: Form Authentication
  In order to test the authentication method works
  As Tom Smith
  I want to be able to login with the user credentials

  Scenario: Successful login
    Given I enter to the login page
    When I enter my username = "tomsmith" and password = "SuperSecretPassword!"
      And I click on login
    Then I should be able to see the main page
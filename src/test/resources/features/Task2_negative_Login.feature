Feature: Negative Login Scenarios

  Background: User is on the login page
    Given user navigates to the login page

  @NegativeLogin
  Scenario Outline: Invalid login attempts
    When user enters "<username>" as username and "<password>" as password
    And user clicks on the login button
    Then an error message "<message>" should be displayed

    Examples:
      | username       | password       | message                         |
      |                |                | Username and Password required   |
      | admin      |                | Password is required             |
      |                | 123   | Username is required             |
      | wrongUser      | 123   | Incorrect username or password     |
      | admin      | wrongPass123   | Incorrect username or password    |

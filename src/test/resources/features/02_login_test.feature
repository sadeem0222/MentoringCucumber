@Login
Feature: Login Feature

  Background:
    Given user is on the signin page

  @LoginPositive
  Scenario: Happy Path
    When user enters valid username
    And user enters valid password
    And user click on submit button
    Then user validates the signin
    And close browser

  @InvalidUsername
  Scenario: Wrong username
    When user enters invalid username
    And user enters valid password
    And user click on submit button
    Then assert alert message
    And close browser

  @InvalidPassword @smoke
  Scenario: Wrong password
    When user enters valid username
    And user enters invalid password
    And user click on submit button
    Then assert alert message
    And close browser

  @EmptyUsername
  Scenario: Empty username
    And user enters valid password
    And user click on submit button
    Then assert empty username message
    And close browser

  @EmptyPassword @smoke
  Scenario: Empty password
    And user enters valid username
    And user click on submit button
    Then assert empty password message
    And close browser
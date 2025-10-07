Feature: Parameterized Feature

  Background: Go to app
    Given user visits "https://claruswaysda.github.io/deleteChars.html"

  Scenario: Parameterized Scenario
    When user enters "John" into input

  Scenario: Parameterized Scenario
    When user enters "Mary" into input


  Scenario: Parameterized Scenario
    When user enters "Tom" into input

  Scenario: Parameterized Scenario
    When user enters "George" into input

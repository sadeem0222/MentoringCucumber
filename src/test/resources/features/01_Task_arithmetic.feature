@arithmetic
Feature: Simple Arithmetic Operations
  This feature tests basic arithmetic operations (addition, subtraction, division)
  using a simple web application for demonstration purposes.

  @smoke @positive
  Scenario: Addition of two positive numbers
    Given the user opens the arithmetic application
    And the user enters 5 in the first number field
    And the user enters 10 in the second number field
    When the user clicks the "Add" button
    Then the result should be 15

  @smoke @negative
  Scenario: Subtraction resulting in a negative number
    Given the user opens the arithmetic application
    And the user enters 5 in the first number field
    And the user enters 10 in the second number field
    When the user clicks the "Subtract" button
    Then the result should be -5

  @negative
  Scenario: Division by zero
    Given the user opens the arithmetic application
    And the user enters 10 in the first number field
    And the user enters 0 in the second number field
    When the user clicks the "Divide" button
    Then the application should display an error message "Cannot divide by zero"

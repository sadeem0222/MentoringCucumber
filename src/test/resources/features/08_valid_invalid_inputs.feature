Feature: valid_invalid_inputs

@InputValidationValid
  Scenario: valid inputs
    Given user opens the validation page
    And user enters valid inputs
      |1234567|
      |1234567|
      |1234567|
      |1234567|
      |1234567|

  @InputValidationInvalid
  Scenario: invalid inputs
    Given user opens the validation page
    And user enters invalid inputs
      |()/&%+^'111|
      |abc|
      |aaaaaaaaaaaaaaa|
      | |
      |=)(/&%+'!|
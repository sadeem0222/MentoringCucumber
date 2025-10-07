Feature: User Registration

  @RegisterUsers
  Scenario Outline: Register multiple users with different data
    Given user navigates to "https://claruswaysda.github.io/form.html"
    When user enters "<ssn>" as SSN
    And user enters "<firstName>" as First Name
    And user enters "<lastName>" as Last Name
    And user enters "<address>" as Address
    And user enters "<phone>" as Phone Number
    And user enters "<username>" as Username
    And user enters "<email>" as Email
    And user enters "<password>" as Password
    And user enters "<confirmPassword>" as Confirm Password
    And user clicks Register
    Then registration should be successful

    Examples:
      | ssn         | firstName | lastName | address        | phone       | username   | email                | password | confirmPassword |
      | 123-45-6789 | John      | Doe      | 123 Main St    | 555-1234    | johndoe    | johndoe@mail.com     | Pass123  | Pass123         |
      | 987-65-4321 | Mary      | Smith    | 456 Oak St     | 555-5678    | marysmith  | marysmith@mail.com   | Mary123  | Mary123         |
      | 111-22-3333 | Tom       | Johnson  | 789 Pine St    | 555-8765    | tomj       | tomj@mail.com        | Tom123   | Tom123          |
      | 222-33-4444 | Alice     | Brown    | 321 Elm St     | 555-4321    | aliceb     | aliceb@mail.com      | Alice123 | Alice123        |
      | 333-44-5555 | Bob       | Davis    | 654 Cedar St   | 555-9876    | bobd       | bobd@mail.com        | Bob123   | Bob123          |

Feature: students application

  @StudentPositive
  Scenario: happy path
    Given user visits "https://claruswaysda.github.io/addStudent.html"
    When user enters valid student name "jhon"
    And user enters valid student id "1234"
    And user enters valid student email "john@gmail.com"
    And user enters valid course "math"
    And user select grade "A"
    And user click on addSubmit button
    Then assert that student is added

  @WrongEmail
  Scenario Outline: Wrong Email
    Given user visits "https://claruswaysda.github.io/addStudent.html"
    When user enters valid student name "<name>"
    And user enters valid student id "<id>"
    And user enters wrong format student email "<email>"
    And user enters valid course "<cource>"
    And user select grade "<grade>"
    And user click on addSubmit button
    Then assert that error message is displayed "<error message>"
    Examples:
      |name | id | email | cource | grade | error message |
      |John Doe | 1234 | gmail | math | A |  |

  @DeleteStudent
  Scenario: Delete Student
    Given user visits "https://claruswaysda.github.io/addStudent.html"
    When user enters valid student name "jhon"
    And user enters valid student id "1234"
    And user enters valid student email "john@gmail.com"
    And user enters valid course "math"
    And user select grade "A"
    And user click on addSubmit button
    And user click on delete student button
    Then assert that student deleted

  @ClearAll
  Scenario: Clear all Student
    Given user visits "https://claruswaysda.github.io/addStudent.html"
    When user enters valid student name "jhon"
    And user enters valid student id "1234"
    And user enters valid student email "john@gmail.com"
    And user enters valid course "math"
    And user select grade "A"
    And user click on addSubmit button
    And user click on clear all button
    Then assert that all student deleted

  @SearchStudentBySearchBar
  Scenario: Search StudentBy Search Bar
    Given user visits "https://claruswaysda.github.io/addStudent.html"
    When user enters valid student name "jhon"
    And user enters valid student id "1234"
    And user enters valid student email "john@gmail.com"
    And user enters valid course "math"
    And user select grade "A"
    And user click on addSubmit button
    And user click on Search Bar
    And user enters student name "jhon"
    Then the student list should display matching results for "jhon"

  @SortStudents
  Scenario Outline: Sort students by different criteria
    Given user visits "https://claruswaysda.github.io/addStudent.html"
    And the following students exist:
      | Name         | ID  | Email             | Course   | Grade |
      | John Doe     | 101 | john@example.com  | Math     | A     |
      | Alice Smith  | 102 | alice@example.com | Physics  | B+    |


    When user selects sort option "<sortOption>"
    Then the student list should be sorted by "<sortOption>"

    Examples:
      | sortOption |
      | new        |
      | old        |
      | name       |





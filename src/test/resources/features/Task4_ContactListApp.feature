Feature: Contact Management
  This feature verifies that a user can create an account, add a contact, edit it, and delete it successfully.

  @CreateAccount
  Scenario: Create a new user account
    Given the user is on the registration page
    When the user enters first name "Sandedjdemc"
    And the user enters last name "Alhdmarntdhic"
    And the user enters email "hdnndmdddsh@example.com"
    And the user enters password "adsdds12345"
    When the user clicks the contact button "Submit"
    Then the user account should be created successfully

  @AddContact
  Scenario: Add a new contact
    Given the user is logged in and on the contact list page
    When the user clicks the "Add Contact" button
    And the user enters first name "John"
    And the user enters last name "Doe"
    And the user enters birthdate "1990-01-01"
    And the user enters email "john.doe@example.com"
    And the user enters phone "0555123456"
    And the user enters address "123 Elm Street"
    And the user enters address2 "123 ghi"
    And the user enters city "Jeddah"
    And the user enters state "Makkah"
    And the user enters postal code "21577"
    And the user enters country "Saudi Arabia"
    And the user submits the contact form
    Then the contact "John Doe" should be displayed in the contact list

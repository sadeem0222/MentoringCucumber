package stepdefinitions;


import Pages.AddContactPage;
import Pages.AddUserPage;
import Pages.ContactListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.Driver;

import java.time.Duration;

public class ContactManagementSteps {

    AddUserPage addUserPage = new AddUserPage();
    AddContactPage addContactPage = new AddContactPage();
    ContactListPage contactListPage = new ContactListPage();


    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
    }

    @When("the user enters first name {string}")
    public void the_user_enters_first_name(String firstName) {
        addUserPage.enterFirstname(firstName);
    }

    @When("the user enters last name {string}")
    public void the_user_enters_last_name(String lastName) {
        addUserPage.enterLastname(lastName);
    }

    @When("the user enters email {string}")
    public void the_user_enters_email(String email) {
        addUserPage.enterEmail(email);
    }

    @When("the user enters password {string}")
    public void the_user_enters_password(String password) {
        addUserPage.enterPassword(password);
    }

    @When("the user clicks the contact button {string}")
    public void the_user_clicks_contact_button(String buttonName) {
        addUserPage.submitBttun();
    }


    @Then("the user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
        // Wait for up to 5 seconds for the Add Contact button to appear
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean isAddContactVisible = wait.until(d ->
                d.findElements(By.id("add-contact")).size() > 0
        );

        Assert.assertTrue("User account was not created or Add Contact button not visible",
                isAddContactVisible);
    }




    @Given("the user is logged in and on the contact list page")
    public void the_user_is_logged_in_and_on_the_contact_list_page() {
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addContact");
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String buttonText) {
        if (buttonText.equalsIgnoreCase("Add Contact")) {
            contactListPage.clickAddContact();
        }
    }

    @When("the user enters birthdate {string}")
    public void the_user_enters_birthdate(String birthdate) {
        addContactPage.enterBirthdate(birthdate);
    }

    @When("the user enters phone {string}")
    public void the_user_enters_phone(String phone) {
        addContactPage.enterPhone(phone);
    }

    @When("the user enters address {string}")
    public void the_user_enters_address(String address) {
        addContactPage.enterStreet1(address);
    }

    @When("the user enters address2 {string}")
    public void the_user_enters_address2(String address2) {
        addContactPage.enterStreet2(address2);
    }

    @When("the user enters city {string}")
    public void the_user_enters_city(String city) {
        addContactPage.enterCity(city);
    }

    @When("the user enters state {string}")
    public void the_user_enters_state(String state) {
        addContactPage.enterStateProvince(state);
    }

    @When("the user enters postal code {string}")
    public void the_user_enters_postal_code(String postalCode) {
        addContactPage.enterPostalCode(postalCode);
    }

    @When("the user enters country {string}")
    public void the_user_enters_country(String country) {
        addContactPage.enterCountry(country);
    }

    @When("the user submits the contact form")
    public void the_user_submits_the_contact_form() {
        addContactPage.clickSubmit();
    }

    @Then("the contact {string} should be displayed in the contact list")
    public void the_contact_should_be_displayed_in_the_contact_list(String contactName) {
        Assert.assertTrue(" Contact not found: " + contactName,
                contactListPage.isContactDisplayed(contactName));
    }

}
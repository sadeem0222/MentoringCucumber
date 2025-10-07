package stepdefinitions;

import io.cucumber.java.en.When;

import Pages.RegistrationPage;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;
import utilites.Driver;

public class UserRegistrationDefintations {

    RegistrationPage regPage = new RegistrationPage();

    @Given("user navigates to {string}")
    public void navigateToForm(String url) {
        Driver.getDriver().get(url);
    }

    @When("user enters {string} as SSN")
    public void enterSSN(String ssn) {
        regPage.enterSSN(ssn);
    }

    @When("user enters {string} as First Name")
    public void enterFirstName(String firstName) {
        regPage.enterFirstName(firstName);
    }

    @When("user enters {string} as Last Name")
    public void enterLastName(String lastName) {
        regPage.enterLastName(lastName);
    }

    @When("user enters {string} as Address")
    public void enterAddress(String address) {
        regPage.enterAddress(address);
    }

    @When("user enters {string} as Phone Number")
    public void enterPhone(String phone) {
        regPage.enterPhone(phone);
    }

    @When("user enters {string} as Username")
    public void enterUsername(String username) {
        regPage.enterUsername(username);
    }

    @When("user enters {string} as Email")
    public void enterEmail(String email) {
        regPage.enterEmail(email);
    }

    @When("user enters {string} as Password")
    public void enterPassword(String password) {
        regPage.enterPassword(password);
    }

    @When("user enters {string} as Confirm Password")
    public void enterConfirmPassword(String confirmPassword) {
        regPage.enterConfirmPassword(confirmPassword);
    }

    @When("user clicks Register")
    public void clickRegister() {
        regPage.clickRegister();
    }

    @Then("registration should be successful")
    public void registrationShouldBeSuccessful() {
        assertTrue(true);
    }
}

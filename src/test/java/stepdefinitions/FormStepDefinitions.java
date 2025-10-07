package stepdefinitions;

import Pages.FormPage;
import io.cucumber.java.en.When;

public class FormStepDefinitions {

    @When("user enters first name {string}")
    public void user_enters_first_name(String firstname) {
        FormPage formPage=new FormPage();
        formPage.enterFirstname(firstname);

    }

    @When("user enters last name {string}")
    public void user_enters_last_name(String lastname) {
        FormPage formPage=new FormPage();
        formPage.enterLastname(lastname);

    }

    @When("user enters age {string}")
    public void user_enters_age(String age) {
        FormPage formPage=new FormPage();
        formPage.enterAge(age);
    }

    @When("user enters country {string}")
    public void user_enters_country(String country) {
        FormPage formPage=new FormPage();
        formPage.selectCountry(country);

    }

    @When("user enters notes {string}")
    public void user_enters_notes(String note) {
        FormPage formPage=new FormPage();
        formPage.enterNotes(note);

    }

}
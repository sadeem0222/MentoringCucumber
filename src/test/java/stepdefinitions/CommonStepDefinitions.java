package stepdefinitions;

import Pages.DeleteCharsPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.v138.input.model.DragData;
import utilites.Driver;

public class CommonStepDefinitions {

    @Then("close browser")
    public void close_browser() {
        Driver.closeDriver();
    }

    @Given("user visits {string}")
    public void userVisits(String url) {
        Driver.getDriver().get(url);
    }
}
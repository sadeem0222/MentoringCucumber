package stepdefinitions;


import io.cucumber.java.en.Then;
import org.openqa.selenium.devtools.v138.input.model.DragData;
import utilites.Driver;

public class CommonStepDefinitions {

    @Then("close browser")
    public void close_browser() {
        Driver.closeDriver();
    }

}
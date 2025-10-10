package stepdefinitions;

import Pages.InputValidatioPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilites.Driver;

import java.util.List;

public class ValidInvalidDefinitions {
    @Given("user opens the validation page")
    public void userOpensTheValidationPage() {
        Driver.getDriver().get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
    }

    @And("user enters valid inputs")
    public void userEntersValidInputs(DataTable dataTable) {
        InputValidatioPage inputValidationPage = new InputValidatioPage();
            List<String> inputs = dataTable.asList();
            for(String input : inputs){
                inputValidationPage.enterCharacters(input);
                inputValidationPage.clickValidate();
                System.out.println("Entered valid input: " + input + " -> validation message: " + inputValidationPage.getValidationMessage());
            }
    }

    @And("user enters invalid inputs")
    public void userEntersInvalidInputs(DataTable dataTable) {
        InputValidatioPage inputValidationPage = new InputValidatioPage();
        List<String> inputs = dataTable.asList();
        for(String input : inputs){
            inputValidationPage.enterCharacters(input);
            inputValidationPage.clickValidate();
            System.out.println("Entered invalid input: " + input + " -> validation message: " + inputValidationPage.getValidationMessage());
        }
    }
}

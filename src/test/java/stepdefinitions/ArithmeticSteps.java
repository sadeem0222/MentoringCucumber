//package stepdefinitions;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import utilites.Driver;
//
//public class ArithmeticSteps {
//
//    @Given("the user opens the arithmetic application")
//    public void the_user_opens_the_arithmetic_application() {
//        Driver.getDriver().get("file:///C:/Users/USER/IdeaProjects/MentoringCucumber/arithmetic.html"); // the html file i made
//    }
//
//    @And("the user enters {int} in the first number field")
//    public void the_user_enters_in_the_first_number_field(int num1) {
//        Driver.getDriver().findElement(By.id("num1")).clear();
//        Driver.getDriver().findElement(By.id("num1")).sendKeys(String.valueOf(num1));
//    }
//
//    @And("the user enters {int} in the second number field")
//    public void the_user_enters_in_the_second_number_field(int num2) {
//        Driver.getDriver().findElement(By.id("num2")).clear();
//        Driver.getDriver().findElement(By.id("num2")).sendKeys(String.valueOf(num2));
//    }
//
//    @When("the user clicks the {string} button")
//    public void the_user_clicks_the_button(String button) {
//        String id;
//        switch (button) {
//            case "Add":
//                id = "addBtn";
//                break;
//            case "Subtract":
//                id = "subBtn";
//                break;
//            case "Divide":
//                id = "divBtn";
//                break;
//            default:
//                throw new IllegalArgumentException("Unknown button: " + button);
//        }
//        Driver.getDriver().findElement(By.id(id)).click();
//    }
//
//    @Then("the result should be {int}")
//    public void the_result_should_be(int expected) {
//        String actual = Driver.getDriver().findElement(By.id("result")).getText();
//        Assert.assertEquals(String.valueOf(expected), actual);
//    }
//
//    @Then("the application should display an error message {string}")
//    public void the_application_should_display_an_error_message(String expectedMsg) {
//        String actual = Driver.getDriver().findElement(By.id("result")).getText();
//        Assert.assertEquals(expectedMsg, actual);
//    }
//}

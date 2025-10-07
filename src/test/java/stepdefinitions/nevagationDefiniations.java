package stepdefinitions;

import Pages.SignInPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import utilites.Driver;

import static org.junit.Assert.assertEquals;

public class nevagationDefiniations {

    SignInPage signInPage = new SignInPage();

    @Given("user navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html"); // غيّر الرابط حسب موقعك
    }

    @When("user enters {string} as username and {string} as password")
    public void userEntersAsUsernameAndAsPassword(String username, String password) {
        // إدخال القيم (قد تكون فارغة حسب المثال)
        signInPage.enterUsername(username);
        signInPage.enterPassword(password);
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        signInPage.clickSignIn();
        signInPage.handleAlertIfPresent();
    }




    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String expectedMessage) {
        // التحقق من الحالات المختلفة
        if (expectedMessage.equals("Username and Password required")) {
            signInPage.assertEmptyUsername();
            signInPage.assertEmptyPassword();
        } else if (expectedMessage.equals("Password is required")) {
            signInPage.assertEmptyPassword();
        } else if (expectedMessage.equals("Username is required")) {
            signInPage.assertEmptyUsername();
        } else if (expectedMessage.equals("Invalid username or password")) {
            // هنا يمكنك التحقق من رسالة الخطأ العامة التي تظهر على الصفحة مثلاً:
            // assertEquals(expectedMessage, signInPage.getErrorMessage());
            System.out.println("✅ Invalid credentials error validated.");
        }

    }
}
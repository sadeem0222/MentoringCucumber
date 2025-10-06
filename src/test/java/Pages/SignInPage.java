package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;
import utilites.ReusableMethods;

import static org.junit.Assert.assertEquals;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement signInButton;

    public SignInPage enterUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public SignInPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public EmployeeTablePage clickSignIn() {
        signInButton.click();
        return new EmployeeTablePage();
    }

    public SignInPage assertEmptyUsername() {
        assertEquals("يُرجى ملء هذا الحقل.", ReusableMethods.getValidationMessage(usernameInput));
        return this;
    }
    public SignInPage assertEmptyPassword() {
        assertEquals("يُرجى ملء هذا الحقل.", ReusableMethods.getValidationMessage(passwordInput));
        return this;
    }



}
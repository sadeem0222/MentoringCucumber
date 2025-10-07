package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.Driver;

public class RegistrationPage {


    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    private WebElement ssnInput;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirm-password")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[text()='Register']")
    private WebElement registerButton;

    // Methods to fill each field
    public void enterSSN(String ssn) {
        ssnInput.sendKeys(ssn);
    }
    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }
    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }
    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }
    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }
    public void clickRegister() {
        registerButton.click();
    }
}

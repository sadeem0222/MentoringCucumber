package Pages;

import org.openqa.selenium.By;
import utilites.Driver;

public class AddContactPage {

    public By firstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By birthdate = By.id("birthdate");
    public By email = By.id("email");
    public By phone = By.id("phone");
    public By street1 = By.id("street1");
    public By street2 = By.id("street2");
    public By city = By.id("city");
    public By stateProvince = By.id("stateProvince");
    public By postalCode = By.id("postalCode");
    public By country = By.id("country");
    public By submit = By.id("submit");
    public By cancel = By.id("cancel");

    public AddContactPage enterFirstName(String firstInput) {
        Driver.getDriver().findElement(firstName).sendKeys(firstInput);
        return this;
    }

    public AddContactPage enterLastName(String lastInput) {
        Driver.getDriver().findElement(lastName).sendKeys(lastInput);
        return this;
    }

    public AddContactPage enterBirthdate(String birthInput) {
        Driver.getDriver().findElement(birthdate).sendKeys(birthInput);
        return this;
    }

    public AddContactPage enterEmail(String emailInput) {
        Driver.getDriver().findElement(email).sendKeys(emailInput);
        return this;
    }

    public AddContactPage enterPhone(String phoneInput) {
        Driver.getDriver().findElement(phone).sendKeys(phoneInput);
        return this;
    }

    public AddContactPage enterStreet1(String street1Input) {
        Driver.getDriver().findElement(street1).sendKeys(street1Input);
        return this;
    }

    public AddContactPage enterStreet2(String street2Input) {
        Driver.getDriver().findElement(street2).sendKeys(street2Input);
        return this;
    }

    public AddContactPage enterCity(String cityInput) {
        Driver.getDriver().findElement(city).sendKeys(cityInput);
        return this;
    }

    public AddContactPage enterStateProvince(String stateInput) {
        Driver.getDriver().findElement(stateProvince).sendKeys(stateInput);
        return this;
    }

    public AddContactPage enterPostalCode(String postalInput) {
        Driver.getDriver().findElement(postalCode).sendKeys(postalInput);
        return this;
    }

    public AddContactPage enterCountry(String countryInput) {
        Driver.getDriver().findElement(country).sendKeys(countryInput);
        return this;
    }

    public AddContactPage clickSubmit() {
        Driver.getDriver().findElement(submit).click();
        return this;
    }

    public AddContactPage clickCancel() {
        Driver.getDriver().findElement(cancel).click();
        return this;
    }
}

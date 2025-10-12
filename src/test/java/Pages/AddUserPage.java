package Pages;

import org.openqa.selenium.By;
import utilites.Driver;

public class AddUserPage {
    public By firstName =By.id("firstName");
    public By lastName =By.id("lastName");
    public By email =By.id("email");
    public By password =By.id("password");
    public By submit =By.id("submit");


    public AddUserPage enterFirstname(String firstinput){
        Driver.getDriver().findElement(firstName).sendKeys(firstinput);
        return this;
    }
    public AddUserPage enterLastname(String lastinput){
        Driver.getDriver().findElement(lastName).sendKeys(lastinput);
        return this;
    }

    public AddUserPage enterEmail(String emailinput){
        Driver.getDriver().findElement(email).sendKeys(emailinput);
        return this;
    }
    public AddUserPage enterPassword(String passinput){
        Driver.getDriver().findElement(password).sendKeys(passinput);
        return this;
    }
    public AddUserPage submitBttun(){
        Driver.getDriver().findElement(submit).click();
        return this;
    }

}

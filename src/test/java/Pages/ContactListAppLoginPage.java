package Pages;

import org.openqa.selenium.By;
import utilites.Driver;

public class ContactListAppLoginPage {
    public By email =By.id("email");
    public By password =By.id("password");
    public By submit =By.id("submit");
    public By signup =By.id("signup");



    public ContactListAppLoginPage enterEmail(String emailinput){
        Driver.getDriver().findElement(email).sendKeys(emailinput);
        return this;
    }
    public ContactListAppLoginPage enterPassword(String passinput){
        Driver.getDriver().findElement(password).sendKeys(passinput);
        return this;
    }
    public ContactListAppLoginPage submitBttun(){
        Driver.getDriver().findElement(submit).click();
        return this;
    }
    public ContactListAppLoginPage signupBttun(){
        Driver.getDriver().findElement(signup).click();
        return this;
    }
}

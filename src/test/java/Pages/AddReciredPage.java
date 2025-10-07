package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilites.Driver;

import java.util.List;

public class AddReciredPage {

    public AddReciredPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "nameInput")
    private WebElement nameInput;

    @FindBy(id = "ageInput")
    private WebElement ageInput;

    @FindBy(id = "countrySelect")
    private WebElement countrySelect;

    @FindBy(xpath = "//button[.='Add Record']")
    private WebElement addRecord;

    @FindBy(id = "tableBody")
    private WebElement tableBody;

    public void entername(String name){
        nameInput.sendKeys(name);
    }
    public void enterage(String age){
        ageInput.sendKeys(age);
    }
    public void selectcountry(String counrty){
new Select(countrySelect).selectByVisibleText(counrty);
    }

    public void clickAddRecord() {
        addRecord.click();
    }
    public int getNumberOfRows() {
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        return rows.size();
    }
}

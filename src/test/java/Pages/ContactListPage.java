package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.Driver;

import java.time.Duration;
import java.util.List;

public class ContactListPage {

    public By addContactButton = By.id("add-contact");
    public By logoutButton = By.id("logout");
    public By contactRows = By.cssSelector("table#myTable tr.contactTableBodyRow");
    public By contactTable = By.id("myTable");


    public ContactListPage clickAddContact() {
        Driver.getDriver().findElement(addContactButton).click();
        return this;
    }

    public ContactListPage clickLogout() {
        Driver.getDriver().findElement(logoutButton).click();
        return this;
    }

    public ContactListPage clickFirstContact() {
        List<WebElement> rows = Driver.getDriver().findElements(contactRows);
        if (!rows.isEmpty()) {
            rows.get(0).click(); // Clicks the first contact in the list
        }
        return this;
    }

    public ContactListPage clickContactByName(String name) {
        List<WebElement> rows = Driver.getDriver().findElements(contactRows);
        for (WebElement row : rows) {
            if (row.getText().toLowerCase().contains(name.toLowerCase())) {
                row.click();
                break;
            }
        }
        return this;
    }
    public boolean isContactDisplayed(String contactName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contactRows));
            List<WebElement> rows = Driver.getDriver().findElements(contactRows);
            for (WebElement row : rows) {
                String rowTextNormalized = row.getText().toLowerCase().replaceAll("\\s","");
                String contactNormalized = contactName.toLowerCase().replaceAll("\\s","");
                if(rowTextNormalized.contains(contactNormalized)){
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public int getContactCount() {
        List<WebElement> rows = Driver.getDriver().findElements(contactRows);
        return rows.size();
    }
}

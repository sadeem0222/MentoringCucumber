package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.Driver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AddStudentsPage {
    public By name =By.id("name");
    public By studentId =By.id("studentId");
    public By email =By.id("email");
    public By course =By.id("course");
    public By grade =By.id("grade");
    public By submitBtn =By.id("submitBtn");
    public By clearAll =By.id("clearAll");
    private By firstRow = By.xpath("//tbody/tr");
    private By studentRows = By.cssSelector("table tbody tr");
    public By deleteButton = By.cssSelector("button[data-action='del']");
    public By searchBar =  By.id("q");
    public By sortSelect = By.id("sort");


    public AddStudentsPage enterfullname(String fullname){
        Driver.getDriver().findElement(name).sendKeys(fullname);
        return this;
    }
    public AddStudentsPage enterid(String id){
        Driver.getDriver().findElement(this.studentId).sendKeys(id);
        return this;
    }
    public AddStudentsPage enterEmail(String email1){
        Driver.getDriver().findElement(this.email).sendKeys(email1);
        return this;
    }
    public AddStudentsPage enterCourse(String course1){
        Driver.getDriver().findElement(this.course).sendKeys(course1);
        return this;
    }
    public AddStudentsPage enterGrade(String grade1){
        new Select(Driver.getDriver().findElement(this.grade)).selectByVisibleText(grade1);
        return this;
    }
    public AddStudentsPage addSrudentBtn(){
        Driver.getDriver().findElement(submitBtn).click();
        return this;
    }
    public AddStudentsPage assertStudentAdded() {
        assertTrue(Driver.getDriver().findElement(firstRow).isDisplayed());
        return this;
    }
    public String getEmailValidationMessage() {
        WebElement emailField = Driver.getDriver().findElement(this.email);
        return emailField.getAttribute("validationMessage");
    }

    public AddStudentsPage clickDeleteButton() {
        Driver.getDriver().findElement(deleteButton).click();
        return this;
    }

    public boolean isStudentDeleted() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(studentRows));
            List<WebElement> rows = Driver.getDriver().findElements(studentRows);

            return rows.isEmpty();
        } catch (TimeoutException e) {
            System.out.println("Student not deleted within time limit.");
            return false;
        } catch (NoSuchElementException e) {

            return true;
        } catch (Exception e) {
            System.out.println("Unexpected error while checking deletion: " + e.getMessage());
            return false;
        }
    }
    public void handleDeleteAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println(" No alert appeared after deletion.");
        }
    }
    public AddStudentsPage clearAllStudents() {
        Driver.getDriver().findElement(clearAll).click();
        return this;
    }
    public boolean isStudentTableEmpty() {
        List<WebElement> rows = Driver.getDriver().findElements(studentRows);
        return rows.size() == 0;
    }
    public AddStudentsPage clickSearchBar() {
        Driver.getDriver().findElement(searchBar).click();
        return this;
    }

    public AddStudentsPage searchStudentByName(String name) {
        WebElement searchInput =  Driver.getDriver().findElement(searchBar);
        searchInput.clear();
        searchInput.sendKeys(name);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }
    }





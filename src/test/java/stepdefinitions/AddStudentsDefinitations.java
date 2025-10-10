package stepdefinitions;

import Pages.AddStudentsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AddStudentsDefinitations {

        @When("user enters valid student name {string}")
        public void userEntersValidStudentName(String name) {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.enterfullname(name);
        }
    @And("user enters student name {string}")
    public void userSearchesStudentByName(String name) {
        AddStudentsPage addStudentsPage = new AddStudentsPage();
        addStudentsPage.searchStudentByName(name);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(driver -> {
            List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
            for (WebElement row : rows) {
                if (row.getText().toLowerCase().contains(name.toLowerCase())) {
                    return true;
                }
            }
            return false;
        });
    }

        @And("user enters valid student id {string}")
        public void userEntersValidStudentId(String id) {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.enterid(id);
        }

        @And("user enters valid student email {string}")
        public void userEntersValidStudentEmail(String email) {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.enterEmail(email);
        }

        @And("user enters valid course {string}")
        public void userEntersValidCourse(String course) {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.enterCourse(course);
        }

        @And("user select grade {string}")
        public void userSelectGrade(String grade) {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.enterGrade(grade);
        }

        @And("user click on addSubmit button")
        public void userClickOnAddSubmitButton() {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.addSrudentBtn();
        }

        @Then("assert that student is added")
        public void assertThatStudentIsAdded() {
            AddStudentsPage addStudentsPage =new AddStudentsPage();
            addStudentsPage.assertStudentAdded();
        }

        @And("user enters wrong format student email {string}")
        public void userEntersWrongFormatStudentEmail() {
            AddStudentsPage addStudentsPage =new AddStudentsPage();

            String actualMessage = addStudentsPage.getEmailValidationMessage();
            System.out.println("Validation message: " + actualMessage);
            Assert.assertTrue(
                    "Expected email format validation message, but got: " + actualMessage,
                    actualMessage.contains("@") || actualMessage.contains("البريد الإلكتروني") || actualMessage.toLowerCase().contains("email"));
        }

        @Then("assert that error message is displayed {string}")
        public void assertThatErrorMessageIsDisplayed(String msg) {

        }
    @And("user click on delete student button")
    public void userClickOnDeleteStudentButton() {
        AddStudentsPage addStudentsPage =new AddStudentsPage();
        addStudentsPage.clickDeleteButton();
        addStudentsPage.handleDeleteAlert();
    }

    @Then("assert that student deleted")
    public void assertThatStudentDeleted() {
        AddStudentsPage addStudentsPage =new AddStudentsPage();
        boolean deleted = addStudentsPage.isStudentDeleted();
        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student still in the table.");
        }

        Assert.assertTrue("Student was not deleted from the table!", deleted);
    }

    @And("user click on clear all button")
    public void userClickOnClearAllButton() {
        AddStudentsPage addStudentsPage =new AddStudentsPage();
        addStudentsPage.clearAllStudents();
        addStudentsPage.handleDeleteAlert();
    }

    @Then("assert that all student deleted")
    public void assertThatAllStudentDeleted() {
        AddStudentsPage addStudentsPage = new AddStudentsPage();
        Assert.assertTrue("Table is not empty after clearing all students!", addStudentsPage.isStudentTableEmpty());
    }
    @And("user click on Search Bar")
    public void userClickOnSearchBar() {
        AddStudentsPage addStudentsPage = new AddStudentsPage();
        addStudentsPage.clickSearchBar();
    }

    @Then("the student list should display matching results")
    public void theStudentListShouldDisplayMatchingResults() {
        AddStudentsPage addStudentsPage = new AddStudentsPage();
        String searchText = Driver.getDriver().findElement(By.id("q")).getAttribute("value").toLowerCase();

        List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector("table#studentsTable tbody tr"));

        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().toLowerCase().contains(searchText)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue("No matching student found for search: " + searchText, found);
    }
    @Then("the student list should display matching results for {string}")
    public void theStudentListShouldDisplayMatchingResultsFor(String searchText) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("table tbody tr")));
        List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector("table tbody tr"));

        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().toLowerCase().contains(searchText.toLowerCase())) {
                found = true;
                break;
            }
        }

        Assert.assertTrue("No matching student found for search: " + searchText, found);
    }
    @When("user selects sort option {string}")
    public void userSelectsSortOption(String sortOption) {
        WebElement sortDropdown = Driver.getDriver().findElement(By.id("sort"));
        Select select = new Select(sortDropdown);
        select.selectByValue(sortOption);
    }

    @Then("the student list should be sorted by {string}")
    public void theStudentListShouldBeSortedBy(String sortOption) {
        List<WebElement> rows = Driver.getDriver().findElements(By.cssSelector("table tbody tr"));
        List<String> values = new ArrayList<>();

        switch (sortOption) {
            case "new":
                for (WebElement row : rows) {
                    values.add(row.getAttribute("data-idx"));
                }
                // تحقق أن القيم تنازلية
                for (int i = 0; i < values.size() - 1; i++) {
                    Assert.assertTrue(Integer.parseInt(values.get(i)) > Integer.parseInt(values.get(i + 1)));
                }
                break;

            case "old":
                for (WebElement row : rows) {
                    values.add(row.getAttribute("data-idx"));
                }
                for (int i = 0; i < values.size() - 1; i++) {
                    Assert.assertTrue(Integer.parseInt(values.get(i)) < Integer.parseInt(values.get(i + 1)));
                }
                break;

            case "name":
                for (WebElement row : rows) {
                    values.add(row.findElement(By.cssSelector("td:first-child")).getText().toLowerCase());
                }
                List<String> sorted = new ArrayList<>(values);
                Collections.sort(sorted);
                Assert.assertEquals("Student names are not sorted alphabetically", sorted, values);
                break;
        }
    }
    @And("the following students exist:")
    public void theFollowingStudentsExist(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> students = dataTable.asMaps(String.class, String.class);
        AddStudentsPage addStudentsPage = new AddStudentsPage();

        for (Map<String, String> student : students) {
            addStudentsPage
                    .enterfullname(student.get("Name"))
                    .enterid(student.get("ID"))
                    .enterEmail(student.get("Email"))
                    .enterCourse(student.get("Course"))
                    .enterGrade(student.get("Grade"))
                    .addSrudentBtn();
        }
    }

}



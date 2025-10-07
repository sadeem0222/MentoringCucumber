package stepdefinitions;
import Pages.AddReciredPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddRecordStepDefinitions {
    AddReciredPage addReciredPage = new AddReciredPage();

    @When("enter data")
    public void enter_data(DataTable dataTable) {

        // تحويل DataTable إلى List من List
        List<List<String>> Lists = dataTable.asLists(String.class);

        // حلقة for-each صحيحة
        for (List<String> eachList : Lists) {
            System.out.println("eachList = " + eachList);

            // لو تحب تدخل البيانات في الصفحة
            String name = eachList.get(0);
            String age = eachList.get(1);
            String country = eachList.get(2);

            addReciredPage.entername(name);
            addReciredPage.enterage(age);
            addReciredPage.selectcountry(country);
            addReciredPage.clickAddRecord();

        }
    }

    @Then("table should contain {int} rows of data")
    public void verifyNumberOfRows(int expectedRows) {
        int actualRows = addReciredPage.getNumberOfRows();
        assertEquals("The number of rows in the table is incorrect!", expectedRows, actualRows);
    }


}

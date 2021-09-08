package bank.com.stepDefinitions;

import bank.com.pages.LoginPage;
import bank.com.pages.US_012Page;
import bank.com.utilities.JSUtils;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class US_12_ManagerCustomer_StepDefinitions {

    LoginPage loginpage = new LoginPage();
    US_012Page us_012Page = new US_012Page();



    @Then("User sees all registrations info")
    public void user_sees_all_registrations_info(io.cucumber.datatable.DataTable dataTable) {
//io.cucumber.datatable.DataTable dataTable
        Assert.assertTrue(us_012Page.columnList.get(0).getText().contains(dataTable.cell(0,0)));
        System.out.println(us_012Page.columnList.get(0).getText());

        Assert.assertTrue(us_012Page.columnList.get(1).getText().contains(dataTable.cell(1,0)));
        System.out.println(us_012Page.columnList.get(1).getText());

        Assert.assertTrue(us_012Page.columnList.get(2).getText().contains(dataTable.cell(2,0)));
        System.out.println(us_012Page.columnList.get(2).getText());

        Assert.assertTrue(us_012Page.columnList.get(3).getText().contains(dataTable.cell(3,0)));
        System.out.println(us_012Page.columnList.get(3).getText());

        Assert.assertTrue(us_012Page.columnList.get(4).getText().contains(dataTable.cell(4,0)));
        System.out.println(us_012Page.columnList.get(4).getText());

        Assert.assertTrue(us_012Page.columnList.get(5).getText().contains(dataTable.cell(5,0)));
        System.out.println(us_012Page.columnList.get(5).getText());

        Assert.assertTrue(us_012Page.columnList.get(6).getText().contains(dataTable.cell(6,0)));
        System.out.println(us_012Page.columnList.get(6).getText());

        Assert.assertTrue(us_012Page.columnList.get(7).getText().contains(dataTable.cell(7,0)));
        System.out.println(us_012Page.columnList.get(7).getText());

        Assert.assertTrue(us_012Page.columnList.get(8).getText().contains(dataTable.cell(8,0)));
        System.out.println(us_012Page.columnList.get(8).getText());

        ReusableMethods.waitFor(3);

    }

    @And("User click view button")
    public void userClickViewButton() {
        us_012Page.viewButton.click();

        ReusableMethods.waitFor(3);
    }

    @Then("User sees all information populated")
    public void userSeesAllInformationPopulated() {



        List<WebElement> expectedList = us_012Page.viewList;
        for (WebElement each : expectedList) {
         //   System.out.println(each.getText());
        }
        ReusableMethods.waitFor(3);
        Assert.assertTrue(expectedList.get(0).getText().contains("Donte"));
        Assert.assertTrue(expectedList.get(3).getText().contains("julius"));
        Assert.assertTrue(expectedList.get(9).getText().contains("789"));
    }

    @And("User sees edit button")
    public void userSeesEditButton() {
        us_012Page.editButton.isDisplayed();

        ReusableMethods.waitFor(3);

    }

    @Then("User clicks edit button")
    public void userClicksEditButton() {
        us_012Page.editButton.click();

        ReusableMethods.waitFor(3);

    }

    @Then("User sees all editable information populated")
    public void userSeesAllEditableInformationPopulated() {

        List<WebElement> editableList = us_012Page.editList;
        for (WebElement each : editableList){
         //   System.out.println(each.getText());

        }
        Assert.assertTrue(editableList.get(0).getText().contains("ID"));
        ReusableMethods.waitFor(3);

    }

//    @When("User click edit button")
//    public void userClickEditButton() {
//        us_012Page.editButton1.click();
//        ReusableMethods.waitFor(3);
//
//    }

    @Then("User update information")
    public void userUpdateInformation() {
        us_012Page.firstName2.clear();
        us_012Page.firstName2.sendKeys("Halime");
        ReusableMethods.waitFor(3);
        String firstname = us_012Page.firstName2.getAttribute("value");
        Assert.assertEquals(firstname,"Halime");

        us_012Page.lastName2.clear();
        us_012Page.lastName2.sendKeys("Agir");
        ReusableMethods.waitFor(3);
        String lastname = us_012Page.lastName2.getAttribute("value");
        Assert.assertEquals(lastname,"Agir");

        us_012Page.middleInitial.clear();
        us_012Page.middleInitial.sendKeys("M");
        ReusableMethods.waitFor(3);
        String midInitial = us_012Page.middleInitial.getAttribute("value");
        Assert.assertEquals(midInitial,"M");


    }

    @And("User back customerHomePage")
    public void userBackCustomerHomePage() {
        us_012Page.backButton.click();
        ReusableMethods.waitFor(3);
    }

    @When("User click delete button")
    public void userClickDeleteButton() {
        JSUtils.clickElementByJS(us_012Page.delete);
       //us_012Page.delete.click();
        ReusableMethods.waitFor(3);

    }

    @Then("User sees confirm delete operation message")
    public void userSeesConfirmDeleteOperationMessage() {
        String expectedeleteMessage =  us_012Page.confDeleteMessage.getText();
        System.out.println(expectedeleteMessage);

        Assert.assertTrue( us_012Page.confDeleteMessage.isDisplayed());

    }

    @And("User click second delete button")
    public void userClickSecondDeleteButton() {
        us_012Page.delete2.click();
        ReusableMethods.waitFor(3);

    }

    @And("User sees success edit message")
    public void userSeesSuccesEditMesagge() {
        Assert.assertTrue(us_012Page.deleteSuccesMessage.isDisplayed());

    }

    @And("User sees all registrations info{int}")
    public void userSeesAllRegistrationsInfo(int arg0) {
    }
}


package bank.com.stepDefinitions;

import bank.com.pages.LoginPage;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;


public class US_009_StepDefinition {
   bank.com.pages.LoginPage loginPage=new bank.com.pages.LoginPage();
bank.com.pages.US_009Page us_009Page=new bank.com.pages.US_009Page();
    SoftAssert softAssert=new SoftAssert();

    @And("User enter valid {string}")
    public void userEnterValid(String username) {
    loginPage.loginPageUsernameTextBox.sendKeys(ConfigReader.getProperty(username));

    }

    @And("User enters valid {string}")
    public void userEntersValid(String password) {
        loginPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty(password));

    }

    @Then("User cliks sign in button")
    public void userCliksSignInButton() {

        loginPage.loginPageSignInButton.click();

    }

    @And("User clicks My Opertions")
    public void userClicksMyOpertions() {
        us_009Page.MyOpertions.click();

    }


    @Then("User select Manage Customers")
    public void userSelectManageCustomers() {
us_009Page.ManageCustomers.click();

    }

    @And("User clicks Create a New Customer")
    public void userClicksCreateANewCustomer() {
us_009Page.CreateaNewCustomer.click();

    }

    @And("User enter {string}")
    public void userEnter(String ssn) {
us_009Page.SSN.sendKeys(ConfigReader.getProperty(ssn));

    }

    @And("User cliks Search button")
    public void userCliksSearchButton() {
us_009Page.searchButton.click();

    }

    @Then("User sees success message")
    public void userSeesSuccessMessage() {
    softAssert.assertTrue(us_009Page.succesmessage.isDisplayed());
       softAssert.assertAll();

    }
    @And("User sees firstname written")
    public void userSeesFirstnameWritten() {
        softAssert.assertTrue(us_009Page.firstname.isDisplayed());
        softAssert.assertAll();

    }

    @And("User sees lastname written")
    public void userSeesLastnameWritten() {
softAssert.assertTrue(us_009Page.lastname.isDisplayed());
softAssert.assertAll();

    }

    @And("User sees Email written")
    public void userSeesEmailWritten() {
softAssert.assertTrue(us_009Page.email.isDisplayed());
softAssert.assertAll();

    }

    @And("User sees Adress written")
    public void userSeesAdressWritten()  {

softAssert.assertTrue(us_009Page.adress.isDisplayed());
softAssert.assertAll();

    }

    @Then("User sees SSN written")
    public void userSeesSSNWritten() {
softAssert.assertTrue(us_009Page.SSN.isDisplayed());
softAssert.assertAll();

    }


}

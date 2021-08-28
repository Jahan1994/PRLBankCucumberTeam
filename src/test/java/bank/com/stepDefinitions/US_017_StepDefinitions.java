package bank.com.stepDefinitions;

import bank.com.pages.LoginPage;
import bank.com.pages.US_017_Pages;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US_017_StepDefinitions {


    US_017_Pages us_17 = new US_017_Pages();
    LoginPage loginPage = new LoginPage();
    public static int order;
    public static String userName = "";
    public static int page = 1;

    @Then("enters valid <{string}> as admin")
    public void entersValidAsAdmin(String username) {
        loginPage.loginPageUsernameTextBox.sendKeys(ConfigReader.getProperty(username));
    }

    @Then("enters a valid <{string}>  as admin")
    public void entersAValidAsAdmin(String password) {
        loginPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty(password));
    }

    @Then("clicks the sing in button")
    public void clicksTheSingInButton() {
        loginPage.loginPageSignInButtonSibel.click();
    }

    @Then("clicks on the Administration link from the active page")
    public void clicksOnTheAdministrationLinkFromTheActivePage() {
        us_17.administration.click();
    }

    @Then("clicks on the User Management link from the dropdown menu")
    public void clicksOnTheUserManagementLinkFromTheDropdownMenu() {
        us_17.userManagement.click();
    }


    //=================================================================================================

    @Then("user clicks on the date")
    public void userClicksOnTheDate() {
        us_17.createdDate.click();


    }
    @Then("user searches for {string}")
    public void userSearchesFor(String userName) {
        int count = 0;

        for (int i = 1; i <= 20; i++) {
            if (us_17.getUserName(i).equals(userName)) {
                count++;
                us_17.pressEditButton(i);
                page = 1;
                break;
            }
        }
        if (count == 0) {
            page++;
            us_17.pageLinkClick(page);
            userSearchesFor(userName);
        }
    }


    @Then("activates the user")
    public void activatesTheUser() {

        if (!us_17.activationCheckBox.isSelected()) {
         US_017_Pages.sleep(1000);
            us_17.activationCheckBox.click();
        }
      US_017_Pages.sleep(3000);
    }

    @Then("clicks save button")
    public void clicksSaveButton() {

        us_17.saveButton.click();
    }


    @Then("asserts the updated message")
    public void assertsTheUpdatedMessage() {
        US_017_Pages.sleep(2000);

        Assert.assertTrue(us_17.notifications.isDisplayed());

        System.out.println("User " + userName + " has been updated successfully ");
    }

    //===================================================================

    @Then("selects {string} role and clicks the view button")
    public void selectsRoleAndClicksTheViewButton(String profile) {
        order = 1;
        while (!us_17.getProfileName(order).equals(profile)) {
            order++;
        }
        userName = us_17.getUserName(order);
        us_17.pressViewButton(order);
       US_017_Pages.sleep(2000);


    }

    @Then("asserts that the user info is displayed")
    public void assertsThatTheUserInfoIsDisplayed() {

        for (WebElement userInfo : us_17.userInfoCells) {

            Assert.assertFalse(userInfo.getText().isBlank());

        }
    }
//========================================================================


    @Then("clicks {string} edit button")
    public void clicksEditButton(String profile) {
        order = 1;
        while (!us_17.getProfileName(order).equals(profile)) {
            order++;
        }
        userName = us_17.getUserName(order);
        us_17.pressEditButton(order);
      US_017_Pages.sleep(2000);

    }

    @Then("updates user info")
    public void updatesUserInfo() {
        List<String> fakeUserInfo = new ArrayList<>(us_17.fakeInfo());
        us_17.loginName.click();
        us_17.loginName.clear();
        us_17.loginName.sendKeys(fakeUserInfo.get(0));
        us_17.firstName.click();
        us_17.firstName.clear();
        us_17.firstName.sendKeys(fakeUserInfo.get(1));
        us_17.lastName.click();
        us_17.lastName.clear();
        us_17.lastName.sendKeys(fakeUserInfo.get(2));
        us_17.email.click();
        us_17.email.clear();
        us_17.email.sendKeys(fakeUserInfo.get(3));
    }

    @Then("selects {string} role")
    public void selectsRole(String profile) {

        Select select = new Select(us_17.profiles);

        select.deselectAll();
        select.selectByVisibleText(profile);
        US_017_Pages.sleep(3000);
    }

    @Then("asserts all info")
    public void assertsAllInfo() {
        for (WebElement infoOfUser : us_17.userInfoCells) {

            Assert.assertFalse(infoOfUser.getText().isBlank());

        }
        System.out.println("User's all info has been viewed successfully");
    }

    @Then("navigates back")
    public void navigatesBack() {

        Driver.getDriver().navigate().back();
    }

    @Then("user searches for {string} to delete")
    public void userSearchesForToDelete(String userName) {
        int count = 0;
        for (int i = 1; i <= 20; i++) {
            if (us_17.getUserName(i).equals(userName)) {
                count++;
                us_17.pressDeleteButton(i);
                page = 1;
                break;
            }
        }
        if (count == 0) {
            page++;
            us_17.pageLinkClick(page);
            userSearchesForToDelete(userName);
        }
    }

    @Then("confirms delete operation")
    public void confirmsDeleteOperation() {
        WebElement del = Driver.getDriver().findElement(By.xpath("//div[@class='modal-content']//button[@class='btn btn-danger']"));
        ReusableMethods.waitForClickablility(del, 15);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", del);

    }


//    @Then("asserts the deleted message")
//    public void assertsTheDeletedMessage() {
//        ReusableMethods.sleep(2000);
//
//        Assert.assertTrue(us_17.notifications.isDisplayed());
//
//        System.out.println("User " + userName + " has been deleted successfully ");
//    }
}

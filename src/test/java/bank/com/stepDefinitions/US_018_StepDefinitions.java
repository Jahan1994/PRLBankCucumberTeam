package bank.com.stepDefinitions;

import bank.com.pages.US_017_Pages;
import bank.com.pages.US_018_Pages;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;

public class US_018_StepDefinitions {

    US_017_Pages us_17 = new US_017_Pages();
    US_018_Pages us_18 = new US_018_Pages();

    @Then("clicks on the My Operations link")
    public void clicksOnTheMyOperationsLink() {
        us_18.myOperationsButton.click();
    }

    @Then("clicks on the Manage Customers link")
    public void clicksOnTheManageCustomersLink() {

        us_18.manageCustomersButton.click();
    }

    //============================================================================
    @Then("asserts the elements visibility")
    public void assertsTheElementsVisibility() {

        for (WebElement each : us_18.visibleElements) {
            System.out.println(each.getText());
            Assert.assertTrue(each.isDisplayed());
        }
    }
//==========================================================================

    @Then("asserts the view button is displayed")
    public void assertsTheViewButtonIsDisplayed() {
        Assert.assertTrue(us_18.viewButton.isDisplayed());
    }

    @Then("clicks the view button")
    public void clicksTheViewButton() {

        us_18.viewButton.click();
    }

    @Then("asserts the edit button at the bottom")
    public void assertsTheEditButtonAtTheBottom() {
        Assert.assertTrue(us_18.userInfoEditButton.isDisplayed());
        Assert.assertTrue(us_18.userInfoEditButton.getText().contains("Edit"));
    }
//=======================================================================

    @Then("asserts the Edit button is displayed")
    public void assertsTheEditButtonIsDisplayed() {
        Assert.assertTrue(us_18.editButton.isDisplayed());
    }

//===========================================================================

    @Then("clicks the edit button")
    public void clicksTheEditButton() {
        //  ReusableMethods.randomIntegerGenerator(20);
        us_17.pressEditButton(9);
    }

    @Then("updates or creates user info")
    public void updatesOrCreatesUserInfo() {
        List<String> fakeUserInfo = new ArrayList<>(us_18.fakeInfo());

        us_18.firstName.click();
        us_18.firstName.clear();
        us_18.firstName.sendKeys(fakeUserInfo.get(0));
        us_18.lastName.click();
        us_18.lastName.clear();
        us_18.lastName.sendKeys(fakeUserInfo.get(1));
        us_18.middleName.click();
        us_18.middleName.clear();
        us_18.middleName.sendKeys(fakeUserInfo.get(2));
        us_18.email.click();
        us_18.email.clear();
        us_18.email.sendKeys(fakeUserInfo.get(3));

    }

    @Then("clicks the delete button")
    public void clicksTheDeleteButton() {
        us_18.deleteButton.click();

    }

    @Then("asserts the deletion message")
    public void assertsTheDeletionMessage() {
        ReusableMethods.waitForVisibility(us_18.deletePopUp, 1);
        String expectedId = us_18.idButton.getText();
        String expectedMessage = "Are you sure you want to delete Customer";
        String expectedDeleteMessage = expectedMessage + " " + expectedId + "?";
        String actualDeleteMessage = us_18.deleteQuestion.getText();
        Assert.assertEquals(expectedDeleteMessage, actualDeleteMessage);
    }

    @Then("clicks the delete button on the popup")
    public void clicksTheDeleteButtonOnThePopup() {
        us_18.popupDeleteButton.click();
    }
}

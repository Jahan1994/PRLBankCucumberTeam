package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.US_007_Page;
import bank.com.pages.US_008_PasswordPage;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US_007_StepDefinitions {

    HomePage homePage =new HomePage();
    LoginPage loginPage =new LoginPage();
    US_007_Page us_007_page=new US_007_Page();
    US_008_PasswordPage us_008_passwordPage=new US_008_PasswordPage();


    @Given("User click account menu")
    public void user_click_account_menu() {
        ReusableMethods.waitFor(2);
        us_007_page.accountMenu.click();
        ReusableMethods.waitFor(2);

    }
    @Then("User click user info")
    public void user_click_user_info() {
        us_007_page.userInfoClick.click();

    }
    @Then("User send {string} into email box")
    public void user_send_into_email_box(String string) {

        us_007_page.emailBoxClick.clear();
        ReusableMethods.waitFor(2);

        us_007_page.emailBoxClick.sendKeys(string);
        ReusableMethods.waitFor(2);

        System.out.println(us_007_page.invalidFeedback.getText());

    }
    //  @Then("User click save button")
//    public void userClickSaveButton() {
//        us_007_page.saveButton.click();
//        ReusableMethods.waitFor(2);
//
//        System.out.println(us_007_page.invalidFeedback.getText());
//
//    }

    @Then("User varifies that can not update with {string}")
    public void userVarifiesThatCanNotUpdateWith(String string) {

        String invalidMessage= Driver.getDriver().getPageSource();

        Assert.assertTrue(invalidMessage.contains("This field is invalid"));
        System.out.println("user see 'This field is invalid'");
    }

    @And("user click to user info")
    public void userClickToUserInfo() {
        us_007_page.userInfoClick.click();
        ReusableMethods.waitFor(2);

    }

    @Given("user click to account menu")
    public void userClickToAccountMenu() {
        us_007_page.accountMenu.click();
        ReusableMethods.waitFor(2);
    }

    @And("user send  new email into the email box")
    public void userSendNewEmailIntoTheEmailBox() {
        us_007_page.emailBoxClick.clear();
        ReusableMethods.waitFor(2);
        us_007_page.emailBoxClick.sendKeys("12345@mailcom");

    }

    @And("user click save button")
    public void userClickSaveButton() {
        us_008_passwordPage.saveButton.click();

    }

//    @Then("user assert that user account can not update with invalid email address")
//    public void userAssertThatUserAccountCanNotUpdateWithInvalidEmailAddress() {
//
//        String invalidMessage= Driver.getDriver().getPageSource();
//        System.out.println(invalidMessage);
//        Assert.assertTrue(invalidMessage.contains("This field is invalid"));
//        System.out.println("user see 'This field is invalid'");
//
//    }


    List<WebElement> languageOptions;
    @And("user see an option language dropdown")
    public void userGiveAnOptionLanguageDropdown() {



        Select select=new Select(us_007_page.languageSelect);
        us_007_page.languageSelect.click();
        ReusableMethods.waitFor(2);
        languageOptions=select.getOptions();
//        System.out.println(languageOptions.get(0).getText());
//        System.out.println(languageOptions.get(1).getText());


    }

    @Then("user assert that there is no option other than English and Turkish")
    public void userAssertThatThereIsNoOptionOtherThanEnglishAndTurkish() {
        Select select=new Select(us_007_page.languageSelect);
        us_007_page.languageSelect.click();
        List<WebElement> languageOptions;
        languageOptions=select.getOptions();
        System.out.println("Language Option1 : " + languageOptions.get(0).getText());
        System.out.println("Language Option2 : " + languageOptions.get(1).getText());

        for (WebElement each:languageOptions) {
            boolean languages=each.getText().equals("Türkçe")||each.getText().equals("English") ;
            Assert.assertTrue("user can only select English or Turkish",languages);
        }
        ReusableMethods.waitFor(2);
    }


}

//    @Then("User send test data into email box")
//    public void user_send_test_data_into_email_box(DataTable invalidEmailData) {
//        // getting the first row data
//        ReusableMethods.waitFor(2);
//        us_007_page.emailBoxClick.clear();
//        ReusableMethods.waitFor(2);
//
//        List<String> invalidEmail1= invalidEmailData.row(0);
//        us_007_page.emailBoxClick.sendKeys(invalidEmail1.get(0));
//        ReusableMethods.waitFor(2);
//
//
//        List<String> invalidEmail2= invalidEmailData.row(1);
//        us_007_page.emailBoxClick.sendKeys(invalidEmail2.get(1));
//        ReusableMethods.waitFor(2);
//
//
//
// }

//}


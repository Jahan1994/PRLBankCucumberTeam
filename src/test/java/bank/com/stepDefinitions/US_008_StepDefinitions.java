package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.US_008_PasswordPage;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US_008_StepDefinitions {

    HomePage homePage =new HomePage();
    LoginPage loginPage =new LoginPage();
    US_008_PasswordPage us_008_password_homePage=new US_008_PasswordPage();

    @Given("User go to Url {string}")
    public void user_go_to_url(String pageUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(pageUrl));

    }

    @Given("User click menuIcon")
    public void user_click_menu_icon() {
        homePage.iconMenu.click();

    }

    @Then("User click signInButton")
    public void user_click_sign_in_button() { homePage.signInButton.click();

    }

    @Then("User enter a valid Username")
    public void user_enter_a_valid_username() {
        loginPage.loginPageUsernameTextBox.sendKeys(ConfigReader.getProperty("bekir_current_username"));
        ReusableMethods.waitFor(2);
    }

    @Then("User enter a valid Password")
    public void user_enter_a_valid_password() throws InterruptedException {
        loginPage.loginPagePasswordTextBox.click();
        loginPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
        Thread.sleep(2000);
    }

    @Then("User click sign in button")
    public void userClickSignInButton() {
        // loginPage.loginPageCancelButton.click();
        // loginPage.loginPageSignInButton.click();
        loginPage.secondSignInButton.click();
        ReusableMethods.waitFor(2);
    }

    @Then("User click user menu icon")
    public void userClickUserMenuIcon() {
        us_008_password_homePage.signInIcon.click();
        ReusableMethods.waitFor(2);
    }

    @Then("User click password icon")
    public void userClickPasswordIcon()  {
        us_008_password_homePage.passwordIcon.click();
        ReusableMethods.waitFor(2);
    }

    @Then("User enter current password")
    public void userEnterCurrentPassword() {
//        loginPage.loginPagePasswordTextBox.click();
//        loginPage.loginPagePasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
//        ReusableMethods.waitFor(2);
//
//        loginPage.secondSignInButton.click();
//




        us_008_password_homePage.currentPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
        ReusableMethods.waitFor(2);
    }

    @Then("User enter old password as a new password")
    public void userEnterOldPassword() {

        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_old_password"));
        us_008_password_homePage.confirmPasswordTextBox.click();
        ReusableMethods.waitFor(2);
    }

    @Then("User enter new old password for confirmation")
    public void userClickNewPasswordConfirmation() {
        us_008_password_homePage.confirmPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_old_password"));
        ReusableMethods.waitFor(2);
    }

    @Then("User click save button for password")
    public void userClickSaveButton() {
        us_008_password_homePage.saveButton.click();
        ReusableMethods.waitFor(2);
    }


    @Then("User verifies the not saved message")
    public void userVerifiesTheUnsavedMessage() {

//        String pageMessage= Driver.getDriver().getPageSource();
//        System.out.println(pageMessage);

        Assert.assertTrue(us_008_password_homePage.passwordChangedText.isDisplayed());
        System.out.println("'Password change' the password has been changed to using the old password, This is a defect");
        ReusableMethods.waitFor(2);


        us_008_password_homePage.currentPasswordTextBox.clear();
        us_008_password_homePage.currentPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_old_password"));
        ReusableMethods.waitFor(2);
        us_008_password_homePage.newPasswordTextBox.clear();
        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
        ReusableMethods.waitFor(2);
        us_008_password_homePage.confirmPasswordTextBox.clear();
        us_008_password_homePage.confirmPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
        ReusableMethods.waitFor(2);
        us_008_password_homePage.saveButton.click();
        System.out.println("if this method works, there is a defect here!!!");
    }



    @Given("User enter new password at least one lower_case")
    public void userEnterNewPasswordAtLeastOneLower_case() {

        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("lower_case"));
        ReusableMethods.waitFor(2);

    }

    @Then("User sees and verifies the change the level bar accordigly red")
    public void userSeesTheChangeTheLevelBarAccordiglyRed() {

        Assert.assertTrue(us_008_password_homePage.red.isDisplayed());
        System.out.println("if level bar eaquals to RED, password is too weak!!!");
    }


    @Given("User enter new password at least one upper_case")
    public void userEnterNewPasswordAtLeastOneUpper_case() {
        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("upper_case"));
        ReusableMethods.waitFor(2);
    }

    @Then("User sees and verifies the change the level bar accordigly orange")
    public void userSeesTheChangeTheLevelBarAccordiglyOrange() {

        Assert.assertTrue(us_008_password_homePage.orange.isDisplayed());
        System.out.println("if level bar eaquals to ORANGE, password is weak!");
    }


    @Given("User enter new password at least one digit")
    public void userEnterNewPasswordAtLeastOneDigit() {

        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("digit_case"));
        ReusableMethods.waitFor(2);

    }

    @Then("User sees and verifies the change the level bar accordigly yellow")
    public void userSeesAndVerifiesTheChangeTheLevelBarAccordiglyYellow() {
//
//        try {
//            Assert.assertFalse(us_008_password_homePage.yellow.isDisplayed());
//        }catch (NoSuchElementException e){
//            Assert.assertTrue(false);
//        }



    }

    @Given("User enter new password at least one special char")
    public void userEnterNewPasswordAtLeastOneSpecialChar() {

        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("special_char"));
        ReusableMethods.waitFor(2);

    }

    @Then("User sees and verifies the change the level bar accordigly lime")
    public void userSeesAndVerifiesTheChangeTheLevelBarAccordiglyLime() {

        Assert.assertTrue(us_008_password_homePage.lightgreen.isDisplayed());

    }

    @Given("User enter new password at least seven char")
    public void userEnterNewPasswordAtLeastSevenChar() {

        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("power_pass"));

        ReusableMethods.waitFor(2);
    }

    @Then("User sees and verifies the change the level bar accordigly green")
    public void userSeesAndVerifiesTheChangeTheLevelBarAccordiglyGreen() {

        Assert.assertTrue(us_008_password_homePage.green.isDisplayed());
        ReusableMethods.waitFor(2);
        System.out.println("new password is STRONG!!!");
    }


    @Given("User enter new password to change")
    public void userEnterNewPasswordToChange() {

        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_new_password"));
        ReusableMethods.waitFor(2);
    }


    @Then("User enter new password confirmation")
    public void userEnterNewPasswordConfirmation() {

        us_008_password_homePage.confirmPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_new_password"));
        ReusableMethods.waitFor(2);
    }

    @Then("User sees and verifies the password has changed")
    public void userSeesAndVerifiesThePasswordHasChanged() {

//        String pageMessage= Driver.getDriver().getPageSource();
//        System.out.println(pageMessage);

        Assert.assertTrue(us_008_password_homePage.passwordChangedText.isDisplayed());
        System.out.println("user see new password confirmation message");

        us_008_password_homePage.currentPasswordTextBox.clear();
        us_008_password_homePage.currentPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_new_password"));
        ReusableMethods.waitFor(1);
        us_008_password_homePage.newPasswordTextBox.clear();
        us_008_password_homePage.newPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
        ReusableMethods.waitFor(2);
        us_008_password_homePage.confirmPasswordTextBox.clear();
        us_008_password_homePage.confirmPasswordTextBox.sendKeys(ConfigReader.getProperty("bekir_current_password"));
        ReusableMethods.waitFor(1);
        us_008_password_homePage.saveButton.click();


    }


    @Then("user closes the page")
    public void userClosesThePage() {
        Driver.closeDriver();
    }



}
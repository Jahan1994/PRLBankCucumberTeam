package bank.com.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.US_005_InValidCredentials_Page;

import java.util.List;

public class US_005_InValidCredentials_StepDefinitions {

    HomePage homepage = new HomePage();
    LoginPage pagelogin = new LoginPage();
    US_005_InValidCredentials_Page pageus5 = new US_005_InValidCredentials_Page();

    @Then("User click menu icon")
    public void user_click_menu_icon() {
        homepage.iconMenu.click();
    }

    @Then("User click signIn Option")
    public void user_click_sign_in_option() throws InterruptedException {
        homepage.signInButton.click();
        Thread.sleep(1000);
    }
    @Then("user provides username {string}")
    public void userProvidesUsername(String userName)  throws InterruptedException{
        pagelogin.loginPageUsernameTextBox.sendKeys(userName);
        Thread.sleep(2000);
    }

    @Then("user provides password {string}")
    public void userProvidesPassword(String passWord) {
        pagelogin.loginPagePasswordTextBox.sendKeys(passWord);
    }

    @Then("user provides username and password")
    public void userProvidesUsernameAndPassword(DataTable dataTable) throws InterruptedException {
        List<String> datalar= dataTable.row(1);
        System.out.println(datalar.get(0)); //xxxxxx
        pagelogin.loginPageUsernameTextBox.sendKeys(datalar.get(0));
        pagelogin.loginPagePasswordTextBox.sendKeys(datalar.get(1));
        Thread.sleep(3000);

    }
    @Then("User click secondSignInButton")
    public void user_click_second_sign_in_button() throws InterruptedException {
        pageus5.secondSignInButton.click();
        Thread.sleep(2000);
    }

    @Then("User see Failed Message")
    public void user_see_failed_message() throws InterruptedException {
        String actualResult = pageus5.failedMessage.getText();
        System.out.println(actualResult); //Failed to sign in!
        String expectedResult = "Failed to sign in! Please check your credentials and try again.";
        Assert.assertTrue(expectedResult.contains(actualResult));
        Thread.sleep(5000);
    }
    @Then("User click Did you forget your password ?")
    public void user_click_did_you_forget_your_password() throws InterruptedException {
        pageus5.forgetPasswordLink.click();
        Thread.sleep(2000);
    }
    @Then("Enter email that suscribed")
    public void enter_email_that_suscribed() throws InterruptedException {
        pageus5.resetPasswordEmail.sendKeys("user53@gmail.com");
        Thread.sleep(2000);
    }
    @Then("User click Reset password")
    public void user_click_reset_password() throws InterruptedException {
        pageus5.resetPasswordButton.click();
        Thread.sleep(2000);
    }
    @Then("User click register option if they do not yet registered \\(Register a new account)")
    public void user_click_register_option_if_they_do_not_yet_registered_register_a_new_account() throws InterruptedException {
        pageus5.registerNewAccountLink.click();
        Thread.sleep(2000);
    }
    @Then("User see registration page")
    public void user_see_registration_page() {
        String actualResult=pageus5.registrationPage.getText();
        String expectedResult="Registration";
        Assert.assertEquals(expectedResult, actualResult);

    }



}

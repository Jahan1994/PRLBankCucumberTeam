package bank.com.stepDefinitions;

import bank.com.pages.RegistrationPage;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import bank.com.pages.RegistrationPage;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;

public class US_001_Registration_StepDefinitions {

    RegistrationPage registerPage=new RegistrationPage();
    Faker faker= new Faker();



    @Given("User on the home page {string}")
    public void userOnTheHomePage(String bankurl) {
        Driver.getDriver().get(ConfigReader.getProperty(bankurl));
    }

    @Then("User clicks menu icon")
    public void userClicksMenuIcon() {
        registerPage.iconMenu.click();
    }

    @And("User clicks register button")
    public void userClicksRegisterButton() {
        registerPage.registerButton.click();
    }

    @Then("User provides a valid ssn {string}")
    public void userProvidesAValidSsn(String ssn) {
        String ssn1=faker.idNumber().ssnValid();
        System.out.println(ssn1);
        registerPage.ssnTextBox.sendKeys(ssn1);

    }

    @Then("User provides a valid firstname {string}")
    public void userProvidesAValidFirstname(String firstname) {
        registerPage.firstNameTextBox.sendKeys(firstname);

    }

    @Then("User provides a valid lastname {string}")
    public void userProvidesAValidLastname(String lastname) {
        registerPage.lastNameTextBox.sendKeys(lastname);
    }

    @Then("User provides a valid address {string}")
    public void userProvidesAValidAddress(String address) {
        registerPage.addressTextBox.sendKeys(address);
    }

    @Then("User provides a valid Mobile Phone Number {string}")
    public void userProvidesAValidMobilePhoneNumber(String mobilePhoneNumber){
        registerPage.mobilePhoneNumberTextBox.sendKeys(mobilePhoneNumber);
    }

    @Then("User provides a valid Username {string}")
    public void userProvidesAValidUsername(String userName) {
        registerPage.usernameTextBox.sendKeys(userName);
    }

    @Then("User provides a valid Email {string}")
    public void userProvidesAValidEmail(String email) {
        registerPage.emailTextBox.sendKeys(email);
    }

    @Then("User provides a valid Password {string}")
    public void userProvidesAValidPassword(String validPassword) {
        registerPage.firstPasswordTextBox.sendKeys(validPassword);
    }

    @Then("User controls stronger Password {string}")
    public void userControlsStrongerPassword(String strongPassword) {
        Assert.assertTrue(registerPage.passwordStrenght.isEnabled());

    }

    @Then("User provides a valid Password to Password confirmation textbox {string}")
    public void userProvidesAValidPasswordToPasswordConfirmationTextbox(String passwordConfirmation) {
        registerPage.secondPasswordTextBox.sendKeys(passwordConfirmation);
    }

    @Then("User clicks on Register button")
    public void userClicksOnRegisterButton() {
        registerPage.registersubmitTextBox.click();
    }

    @And("User validates that the registered succesfully")
    public void userValidatesThatTheRegisteredSuccesfully(){

        ReusableMethods.waitForVisibility(registerPage.successfulRegisterMessage, 5);
    }


    @Then("User clicks Sign in button")
    public void userClicksSignInButton() {
        registerPage.signInButton.click();
    }

    @Then("User provides a valid username")
    public void userProvidesAValidUsername() {
        registerPage.userName.sendKeys(ConfigReader.getProperty("Fernando"));
    }

    @Then("User provides a valid passWord")
    public void userProvidesAValidPassWord() {
        registerPage.passWord.sendKeys(ConfigReader.getProperty("user_password"));
    }

    @Then("User clicks Sign in")
    public void userClicksSignIn() {
        registerPage.signIn.click();
    }

    @Then("User asserts new page")
    public void userAssertsNewPage() {
        Assert.assertTrue(registerPage.logIn.isDisplayed());
    }
}

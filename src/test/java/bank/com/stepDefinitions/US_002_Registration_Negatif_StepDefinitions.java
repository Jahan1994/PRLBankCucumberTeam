package bank.com.stepDefinitions;

import bank.com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import bank.com.pages.RegistrationPage;
import bank.com.utilities.ConfigReader;

public class US_002_Registration_Negatif_StepDefinitions {

    RegistrationPage registrationPage= new RegistrationPage();

    @Then("User provides a invalid SSN as {string} and validates invalid ssn with a fail message as {string} or {string}")
    public void userProvidesAInvalidSSNAsAndValidatesInvalidSsnWithAFailMessageAsOr(String ssn, String failSsnMessage1, String failSsnMessage2) {
        registrationPage.ssnTextBox.sendKeys(ssn + Keys.ENTER);
        String actualFailSSNmessage = registrationPage.invalidSsnFeedbackText.getText();
        Assert.assertTrue(actualFailSSNmessage.contains(failSsnMessage1) || actualFailSSNmessage.contains(failSsnMessage2) );
    }

    @Then("User provides a invalid SSN as {string}")
    public void userProvidesAInvalidSSNAs(String ssn) {
           registrationPage.ssnTextBox.sendKeys(ssn + Keys.ENTER);

    }
    @And("User validates that he provides an invalid ssn with a fail message as {string} or {string}")
    public void userValidatesThatHeProvidesAnInvalidSsnWithAFailMessageAsOr(String failSsnMessage1, String failSsnMessage2) {
        String actualFailSSNmessage = registrationPage.invalidSsnFeedbackText.getText();
        Assert.assertTrue(actualFailSSNmessage.contains(failSsnMessage1) || actualFailSSNmessage.contains(failSsnMessage2) );
    }

    @Then("User provides a invalid Firstname as {string}")
    public void userProvidesAInvalidFirstnameAs(String firstname) {
        registrationPage.firstNameTextBox.sendKeys(firstname);
    }

    @Then("User provides a invalid Lastname as {string}")
    public void userProvidesAInvalidLastnameAs(String lastname) {
        registrationPage.lastNameTextBox.sendKeys(lastname);
    }

    @Then("User provides a invalid Address as {string}")
    public void userProvidesAInvalidAddressAs(String address) {
        registrationPage.addressTextBox.sendKeys(address);
    }

    @Then("User provides a invalid Mobile Phone Number as {string}")
    public void userProvidesAInvalidMobilePhoneNumberAs(String mobilephonenumber) {
        registrationPage.mobilePhoneNumberTextBox.sendKeys(mobilephonenumber);
    }

    @Given("User provides a invalid Mobile Phone Number as {string} and validates invalid mobilephone with a fail message as {string} or {string}")
    public void userProvidesAInvalidMobilePhoneNumberAsAndValidatesInvalidMobilephoneWithAFailMessageAsOr(String mobilephonenumber, String failMobileMessage1, String failMobileMessage2) {
        registrationPage.mobilePhoneNumberTextBox.sendKeys(mobilephonenumber + Keys.ENTER);
        String actualFailMobilemessage = registrationPage.invalidMobilePhoneNumberfeedbackText.getText();
        Assert.assertTrue(actualFailMobilemessage.contains(failMobileMessage1) || actualFailMobilemessage.contains(failMobileMessage2));
    }

    @Then("User provides a invalid  Username as {string}")
    public void userProvidesAInvalidUsernameAs(String username) {
        registrationPage.usernameTextBox.sendKeys(username);
    }

    @Then("User provides a invalid  Email as {string}")
    public void userProvidesAInvalidEmailAs(String email) {
        registrationPage.emailTextBox.sendKeys(email);
    }


    @Given("User provides a invalid Email as {string} and validates invalid mobilephone with a fail message as {string} or {string} or {string}")
    public void userProvidesAInvalidEmailAsAndValidatesInvalidMobilephoneWithAFailMessageAsOrOr(String email, String failEmailMessage1, String failEmailMessage2, String failEmailMessage3) throws InterruptedException {
        Thread.sleep(3);
        registrationPage.emailTextBox.sendKeys(Keys.PAGE_DOWN+ email + Keys.ENTER);
          Driver.waitAndGetText(registrationPage.invalidEmailFeedbackText, 10);
        String actualFailEmailmessage = registrationPage.invalidEmailFeedbackText.getText();
        System.out.println(actualFailEmailmessage);
        Assert.assertTrue(
                actualFailEmailmessage.contains(failEmailMessage1) ||
                        actualFailEmailmessage.contains(failEmailMessage2) ||
                        actualFailEmailmessage.contains(failEmailMessage3));

//        Assert.assertEquals(actualFailEmailmessage,failEmailMessage1);
//        Assert.assertEquals(actualFailEmailmessage,failEmailMessage2);
//        Assert.assertEquals(actualFailEmailmessage,failEmailMessage3);

    }

    @Then("User provides a invalid Password as {string}")
    public void userProvidesAInvalidPasswordAs(String password) {
        registrationPage.firstPasswordTextBox.sendKeys(password);
    }

    @Then("User provides a invalid  Password to Password confirmation textbox as {string}")
    public void userProvidesAInvalidPasswordToPasswordConfirmationTextboxAs(String confirmpassword) {
        registrationPage.secondPasswordTextBox.sendKeys(confirmpassword);
    }

    @And("User validates that he registered succesfully with a success message as {string}")
    public void userValidatesThatHeRegisteredSuccesfullyWithASuccessMessageAs(String succesMesssage) {
        String expectedFailedMessage = registrationPage.wrongSuccesRegisterMessage.getText();
        System.out.println(expectedFailedMessage);
        String actualFailedMessage= ConfigReader.getProperty("registration_failed_message");
        // Assert.assertEquals(expectedSuccesMessage,actualSuccessMessage);
        Assert.assertTrue(expectedFailedMessage.contains(actualFailedMessage));

    }


}

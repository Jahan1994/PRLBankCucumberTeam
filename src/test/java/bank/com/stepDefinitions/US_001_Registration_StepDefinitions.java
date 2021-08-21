package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class US_001_Registration_StepDefinitions {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage= new RegistrationPage();

    @And("User navigates to registration page")
    public void userNavigatesToRegistrationPage() {
        homePage.homePageRegister.click();
    }
    @Then("User provides a valid SSN")
    public void userProvidesAValidSSN() {
    }

    @Then("User provides a valid Firstname")
    public void userProvidesAValidFirstname() {
    }

    @Then("User provides a valid Lastname")
    public void userProvidesAValidLastname() {
    }

    @Then("User provides a valid Address")
    public void userProvidesAValidAddress() {
    }

    @Then("User provides a valid Mobile Phone Number")
    public void userProvidesAValidMobilePhoneNumber() {
    }

    @Then("User provides a valid Username")
    public void userProvidesAValidUsername() {
    }

    @Then("User provides a valid Email")
    public void userProvidesAValidEmail() {
    }

    @Then("User provides a valid Password")
    public void userProvidesAValidPassword() {
    }

    @Then("User provides a valid Password to Password confirmation textbox")
    public void userProvidesAValidPasswordToPasswordConfirmationTextbox() {
    }

    @Then("User clicks on Register button")
    public void userClicksOnRegisterButton() {
    }

    @And("User validates that he registered succesfully")
    public void userValidatesThatHeRegisteredSuccesfully() {
    }
}

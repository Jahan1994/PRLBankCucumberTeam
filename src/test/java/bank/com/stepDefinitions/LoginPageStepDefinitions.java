package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.RegistrationPage;
import bank.com.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginPageStepDefinitions {

  RegistrationPage registrationPage = new RegistrationPage();

  HomePage homePage =new HomePage();
  LoginPage loginPage =new LoginPage();

  //Ahmet bu metodu Feature sayfasinda sen yazinca ben kendi feature sayfamdan silecem. Bunu simdilik olusturdum
  @And("User navigates to Login page")
  public void userNavigatesToLoginPage() {
    homePage.homePageSignIn.click();

  }
  @Then("User clicks Sign in button")
  public void userClicksSignInButton() {
    registrationPage.signInButton.click();
  }

  @Then("User provides a valid username for pozitive login")
  public void userProvidesAValidUsernameForPozitiveLogin() {
    registrationPage.usernameTextBox.sendKeys(ConfigReader.getProperty("user_usernamee"));
  }

  @Then("User provides a valid passWord for pozitive login")
  public void userProvidesAValidPassWordForPozitiveLogin() {
    registrationPage.passWord.sendKeys(ConfigReader.getProperty("user_passwordd"));
  }


  @Then("User clicks Sign in")
  public void userClicksSignIn() {
    registrationPage.signIn.click();

  }


  @Then("User asserts new page")
  public void userAssertsNewPage() {
    Assert.assertTrue(registrationPage.myOperations.isDisplayed());
  }

  @Then("User asserts cancel button")
  public void userAssertsCancelButton() {
    Assert.assertTrue(registrationPage.cancelButton.isDisplayed());
  }
}

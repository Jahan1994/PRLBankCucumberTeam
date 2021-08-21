package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import io.cucumber.java.en.And;

public class LoginPageStepDefinitions {

  HomePage homePage =new HomePage();
  LoginPage loginPage =new LoginPage();

  //Ahmet bu metodu Feature sayfasinda sen yazinca ben kendi feature sayfamdan silecem. Bunu simdilik olusturdum
  @And("User navigates to Login page")
  public void userNavigatesToLoginPage() {

    homePage.homePageSignIn.click();
  }


  //AHMET abi buraya sen login metodlarini yazarsin. ben homepage click yapip LoginPage sayfaya geldim

}

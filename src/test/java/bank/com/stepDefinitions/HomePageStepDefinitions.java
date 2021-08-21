package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDefinitions {

    HomePage homePage = new HomePage();

    @Given("User on the home page {string}")
    public void userOnTheHomePage(String pageUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(pageUrl));
    }

    @Then("User clicks menu icon")
    public void user_clicks_menu_icon() {

        homePage.iconMenu.click();
    }

}

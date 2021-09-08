package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.utilities.ConfigurationReader;
import bank.com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageStepDefinitions {

    HomePage homePage = new HomePage();

    @Given("User on the home page {string}")
    public void userOnTheHomePage(String pageUrl) {

        Driver.getDriver().get(ConfigurationReader.getProperty(pageUrl));
    }

    @Then("User clicks menu icon")
    public void user_clicks_menu_icon() {

        homePage.iconMenu.click();
    }

}

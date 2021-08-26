package bank.com.stepDefinitions;

import bank.com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.US_006_UserSettings_Page;
import bank.com.utilities.Driver;

import java.util.List;


public class US_006_UserSettings_StepDefinitions {


    HomePage homepage = new HomePage();
    LoginPage pagelogin = new LoginPage();
    US_006_UserSettings_Page pageus6 = new US_006_UserSettings_Page();
    Faker faker=new Faker();

    @Then("User click userIcon")
    public void user_click_user_icon() throws InterruptedException {
        pageus6.clickUserIcon.click();
        Thread.sleep(1000);
    }
    @Then("User select User Info")
    public void userSelectUserInfo() throws InterruptedException {
        pageus6.userInfoClick.click();
        ReusableMethods.waitFor(2);
    }
    @Then("User can see own info")
    public void userCanSeeOwnInfo() throws InterruptedException {
        String userSettingsTitle = pageus6.userSettingsFor.getText();
        System.out.println(userSettingsTitle);
        ReusableMethods.waitFor(2);
    }
    @Then("User is on the user settings page")
    public void user_is_on_the_user_settings_page() throws InterruptedException {
        String expectedTitle ="https://gmibank-qa-environment.com/account/settings";
        String actualTitle = Driver.getDriver().getTitle();
        ReusableMethods.waitFor(2);
       // Assert.assertEquals( expectedTitle, actualTitle);
        Thread.sleep(2000);
    }

    @Then("User can see two language option on the language dropdownmenu")
    public void user_can_see_two_language_option_on_the_language_dropdownmenu() throws InterruptedException {
        Select select = new Select(pageus6.languageSelect);
        pageus6.languageSelect.click();
        List<WebElement> languageOptions;
        languageOptions = select.getOptions();
        System.out.println("Language Option1 : " + languageOptions.get(0).getText());
        System.out.println("Language Option2 : " + languageOptions.get(1).getText());

        for (WebElement each : languageOptions) {
            boolean languages = each.getText().equals("Türkçe") || each.getText().equals("English");
            Assert.assertTrue("user can only select English or Turkish", languages);
        }
        Thread.sleep(1000);

    }

   @Then("User can update firstname")
    public void user_can_update_firstname() throws InterruptedException {
        pageus6.firstNameBoxClick.clear();
        String firstnamefaker = faker.name().firstName();
       System.out.println("updatefirstnamefaker = " + firstnamefaker); //updatefirstnamefaker = Vena
        pageus6.firstNameBoxClick.sendKeys(firstnamefaker);
        Thread.sleep(1000);

    }

    @Then("User can update lastname")
    public void user_can_update_lastname() throws InterruptedException {
        pageus6.lastNameBoxClick.clear();
        String lastnamefaker =faker.name().lastName();
        System.out.println("updatelastnamefaker = " + lastnamefaker); //updatelastnamefaker =  O'Hara
        pageus6.lastNameBoxClick.sendKeys(lastnamefaker);
        Thread.sleep(1000);

    }

    @Then("User can update email")
    public void user_can_update_email() throws InterruptedException {
        pageus6.emailBoxClick.clear();
        String emailfaker = faker.internet().emailAddress();
        System.out.println("updateemailfaker = " + emailfaker); //updateemailfaker = raphael.botsford@gmail.com
        pageus6.emailBoxClick.sendKeys(emailfaker);
        Thread.sleep(1000);

    }

    @Then("User click save button")
    public void user_click_save_button() throws InterruptedException  {
        pageus6.saveButtonClick.click();
        Thread.sleep(1000);
        String expectedmessage ="Settings saved!";
        String actualmessage = pageus6.settingsSaveMessage.getText();
        Assert.assertEquals(actualmessage, expectedmessage);
        //yukardaki 3 satir yerine
        pageus6.settingsSaveMessage.isDisplayed();

    }

}

package bank.com.stepDefinitions;

import bank.com.utilities.ConfigReader;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class US_010_011_StepDefinition {

    bank.com.pages.US_009Page us_009Page=new bank.com.pages.US_009Page();
Actions action =new Actions(Driver.getDriver());
   // JavascriptExecutor js = ((JavascriptExecutor) driver);
    @And("User enter MI {string}")
    public void userEnterMI(String mid) {
us_009Page.middle.sendKeys(ConfigReader.getProperty(mid));
        ReusableMethods.waitFor(5);

    }

    @And("User enter MP {string}")
    public void userEnterMP(String mob) {
       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
action.moveToElement(us_009Page.mobile).perform();
        us_009Page.mobile.sendKeys(ConfigReader.getProperty(mob));
ReusableMethods.waitFor(5);
    }

    @And("User enter PH {string}")
    public void userEnterPH(String ph) {
        action.moveToElement(us_009Page.phone).perform();
us_009Page.phone.sendKeys(ConfigReader.getProperty(ph));
ReusableMethods.waitFor(5);
    }
    @And("User enter ZC {string}")
    public void userEnterZC(String zip) {
        action.moveToElement(us_009Page.zipcode).perform();
us_009Page.zipcode.sendKeys(ConfigReader.getProperty(zip));
ReusableMethods.waitFor(5);
    }

    @And("User enter  Adress {string}")
    public void userEnterAdress(String adr) {
        action.moveToElement(us_009Page.adress).perform();
us_009Page.adress.sendKeys(ConfigReader.getProperty(adr));
ReusableMethods.waitFor(5);
    }

    @And("User enter City {string}")
    public void userEnterCity(String city) {
        action.moveToElement(us_009Page.city).perform();
us_009Page.city.sendKeys(ConfigReader.getProperty(city));
ReusableMethods.waitFor(5);
    }

    @And("User enter Country {string}")
    public void userEnterCountry(String country) {
        action.moveToElement(us_009Page.dropdown).perform();
        Select select=new Select(us_009Page.dropdown);
     select.selectByVisibleText("Azerbaijan");
ReusableMethods.waitFor(5);
    }

    @And("User enter State{string}")
    public void userEnterState(String state) {
        action.moveToElement(us_009Page.state).perform();
us_009Page.state.sendKeys(ConfigReader.getProperty(state));
ReusableMethods.waitFor(5);

    }
}

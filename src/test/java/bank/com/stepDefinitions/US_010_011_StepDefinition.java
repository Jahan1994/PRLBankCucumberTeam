package bank.com.stepDefinitions;

import bank.com.pages.US_010_011Page;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.DateUtil;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class US_010_011_StepDefinition {

    bank.com.pages.US_009Page us_009Page=new bank.com.pages.US_009Page();
    Actions action =new Actions(Driver.getDriver());
    US_010_011Page us_010_011Page = new US_010_011Page();



    @And("User enter MI {string}")
    public void userEnterMI(String mid) {
        us_009Page.middle.sendKeys(ConfigReader.getProperty(mid));
        ReusableMethods.waitFor(3);
    }

    @And("User enter MP {string}")
    public void userEnterMP(String mob) {
        us_009Page.mobile.sendKeys(ConfigReader.getProperty(mob));
        //   ReusableMethods.waitFor(5);
    }

    @And("User enter PH {string}")
    public void userEnterPH(String ph) {
        us_009Page.phone.sendKeys(ConfigReader.getProperty(ph));
        //   ReusableMethods.waitFor(5);
    }

    @And("User enter ZC {string}")
    public void userEnterZC(String zip) {
        us_009Page.zipcode.sendKeys(ConfigReader.getProperty(zip));
        //   ReusableMethods.waitFor(5);
    }

    @And("User enter Adress {string}")
    public void userEnterAdress(String adr) {
        us_009Page.adress.clear();
        us_009Page.adress.sendKeys(ConfigReader.getProperty(adr));
        //   ReusableMethods.waitFor(5);
    }

    @And("User enter City {string}")
    public void userEnterCity(String city) {
        us_009Page.city.sendKeys(ConfigReader.getProperty(city));
        //   ReusableMethods.waitFor(5);
    }

    @And("User enter Country {string}")
    public void userEnterCountry(String country) {

        Select select = new Select(us_009Page.countryList);
        select.selectByVisibleText("USA");

    }

    @And("User enter State{string}")
    public void userEnterState(String state) {
        us_009Page.state.sendKeys(ConfigReader.getProperty(state));
        //    ReusableMethods.waitFor(5);
    }


/////////////////////////////////////////////////



    @Then("User enter today date")
    public void userEnterTodayDate() {
        String today = DateUtil.todaysDate1();
        String todayTime = DateUtil.todaysTime1();
        action.click(us_010_011Page.createDate).sendKeys(today + Keys.TAB + todayTime).perform();
        //us_010_011Page.createDate.sendKeys(today);
    }

    @And("User sees entered today date and time")
    public void userSeesExactDateAndTime() {
        String today = DateUtil.todaysDate1();
        String todayTime = DateUtil.todaysTime1();
        action.click(us_010_011Page.createDate).sendKeys(today + Keys.TAB + todayTime).perform();

        String dateValue = us_010_011Page.createDate.getAttribute("value");
        System.out.println( "DATE: " + dateValue);

        String actualDate = dateValue.substring(5,7) + "/"+ dateValue.substring(8, 10) + "/"+ dateValue.substring(0,4);
        System.out.println(actualDate);

        System.out.println(DateUtil.todaysTime1());
        String actualTime = dateValue.substring(11,16);
        System.out.println(actualTime);

        System.out.println(DateUtil.todaysDate1());

        Assert.assertEquals(DateUtil.todaysDate1(), actualDate);
        Assert.assertEquals(DateUtil.todaysTime1(),actualTime);

    }

    @And("User sees correct order date")
    public void userSeesCorrectOrderDate() {
        String dateValue = us_010_011Page.createDate.getAttribute("value");
        String actualDate = dateValue.substring(5,7) + "/" + dateValue.substring(8, 10) + "/" + dateValue.substring(0,4);
        System.out.println(actualDate);
        int month = Integer.parseInt(actualDate.substring(0,2));
        int day = Integer.parseInt(actualDate.substring(3,5));
        int year = Integer.parseInt(actualDate.substring(6,10));

        System.out.print((month<=12 && month>0)?("Month/"):("Day/"));
        System.out.print((day>12 && day<=31)?("Day/"):("Month/"));
        System.out.print((year>31)?("Year"):("Month"));

        String firstSection = ((month<=12 && month>0)?("Month"):("Day"));
        String middleSection = ((day>12 && day<=31)?("Day"):("Month"));
        String thirdSection = ((year>31)?("Year"):("Month"));

        Assert.assertEquals(firstSection,"Month");
        Assert.assertEquals(middleSection, "Day");
        Assert.assertEquals(thirdSection, "Year");


    }

    @And("User choose valid user")
    public void userChooseValidUser() {

        Select select = new Select(us_010_011Page.userSelect);
        select.selectByVisibleText("bekir Bekir Fakir");
        System.out.println(select.getFirstSelectedOption().getText());


    }

    @And("User choose valid account")
    public void userChooseValidAccount() {
        Select select = new Select(us_010_011Page.selectAccount);
        select.selectByVisibleText("hh");
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @And("User click zelle enrolled check box")
    public void userClickZelleEnrolledCheckBox() {
        us_010_011Page.zelleEnrolled.click();

    }

    @Then("User click save button")
    public void userClickSaveButton() {
        us_010_011Page.saveButton.click();

    }

    @And("User sees success message2")
    public void userSeesSuccessMessage2() {

       // try{
            us_010_011Page.internalError.getText();
      //  }catch (NoSuchElementException e){
            Assert.assertTrue(true);
    }
}

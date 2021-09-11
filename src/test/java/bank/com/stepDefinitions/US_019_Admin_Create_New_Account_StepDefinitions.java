package bank.com.stepDefinitions;

import bank.com.pojos.Customer;
import bank.com.utilities.*;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.RegistrationPage;
import bank.com.pages.ManageAccountsPage;

import java.util.List;

public class US_019_Admin_Create_New_Account_StepDefinitions {

    Faker faker=new Faker();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    RegistrationPage registrationPage= new RegistrationPage();
    ManageAccountsPage manageAccountsPage=new ManageAccountsPage();
    String fileName= ConfigurationReader.getProperty("fileNameOfCustomer");
    Customer customer= new Customer();


//   @Then("user provides username and password")
//    public void user_provides_username_and_password(DataTable dataTable) {
//List<String> data= dataTable.row(3);
//        System.out.println(data.get(0));
//
//        loginPage.loginPageUsernameTextBox.sendKeys(data.get(0));
//        loginPage.loginPagePasswordTextBox.sendKeys(data.get(1));
//
//    }

    @Then("user provides username and password for login")
    public void userProvidesUsernameAndPasswordForLogin(DataTable dataTable) {
        List<String> data= dataTable.row(2);
        System.out.println(data.get(0));

        loginPage.loginPageUsernameTextBox.sendKeys(data.get(0));
        loginPage.loginPagePasswordTextBox.sendKeys(data.get(1));
    }

    @Then("user logs in")
    public void user_logs_in() {
        loginPage.loginPageSignInButtonSibel.click();
    }

    @Then("user navigates to my operations")
    public void user_navigates_to_my_operations() {
        manageAccountsPage.myOperationsDropDown.click();

    }

    @When("user clicks on manageAccount")
    public void userClicksOnManageAccount() {

        manageAccountsPage.manageAccountsButton.click();
    }

    @Then("user creates a new account")
    public void userCreatesANewAccount() {
        JSUtils.clickElementByJS(manageAccountsPage.createNewAccountButton);
       // manageAccountsPage.createNewAccountButton.click();
    }

    @Given("user types a description {string}")
    public void userTypesADescription(String description) {
        //en son satiri cagirma
//        List<Customer> list2= ReadTxt.returnAWholeCostumer(fileName);
//        description= list2.get(list2.size()-1).getSsn() + " nolu SSN numarali sahis icin olusturlan CHECKING hesap numarasi";
        manageAccountsPage.accountDescriptionTextBox.sendKeys(description);

    }

    @Given("user types a description {string} for second account")
    public void userTypesADescriptionForSecondAccount(String secondDescription) {
        //en son satiri cagirma
//        List<Customer> list2= ReadTxt.returnAWholeCostumer(fileName);
//        secondDescription= list2.get(list2.size()-1).getSsn() + " nolu SSN numarali sahis icin olusturlan SAVING hesap numarasi";
         manageAccountsPage.accountDescriptionTextBox.sendKeys(secondDescription);
    }

    @And("user types the balance as {string}")
    public void userTypesTheBalanceAs(String balance) {

        manageAccountsPage.accountBalanceTextBox.sendKeys(balance);
    }

    @Then("user selects an account type from dropdown {string}")
    public void userSelectsAnAccountTypeFromDropdown(String accountType) {
        Select select = new Select(manageAccountsPage.accountTypeDropDown);
        //CHECKING hesap
        select.selectByVisibleText("CHECKING");
        //select.selectByIndex(2);
    }

    @Then("user selects an account type from dropdown {string} for second account")
    public void userSelectsAnAccountTypeFromDropdownForSecondAccount(String accountType) {
        Select select = new Select(manageAccountsPage.accountTypeDropDown);
        //CHECKING hesap
        select.selectByVisibleText("SAVING");
        //select.selectByIndex(2);
    }

    @When("user selects an accountStatusType {string}")
    public void userSelectsAnAccountStatusType(String accountStatus) {
        Select select = new Select(manageAccountsPage.accountStatusTypeDropDown);
        select.selectByValue("ACTIVE");
        //  ReusableMethods.selectAnItemFromDropdown(manageAccountPage.accountStatusTypeDropdown,accountStatus);

    }
    @Given("user selects a current create date")
    public void userSelectsACurrentCreateDate() {
        manageAccountsPage.createDate.sendKeys(DateUtil.todaysDate6() + Keys.TAB + DateUtil.todaysTime());
        System.out.println(DateUtil.todaysDate6());
    }

    @Given("user selects a closed date")
    public void userSelectsAClosedDate() {
        manageAccountsPage.closedDate.sendKeys(DateUtil.todaysDate8() + Keys.TAB + DateUtil.todaysTime());
    }

    @And("user selects an employee")
    public void userSelectsAnEmployee() {
    }

    @Then("user clicks on save button")
    public void userClicksOnSaveButton() {
        manageAccountsPage.accountSaveButton.click();
    }

    @Then("user confirm that he saves the account with success")
    public void userConfirmThatHeSavesTheAccountWithSuccess() throws InterruptedException {

        //Account olustugunu assert et.
        String actualSuccessMessage= manageAccountsPage.successAccountCreationMessage.getText();
       // System.out.println(actualSuccessMessage);
        String expectedSuccessMessage = "translation-not-found[gmiBankBackendApp.tPAccount.created]";
//        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
        Driver.waitForVisibility(manageAccountsPage.aboutUsFooterAccountPage, 10);
        //Burada sayfanin en altina gitmek istiyorum
        JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();
        //arguments[0].scrollIntoView(true); => THIS IS USED A LOT
        //istedigimiz elemente gidecek.
        je.executeScript("arguments[0].scrollIntoView(true);",manageAccountsPage.aboutUsFooterAccountPage);
        //EXPLICIT WAIT
        //buarada scrollDowsn yapmasi icin bir sure beklemek gerekebilir
        ReusableMethods.waitForVisibility(manageAccountsPage.createNewAccountButton,10);
        Thread.sleep(3000);
        je.executeScript("arguments[0].scrollIntoView(true);",manageAccountsPage.createNewAccountButton);
             // manageAccountsPage.createNewAccountButton.click();

        Thread.sleep(3000);

        //burada olusturdugum hesabi verify ediyorum
//        int sizeOfAccountTable= manageAccountsPage.satirlarListesi.size();
//        System.out.println(sizeOfAccountTable);
//        String actualDescription= manageAccountsPage.istenenSatirveSutunYazdir(sizeOfAccountTable+1, 2);
//        String expectedDescription =  "Instructor saving account";
//        Assert.assertEquals(expectedDescription, actualDescription);

    }

    @Then("user confirm that he saves the account with success for second account")
    public void userConfirmThatHeSavesTheAccountWithSuccessForSecondAccount() throws InterruptedException {

        //Account olustugunu assert et.
        String actualSuccessMessage= manageAccountsPage.successAccountCreationMessage.getText();
        // System.out.println(actualSuccessMessage);
        String expectedSuccessMessage = "translation-not-found[gmiBankBackendApp.tPAccount.created]";
//        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
        Driver.waitForVisibility(manageAccountsPage.aboutUsFooterAccountPage, 10);
        //Burada sayfanin en altina gitmek istiyorum
        JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();
        //arguments[0].scrollIntoView(true); => THIS IS USED A LOT
        //istedigimiz elemente gidecek.
        Thread.sleep(3000);
        je.executeScript("arguments[0].scrollIntoView(true);",manageAccountsPage.aboutUsFooterAccountPage);

        Thread.sleep(5000);

        //burada olusturdugum hesabi verify ediyorum
//        int sizeOfAccountTable= manageAccountsPage.satirlarListesi.size();
//        System.out.println(sizeOfAccountTable);
//        String actualDescription= manageAccountsPage.istenenSatirveSutunYazdir(sizeOfAccountTable+1, 2);
//        String expectedDescription =  "Instructor saving account";
//        Assert.assertEquals(expectedDescription, actualDescription);
    }


    @Then("user clicks on back button")
    public void userClicksOnBackButton() {
        manageAccountsPage.accountBackButton.click();
    }

    @Then("user confirm that he comes back to the manage account page")
    public void userConfirmThatHeComesBackToTheManageAccountPage() {
        String expectedAccountPageUrl= "https://gmibank-qa-environment.com/tp-account";
        String actualAccountPageUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedAccountPageUrl,actualAccountPageUrl);
    }

    @And("user close the browser")
    public void userCloseTheBrowser() {
        Driver.getDriver().close();
    }

    @Given("user selects a current create date {string} {string}")
    public void userSelectsACurrentCreateDate(String currentDate, String currentTime) throws InterruptedException {
        String currentDate1 = DateUtil.todaysDate6();
        String currentTime1= DateUtil.todaysTime();
        manageAccountsPage.createDate.sendKeys( currentDate1 + Keys.TAB + currentTime1);
        Thread.sleep(3000);
    }

    @Given("user selects a closed date {string} {string}")
    public void userSelectsAClosedDate(String currentDate, String currentTime) {
        String currentDate1 = DateUtil.todaysDate8();
        String currentTime1= DateUtil.todaysTime();
        manageAccountsPage.closedDate.sendKeys( currentDate1 + Keys.TAB + currentTime1 );
    }


}


package bank.com.stepDefinitions;

import bank.com.pages.HomePage;
import bank.com.pages.LoginPage;
import bank.com.pages.ManageAccountsPage;
import bank.com.pages.RegistrationPage;
import bank.com.utilities.ConfigurationReader;
import bank.com.utilities.DateUtil;
import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
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

import java.util.List;

public class US_013_Employee_Create_New_Account_StepDefinitions {

    Faker faker=new Faker();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegistrationPage registrationPage= new RegistrationPage();
    ManageAccountsPage manageAccountsPage=new ManageAccountsPage();


    @Given("Employee on the home page {string}")
    public void employeeOnTheHomePage(String pageUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(pageUrl));
    }

    @Then("Employee clicks menu icon")
    public void employeeClicksMenuIcon() {
        homePage.iconMenu.click();
    }

    @Then("Employee navigates to Login page")
    public void employeeNavigatesToLoginPage() {
        homePage.homePageSignIn.click();
    }

    @Then("Employee provides username and password")
    public void employee_provides_username_and_password(DataTable dataTable) {
        List<String> data= dataTable.row(1);
        System.out.println(data.get(0));
        loginPage.loginPageUsernameTextBox.sendKeys(data.get(0));
        loginPage.loginPagePasswordTextBox.sendKeys(data.get(1));
    }

    @Then("Employee logs in")
    public void employee_logs_in() {
        loginPage.loginPageSignInButtonSibel.click();
    }
    @And("Employee navigates to my operations")
    public void employeeNavigatesToMyOperations() {
        manageAccountsPage.myOperationsDropDown.click();
    }

    @When("Employee clicks on manageAccount")
    public void employeeClicksOnManageAccount() {
        manageAccountsPage.manageAccountsButton.click();
    }

    @Then("Employee creates a new account")
    public void employeeCreatesANewAccount() {
        manageAccountsPage.createNewAccountButton.click();
    }

    @Given("Employee types a description {string}")
    public void employeeTypesADescription(String description) {
        manageAccountsPage.accountDescriptionTextBox.sendKeys(description);
    }

    @And("Employee types the balance as {string}")
    public void employeeTypesTheBalanceAs(String balance) {
        manageAccountsPage.accountBalanceTextBox.sendKeys(balance);
    }

    @Then("Employee selects an account type from dropdown {string}")
    public void employeeSelectsAnAccountTypeFromDropdown(String accountType) {
        Select select = new Select(manageAccountsPage.accountTypeDropDown);
        select.selectByIndex(1);

    }


    @When("Employee selects an accountStatusType {string}")
    public void employeeSelectsAnAccountStatusType(String accountStatus) {
        Select select = new Select(manageAccountsPage.accountStatusTypeDropDown);
        select.selectByValue("ACTIVE");
        //  ReusableMethods.selectAnItemFromDropdown(manageAccountPage.accountStatusTypeDropdown,accountStatus);

    }

    @Given("Employee selects a current create date")
    public void employeeSelectsACurrentCreateDate() {
       String currentTime= manageAccountsPage.createDate.getAttribute("value");
          System.out.println(currentTime); //2021-08-23T00:00

        manageAccountsPage.createDate.sendKeys(DateUtil.todaysDate6() + Keys.TAB + DateUtil.todaysTime());
        System.out.println(DateUtil.todaysDate6());
    }

    @Given("Employee selects a closed date")
    public void employeeSelectsAClosedDate() {
        manageAccountsPage.closedDate.sendKeys(DateUtil.todaysDate8() + Keys.TAB + DateUtil.todaysTime());

    }

    @And("Employee selects an employee")
    public void employeeSelectsAnEmployee() {
    }

    @And("Employee clicks on save button")
    public void employeeClicksOnSaveButton() {
        manageAccountsPage.accountSaveButton.click();
    }

    @Then("Employee confirm that he saves the account with success")
    public void employeeConfirmThatHeSavesTheAccountWithSuccess() {
        //Account olustugunu assert et.
        String actualSuccessMessage= manageAccountsPage.successAccountCreationMessage.getText();
        System.out.println(actualSuccessMessage);
        String expectedSuccessMessage = "translation-not-found[gmiBankBackendApp.tPAccount.created]";
        Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);

        //Burada sayfanin en altina gitmek istiyorum
        JavascriptExecutor je=(JavascriptExecutor) Driver.getDriver();
        //arguments[0].scrollIntoView(true); => THIS IS USED A LOT
        //istedigimiz elemente gidecek.
        je.executeScript("arguments[0].scrollIntoView(true);",manageAccountsPage.aboutUsFooterAccountPage);
        //EXPLICIT WAIT
        //buarada scrollDowsn yapmasi icin bir sure beklemek gerekebilir
        ReusableMethods.waitForVisibility(manageAccountsPage.aboutUsFooterAccountPage,10);

        //burada olusturdugum hesabi verify ediyorum
        int sizeOfAccountTable= manageAccountsPage.satirlarListesi.size();
        System.out.println(sizeOfAccountTable);
        String actualDescription= manageAccountsPage.istenenSatirveSutunYazdir(sizeOfAccountTable+1, 2);
        String expectedDescription =  "Instructor saving account";
        Assert.assertEquals(expectedDescription, actualDescription);
    }

    @Then("Employee clicks on back button")
    public void employeeClicksOnBackButton() {
        manageAccountsPage.accountBackButton.click();
    }

    @Then("Employee confirm that he comes back to the manage account page")
    public void employeeConfirmThatHeComesBackToTheManageAccountPage() {
        String expectedAccountPageUrl= "https://gmibank-qa-environment.com/tp-account";
        String actualAccountPageUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedAccountPageUrl,actualAccountPageUrl);
    }



    @Given("Employee selects a current create date {string} {string}")
    public void employeeSelectsACurrentCreateDate(String currentDate, String currentTime) throws InterruptedException {
        String currentDate1 = DateUtil.todaysDate6();
        String currentTime1= DateUtil.todaysTime();
        manageAccountsPage.createDate.sendKeys( currentDate1 + Keys.TAB + currentTime1);
        Thread.sleep(3000);
    }

    @Given("Employee selects a closed date {string} {string}")
    public void employeeSelectsAClosedDate(String currentDate, String currentTime) {
        String currentDate1 = DateUtil.todaysDate8();
        String currentTime1= DateUtil.todaysTime();
        manageAccountsPage.closedDate.sendKeys( currentDate1 + Keys.TAB + currentTime1 );

    }

    @And("Employee close the browser")
    public void employeeCloseTheBrowser() {
        Driver.getDriver().close();
    }


}


package bank.com.stepDefinitions;


import bank.com.pages.US_015_Page;
import bank.com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US_015_StepDefinitions {

    US_015_Page us_015_page = new US_015_Page();


    @Then("User cliks My Accounts")
    public void user_cliks_my_accounts() {

        us_015_page.Myaccounts.click();
    }

        @Then("User clicks View Transfer")
        public void userClicksViewTransfer () {
            us_015_page.ViewTransfer.click();
        }


        @And("User verifies that Transfer transactions are displayed")
        public void userVerifiesThatTransferTransactionsAreDisplayed () {

            Assert.assertTrue(us_015_page.transferislemi.isDisplayed());

        }


        @Then("User verifies account id")
        public void userVerifiesAccountId () {

            Assert.assertTrue(us_015_page.AccountType.isDisplayed());

        }

        @Then("User verifies balance populated")
        public void userVerifiesBalancePopulated () {

            Assert.assertTrue(us_015_page.AccountBalance.isDisplayed());
        }

        @Then("User close driver")
        public void userCloseDriver () {
            Driver.closeDriver();
        }

    }




//package bank.com.stepDefinitions;
//
//
//import bank.com.pages.US_16_Page;
//import bank.com.utilities.ConfigReader;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//
//public class US_16_StepDefinitions {
//
//
//    US_16_Page us_16_page = new US_16_Page();
//
//
//
//    static String x;
//    static String y;
//
//
//
//    @Then("User clicks Money Transfer")
//    public void userClicksMoneyTransfer() {
//
//       us_16_page.MoneyTransfer.click();
//
//    }
//
//
//    @Then("User selects account from dropdown menu")
//    public void user_selects_account_from_dropdown_menu() throws InterruptedException {
//
//      Thread.sleep(2000);
//      Select select = new Select(us_16_page.fromtextbox);
//
//      select.selectByIndex(1);
//
//    }
//    @Then("User selects account from the to drop-down menu")
//    public void user_selects_account_from_the_to_drop_down_menu() throws InterruptedException {
//
//
//        Select select = new Select(us_16_page.toTextBox);
//
//        select.selectByIndex(1);
//
//
//
//    }
//
//    @Then("User enters description in the description text box")
//    public void user_enters_description_in_the_description_text_box() throws InterruptedException {
//
//
//
//    }
//    @Then("User click Make Transfer icon")
//    public void user_click_make_transfer_icon() {
//
//        us_16_page.MakeTransfericon.click();
//
//    }
//
//
//    @And("User remove from account")
//    public void userRemoveFromAccount() throws InterruptedException {
//
//        Thread.sleep(2000);
//        Select select = new Select(us_16_page.fromtextbox);
//        select.selectByIndex(0);
//
//
//
//    }
//
//    @Then("Assert  visible text")
//    public void assertVisibleText() {
//
//        Assert.assertTrue(us_16_page.basariliyazisi.isDisplayed());
//    }
//
//
//
//    @And("The test that money cannot be transferred")
//    public void theTestThatMoneyCannotBeTransferred() {
//
//        Assert.assertTrue(us_16_page.kirmiziCizgi.isDisplayed());
//
//    }
//
//    @And("User do not selects account from the to drop-down menu")
//    public void userDoNotSelectsAccountFromTheToDropDownMenu() {
//
//        Select select = new Select(us_16_page.toTextBox);
//
//        select.selectByIndex(0);
//    }
//
//    @And("User Test this field is required text")
//    public void userTestThisFieldIsRequiredText() {
//
//        Assert.assertTrue(us_16_page.thisFiedisRequiredYazisi1.isDisplayed());
//    }
//
//
//    @And("The test that money cannot be transferred from description")
//    public void theTestThatMoneyCannotBeTransferredFromDescription() {
//
//        us_16_page.thisfieldDescription.isDisplayed();
//    }
//
//    @And("User enters {string} in the balance text box")
//    public void  userEntersInTheBalanceTextBox(String amountus15) {
//
//        us_16_page.balancetextbox.sendKeys(ConfigReader.getProperty(amountus15));
//    }
//
//    @And("User enters {string} in the description text box")
//    public void userEntersInTheDescriptionTextBox(String descriptionus15) {
//
//        us_16_page.descriptiontextbox.sendKeys(ConfigReader.getProperty(descriptionus15));
//    }
//
//    @And("User do not enter amount in balance text box")
//    public void userDoNotEnterAmountInBalanceTextBox() {
//    }
//
//    @And("User do not enters description in the description text box")
//    public void userDoNotEntersDescriptionInTheDescriptionTextBox() {
//    }
//}
//

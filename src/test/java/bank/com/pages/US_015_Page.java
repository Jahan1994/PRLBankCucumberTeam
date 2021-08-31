package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_015_Page {

    public US_015_Page (){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//span[text()='My Operations']")
    public WebElement MyOperations;

    @FindBy (xpath = "//a[text()='My Accounts']")
    public WebElement Myaccounts;

    @FindBy (xpath = "//a[text()='Transfer Money']")
    public WebElement TransferMoney;

    @FindBy (xpath = "//button[text()='View Transaction'][1]")
    public WebElement ViewTransfer;

    @FindBy(xpath = "//td[text()='Transfer 20.20 to account ID: 13719 ']")
    public WebElement transferislemi;

    @FindBy (xpath = "//tbody//tr[2]//td[3]")
    public WebElement balance;

    @FindBy (xpath = "//tbody//tr[1]//td[2]")
    public WebElement AccountType;

    @FindBy (xpath = "//tbody//tr[1]//td[3]")
    public WebElement AccountBalance;
}

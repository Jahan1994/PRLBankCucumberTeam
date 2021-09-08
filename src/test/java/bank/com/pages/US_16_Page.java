package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_16_Page {


    public US_16_Page (){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//a[text()='Transfer Money']")
    public WebElement MoneyTransfer;

    @FindBy (xpath = "//select[@name='fromAccountId']")
    public WebElement fromtextbox;

    @FindBy(xpath = "//select[@name='toAccountId']")
    public WebElement toTextBox;

    @FindBy (css = "#balance")
    public WebElement balancetextbox;

    @FindBy (tagName = "textarea")
    public WebElement descriptiontextbox;

    @FindBy (id = "make-transfer")
    public WebElement MakeTransfericon;

    @FindBy(xpath = "//div[@style='pointer-events: none;']")
    public WebElement basariliyazisi;

    @FindBy (xpath = "//div[@class='text-danger form-group']")
    public WebElement kirmiziCizgi;


    @FindBy(xpath = "//div[text()='This field is required.'][1]")
    public WebElement thisFiedisRequiredYazisi1;

    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement thisfieldDescription;

}

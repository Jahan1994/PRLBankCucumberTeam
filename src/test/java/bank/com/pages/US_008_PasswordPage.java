package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_008_PasswordPage {

    //static olan metodlari cagirdik
    public US_008_PasswordPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[.='User User2']")
    public WebElement userMenuIcon;

    @FindBy(xpath = "//*[text()='Password']")
    public WebElement passwordIcon;

    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement SignInButton;

    @FindBy(xpath = "//span[.='roland carros']")
    public WebElement signInIcon;

//    @FindBy (css = "#account-menu > a > span")
//    public WebElement menuIcon;

    // @FindBy(id = "#currentPassword")
    //  public WebElement currentPasswordTextBox;

    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement currentPasswordTextBox;

    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPasswordTextBox;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    public WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveButton;


    @FindBy(xpath= "//li[@class='point'][1]")
    public WebElement  line1;

    // colors locator

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);'][1]")
    public WebElement password_Strength_Red;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);'][2]")
    public WebElement password_Strength_Orange;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);'][3]")
    public WebElement password_Strength_Yellow;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);'][4]")
    public WebElement password_Strength_Lime;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);'][5]")
    public WebElement password_Strength_Green;

    @FindBy(xpath = "//*[text()='Password changed!']")
    public WebElement passwordChangedText;


    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public WebElement red;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 255, 0);']")
    public WebElement yellow;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    public WebElement orange;

    @FindBy(xpath = "//li[@style='background-color: rgb(153, 255, 0);']")
    public WebElement lightgreen;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);']")
    public WebElement green;

}

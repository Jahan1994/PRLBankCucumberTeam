package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.PageFactory.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {

    //static olan metodlari cagirdik
    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement iconMenu;
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButton;
    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButton;

    @FindBy(id ="ssn")
    public WebElement ssnTextBox;

    @FindBy(id ="firstname")
    public WebElement firstNameTextBox;

    @FindBy(id ="lastname")
    public WebElement lastNameTextBox;

    @FindBy(id ="address")
    public WebElement addressTextBox;

    @FindBy(id ="mobilephone")
    public WebElement mobilePhoneNumberTextBox;

    @FindBy(id ="username")
    public WebElement usernameTextBox;

    @FindBy(id ="email")
    public WebElement emailTextBox;

    @FindBy(id ="firstPassword")
    public WebElement firstPasswordTextBox;

    @FindBy(xpath = "//div[9]//ul//li[5]")
    public WebElement passwordStrenght;

    @FindBy(id ="secondPassword")
    public WebElement secondPasswordTextBox;

    @FindBy(id = "register-submit")
    public WebElement registersubmitTextBox;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement successfulRegisterMessage;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement wrongSuccesRegisterMessage;

    @FindBy (xpath = "//*[@name='username']")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy (xpath = "//*[@type='submit']")
    public WebElement signIn;

    @FindBy(xpath = "//*[span='My Operations']")
    public WebElement logIn;

    /*
    @FindBy( css= "#strengthBar > li:nth-child(1)")
public WebElement colorLine1;

@FindBy( css= "#strengthBar > li:nth-child(2)")
public WebElement colorLine2;

@FindBy( css= "#strengthBar > li:nth-child(3)")
public WebElement colorLine3;

@FindBy( css= "#strengthBar > li:nth-child(4)")
public WebElement colorLine4;

@FindBy( css= "#strengthBar > li:nth-child(5)")
public WebElement colorLine5;
     */

}

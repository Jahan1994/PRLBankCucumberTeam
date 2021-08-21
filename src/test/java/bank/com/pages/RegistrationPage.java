package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RegistrationPage {

    //static olan metodlari cagirdik
    public RegistrationPage(){

        initElements(Driver.getDriver(), this);
    }

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

    @FindBy(id ="secondPassword")
    public WebElement secondPasswordTextBox;

    @FindBy(id ="register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement successfulRegisterMessage;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement wrongSuccesRegisterMessage;


}

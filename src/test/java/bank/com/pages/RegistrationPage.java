package bank.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bank.com.utilities.Driver;

public class RegistrationPage{


    //static olan metodlari cagirdik
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
       // initElements(Driver.getDriver(), this);
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

    @FindBy(xpath = "//*[text()='Failed to sign in!']")
    public WebElement wrongSuccesRegisterMessage;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement invalidSsnFeedbackText;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[5]/div")
    public WebElement invalidMobilePhoneNumberfeedbackText;

    @FindBy(css = "#register-form > div:nth-child(7) > div")
    public WebElement invalidEmailFeedbackText;

}

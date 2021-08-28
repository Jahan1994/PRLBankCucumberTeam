package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id ="username")
    public WebElement loginPageUsernameTextBox;

    @FindBy(id ="password")
    public WebElement loginPagePasswordTextBox;

    @FindBy(partialLinkText = "Cancel")
    public WebElement loginPageCancelButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement loginPageSignInButton;

    @FindBy(xpath = "(//*[.='Sign in'])[7]")
    public WebElement loginPageSignInButtonSibel;

}

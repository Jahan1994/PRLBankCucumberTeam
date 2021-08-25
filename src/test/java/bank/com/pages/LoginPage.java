package bank.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bank.com.utilities.Driver;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id ="username")
    public WebElement loginPageUsernameTextBox;

    @FindBy(id ="password")
    public WebElement loginPagePasswordTextBox;

    @FindBy(partialLinkText = "Cancel")
    public WebElement loginPageCancelButton;

    @FindBy(partialLinkText = "Sign in")
    public WebElement loginPageSignInButton;

    @FindBy(xpath = "(//*[.='Sign in'])[7]")
    public WebElement loginPageSignInButtonSibel;


}

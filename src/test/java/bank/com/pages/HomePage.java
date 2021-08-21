package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //1. contructor olustur
    public HomePage(){
        //2.
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement iconMenu;

    @FindBy(partialLinkText = "Sign in")
    public WebElement homePageSignIn;

    @FindBy(partialLinkText = "Register")
    public WebElement homePageRegister;

    //asagidakiler ebubekir hocanin anlatimindan alinan locatorlar
    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement icon;
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButton;
    @FindBy(xpath = "(//*[text()='Sign in'])[1]")
    public WebElement signInButton;

}

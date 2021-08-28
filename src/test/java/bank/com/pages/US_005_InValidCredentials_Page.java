package bank.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bank.com.utilities.Driver;

public class US_005_InValidCredentials_Page {

        public US_005_InValidCredentials_Page (){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy (id = "account-menu")
        public WebElement clickMenuIcon;

        @FindBy(id = "login-item")
        public WebElement signIn;

        @FindBy(xpath = "//input[@id='username']")
        public WebElement signUserName;

        @FindBy(xpath = "//input[@id='password']")
        public WebElement signPassword;

        @FindBy(xpath = "(//*[.='Sign in'])[7]")
        public WebElement secondSignInButton;

        @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/form/div[2]/div[1]/div[1]/div/span/strong")
        public WebElement failedMessage;

        @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[2]/div[3]/a/span")
        public WebElement forgetPasswordLink;

        @FindBy(xpath = "//input[@name='email']")
        public WebElement resetPasswordEmail;

        @FindBy(xpath = "//span[.='Reset password']")
        public WebElement resetPasswordButton;

        @FindBy(xpath= "//*[@id=\"login-page\"]/div/form/div[2]/div[4]/a/span")
        public  WebElement registerNewAccountLink;

        @FindBy(xpath= "//span[.='Registration']")
        public  WebElement registrationPage;
    }
/*
    @FindBy(xpath = "//span/strong[.='Failed to sign in!']")
    public WebElement failedMessage;


    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement secondSignInButton;

*/





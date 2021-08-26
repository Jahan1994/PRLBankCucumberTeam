package bank.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bank.com.utilities.Driver;

    public class US_006_UserSettings_Page {
        public US_006_UserSettings_Page (){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(id = "account-menu")
        public WebElement clickMenuIcon;

        @FindBy(id = "login-item")
        public WebElement signIn;

        @FindBy(xpath = "//input[@id='username']")
        public WebElement signUserName;

        @FindBy(xpath = "//input[@id='password']")
        public WebElement signPassword;

        @FindBy(xpath = "//button[@class='btn btn-secondary']")
        public WebElement secondSignInButton;

        @FindBy (css = "#account-menu > a > span")
        public WebElement clickUserIcon;

        @FindBy (xpath = "(//*[@class='dropdown-item'])[3]")
        public WebElement userInfoClick;    //  (//span[.='User Info']
                                            //  (xpath = "//*[@id=\"account-menu\"]/div/a[1]/span")
                                            // @FindBy (css = "#account-menu > div > a.dropdown-item.active > span")


       @FindBy (css = "#account-menu > div > a:nth-child(1) > span")
        public WebElement userSettingsFor;  // (xpath = "//*[@id=\"settings-title\"]/span/text()[1]")
                                            //  //div/div/h2/span/text()[1]

        @FindBy (xpath = "//input[@name ='firstName']")
        public WebElement firstNameBoxClick;

        @FindBy (xpath = "//input[@name ='lastName']")
        public WebElement lastNameBoxClick;

        @FindBy (xpath = "//input[@name ='email']")
        public WebElement emailBoxClick;

        @FindBy (xpath = "//select[@name ='langKey']")
        public WebElement languageSelect;

        @FindBy (xpath = "//*[@class='btn btn-primary']")
        public WebElement saveButtonClick;

        @FindBy(xpath="//strong[.='Settings saved!']")
        public WebElement settingsSaveMessage;


    }

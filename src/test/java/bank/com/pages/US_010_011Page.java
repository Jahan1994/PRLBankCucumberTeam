package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_010_011Page {

    public US_010_011Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "tp-customer-createDate")
    public WebElement createDate;

    @FindBy(id="tp-account-heading")
    public WebElement hesapOlusturulduYazisi;

    @FindBy(id = "tp-customer-user")
    public WebElement userSelect;

    @FindBy(id = "tp-customer-account")
    public WebElement selectAccount;

//    @FindBy(xpath = "tp-customer-account")
//    public List<WebElement> selectAccount;


    @FindBy(id="tp-customer-zelleEnrolled")
    public WebElement zelleEnrolled;

    @FindBy(id="save-entity")
    public WebElement saveButton;

    @FindBy(xpath ="//div[@class='Toastify__toast-body']")
    public WebElement internalError;


}


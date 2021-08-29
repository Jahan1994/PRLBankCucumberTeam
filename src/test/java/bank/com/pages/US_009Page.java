package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




import static org.openqa.selenium.support.PageFactory.initElements;

public class US_009Page {
    public US_009Page(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "entity-menu")
    public WebElement MyOpertions;

    @FindBy(linkText = "Manage Customers")
    public WebElement ManageCustomers;

    @FindBy(id = "jh-create-entity")
    public WebElement CreateaNewCustomer;

    @FindBy(id = "search-ssn")
    public WebElement SSN;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@value='Maria']")
    public WebElement firstname;

    @FindBy(id = "tp-customer-lastName")
    public WebElement lastname;

    @FindBy(id = "tp-customer-email")
    public WebElement email;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement adress;

    @FindBy(id = "tp-customer-ssn")
    public WebElement ssn;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement succesmessage;

    @FindBy(xpath = "//div[@class='form-group']")
    public WebElement dropdown;

    @FindBy(id = "tp-customer-middleInitial")
    public WebElement middle;

    @FindBy(xpath = "//input[@name='mobilePhoneNumber']")
    public WebElement mobile;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='zipCode']")
    public WebElement zipcode;


    @FindBy(xpath = "//input[@name='city']")
    public WebElement city;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement countryList;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement state;



}







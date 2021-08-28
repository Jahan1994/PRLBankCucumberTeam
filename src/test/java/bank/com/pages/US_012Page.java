package bank.com.pages;

import bank.com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_012Page {

    public US_012Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="username")
    public WebElement loginPageUsernameTextBox;

    @FindBy(xpath = "//span[contains(text(), 'My Operations')]")
    public WebElement myOperations;

    @FindBy(xpath= "//span[text() = 'Manage Customers']")
    public WebElement manageCustomers;

    @FindBy(xpath ="//th[@class='hand']")
    public List<WebElement> columnList;

    @FindBy(xpath= "(//span[text()='View'])[1]")
    public WebElement viewButton;

    @FindBy(xpath= "//span[text()='Edit']")
    public WebElement editButton;

    //div[@class='form-group']

    @FindBy(xpath ="//div[@class='form-group']")
    public List<WebElement> editList;

    @FindBy(xpath = "//*[text()='Donte']")
    public WebElement firstName;    //*[text()='Schiller']

    @FindBy(xpath = "//*[text()='Schiller']")
    public WebElement lastName;

    @FindBy(xpath = "//dd")
    public List<WebElement> viewList;

    @FindBy(xpath= "//span[text()='Edit']")
    public WebElement editButton1;

    @FindBy(xpath = "//input[@name='id']")
    public WebElement id;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName2;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName2;

    @FindBy(xpath = "//input[@name='middleInitial']")
    public WebElement middleInitial;

//    @FindBy(xpath = "//a[@href='/tp-customer/1719/delete?page=1&sort=id,asc']")
//    public WebElement delete;

    @FindBy(xpath = "(//span[text()='Delete'])[5]")
    public WebElement delete;

//    @FindBy(xpath = "(//a[ contains(@href, 'delete?page=1&sort=id,asc')])[4]")
//    public WebElement delete;

    @FindBy(xpath = "//span[contains(text(), 'Are you sure you want to delete Customer')]")
    public WebElement confDeleteMessage;

    @FindBy(id = "jhi-confirm-delete-tPCustomer")
    public WebElement delete2;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteSuccesMessage;

    @FindBy(xpath = "//span[text()='Back']")
    public WebElement backButton;


}


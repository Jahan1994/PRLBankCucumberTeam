package bank.com.pages;

import bank.com.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_018_Pages {

    public US_018_Pages() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="entity-menu")
    public WebElement myOperationsButton;

    @FindBy (xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement manageCustomersButton;

    @FindBy (xpath="//table//th//span")
    public List<WebElement> visibleElements;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public WebElement viewButton;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement editButton;

    //a[@class='btn btn-primary btn-sm']
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement userInfoEditButton;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement deletePopUp;

    @FindBy(xpath = "(//a[@class='btn btn-success btn-sm'])[1]")
    public WebElement idButton;

    @FindBy(xpath = "//*[@id='gmibankfrontendApp.tPCustomer.delete.question']//span")
    public WebElement deleteQuestion;

    @FindBy(id= "jhi-confirm-delete-tPCustomer")
    public WebElement popupDeleteButton;

    @FindBy(id="tp-customer-firstName")
    public WebElement firstName;

    @FindBy(id="tp-customer-lastName")
    public WebElement lastName;

    @FindBy(id="tp-customer-middleInitial")
    public WebElement middleName;

    @FindBy(id="tp-customer-email")
    public WebElement email;

    public List<String> fakeInfo() {

        Faker faker = new Faker();


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleName=faker.name().nameWithMiddle();
        String email = faker.internet().emailAddress();

        return new ArrayList<>(Arrays.asList(firstName,lastName,middleName,email));
    }

}
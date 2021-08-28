package bank.com.pages;

import bank.com.utilities.Driver;
import bank.com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_017_Pages {


    public US_017_Pages() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@aria-haspopup='true'])[2]")
    public WebElement administration;

    @FindBy(xpath = "//*[.='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar--success']")
    public WebElement notifications;

    @FindBy(xpath = "//dd")
    public List<WebElement> userInfoCells;

    @FindBy(id = "login")
    public WebElement loginName;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "activated")
    public WebElement activationCheckBox;

//        @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[3]")
//        public WebElement signoutDropDownMenuButton;
//
//        @FindBy(partialLinkText = "/logout")
//        public WebElement signOutButton;
//
//        @FindBy(xpath = "//*[@class='page-link']")
//        public WebElement pageLink;
//
//        @FindBy(xpath="//button[@class='btn btn-danger']")
//        public WebElement deleteConfirmationButton;

    @FindBy(id="authorities")
    public WebElement profiles;

    @FindBy(xpath="//span[.='Created date']")
    public WebElement createdDate;


    public void pressEditButton(int no) {

        WebElement edit = Driver.getDriver().findElement(By.xpath("(//div[@class='btn-group flex-btn-group-container']//a[@class='btn btn-primary btn-sm'])[" + no + "]"));
        ReusableMethods.waitForClickablility(edit, 15);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", edit);
    }

    public String getUserName(int no) {

        WebElement nameCell = Driver.getDriver().findElement(By.xpath("//table//tr[" + no + "]//td[2]"));
        return nameCell.getText();
    }

    public String getProfileName(int no) {
        WebElement profileName = Driver.getDriver().findElement(By.xpath("//table//tr[" + no + "]//td[6]"));
        return profileName.getText();
    }


    public void pressViewButton(int no) {

        WebElement view = Driver.getDriver().findElement(By.xpath("(//a[@class='btn btn-info btn-sm'])[" + no + "]"));
        ReusableMethods.waitForClickablility(view, 15);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", view);
    }

    public List<String> fakeInfo() {

        Faker faker = new Faker();

        String login = faker.name().firstName();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        return new ArrayList<>(Arrays.asList(login, firstName, lastName, email));
    }

//        public int positonOfLoginNameEqualsUser(String user) {
//
//            int number = 0;
//            for (int i = 1; i <= 20; i++) {
//                WebElement login = Driver.getDriver().findElement(By.xpath("//table//tr[" + i + "]//td[2]"));
//                if (login.getText().equals(user)) {
//                    number = i;
//                }
//            }
//            return number;
//
//        }

//        public void pressCreateDateButton() {
//            WebElement createDateButton = Driver.getDriver().findElement(By.xpath("(//th[@class='hand'])[5]//span"));
//            ReusableMethods.waitForClickablility(createDateButton, 15);
//            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", createDateButton);
//        }

    public void pageLinkClick(int no) {
        String n = no + "";
        Driver.getDriver().findElement(By.linkText(n)).click();

    }

    public void pressDeleteButton(int no) {
        WebElement delete = Driver.getDriver().findElement(By.xpath("(//div[@class='btn-group flex-btn-group-container']//a[@class='btn btn-danger btn-sm'])[" + no + "]"));
        ReusableMethods.waitForClickablility(delete, 15);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", delete);
    }

    public static void sleep(int milliseconds) {

        try {
            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
//    public static int randomIntegerGenerator(int ustLimit) {
//        Random ran = new Random();
//        int x = ran.nextInt(ustLimit);
//        if (x==0)
//        {
//            x=x+1;
//        }
//        return x;
//    }
//}
}

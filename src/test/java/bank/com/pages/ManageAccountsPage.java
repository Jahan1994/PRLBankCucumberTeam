package bank.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import bank.com.utilities.Driver;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ManageAccountsPage{

    public ManageAccountsPage(){
        initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "entity-menu")
    public WebElement myOperationsDropDown;

    @FindBy(xpath = "//*[@class='dropdown-item'][2]")
    public WebElement manageAccountsButton;

    @FindBy(id="jh-create-entity")
    public WebElement createNewAccountButton;

    @FindBy(id="tp-account-description")
    public WebElement accountDescriptionTextBox;

    @FindBy(id="tp-account-balance")
    public WebElement accountBalanceTextBox;

    @FindBy(id="tp-account-accountType")
    public WebElement accountTypeDropDown;

    @FindBy(id="tp-account-accountStatusType")
    public WebElement accountStatusTypeDropDown;

    @FindBy(id="tp-account-createDate")
    public WebElement createDate;

    @FindBy(id="tp-account-closedDate")
    public WebElement closedDate;

    @FindBy(id="tp-account-employee")
    public WebElement employeeDropDown;

    @FindBy(id="save-entity")
    public WebElement accountSaveButton;

    @FindBy(xpath = "//*[text()='translation-not-found[gmiBankBackendApp.tPAccount.created]']")
    public WebElement successAccountCreationMessage;

    @FindBy(id="cancel-save")
    public WebElement accountBackButton;

    @FindBy(xpath = "//tbody//tr[1]//td")
    public List<WebElement> birinciSatirDatalar;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//div[@class='widget widget-about']")
    public WebElement aboutUsFooterAccountPage;

    public String istenenSatirveSutunYazdir(int satirNo, int sutunNo){
        String satirSutunXPath = "//tbody//tr[" + (satirNo) + "]//td["+ sutunNo + "]";
        String getTextSatirSutun = Driver.getDriver().findElement(By.xpath(satirSutunXPath)).getText();
        System.out.println(satirNo + ". satir " +  sutunNo +".  sutunun degeri : " + getTextSatirSutun );
        return getTextSatirSutun;
    }

    public WebElement dataBul(int satirNo, int sutunNo) {
        // ornek : her 3. satirdaki 2.sutunu bulmak istersek //tbody//tr[3]//td[2] yazabiliriz
        String dataPath = "//tbody//tr[" + satirNo + "]//td[" + sutunNo + "]";
        System.out.println(dataPath);

        System.out.println("istediginiz data : " + Driver.getDriver().findElement(By.xpath(dataPath)).getText());
        return Driver.getDriver().findElement(By.xpath(dataPath));
    }

    /*
    USER MANAGEMENT active yapmak icin
    //Locator su sekilde oluyor.//a[starts-with(@href,'/admin/user-management/kamuran')]
    //Dinamik yapmak icin
    String username= "kamuran";
    By path = By.xpath("//a[starts-with(@href,'/admin/user-management/" + username+ "')]");
    //kullaninca istenilen kisiye ulasiliyor ve ona tiklama yapilir.

*/


}

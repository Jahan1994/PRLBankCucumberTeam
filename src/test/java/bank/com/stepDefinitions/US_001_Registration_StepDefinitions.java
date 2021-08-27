package bank.com.stepDefinitions;

import bank.com.pojos.User;
import bank.com.utilities.Driver;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import bank.com.pages.HomePage;
import bank.com.pages.RegistrationPage;
import bank.com.utilities.ConfigReader;
import bank.com.pojos.Customer;

import java.util.List;

public class    US_001_Registration_StepDefinitions {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage= new RegistrationPage();
    Faker faker = new Faker();
    Customer customer=new Customer();
    Customer customer1=new Customer();
    User user =new User();
    String fileName= ConfigReader.getProperty("fileNameOfCustomer");
    String firstName;
    String lastName;
    String firstPassword;
    String userName;
    String ssn;


    @Then("User provides a valid SSN with javafaker as {string}")
    public void userProvidesAValidSSNWithJavafakerAs(String ssn) {
        ssn = faker.idNumber().ssnValid();
        this.ssn=ssn;
        Driver.waitAndSendText(registrationPage.ssnTextBox, ssn, 5);
       // registrationPage.ssnTextBox.sendKeys(ssn);
        customer.setSsn(ssn);
    }
    @Then("User provides a valid Firstname with javafaker as {string}")
    public void userProvidesAValidFirstnameWithJavafakerAs(String firstname) {
        firstname=faker.name().firstName();
        this.firstName=firstname;
        Driver.waitAndSendText(registrationPage.firstNameTextBox, firstname, 5);
        //registrationPage.firstNameTextBox.sendKeys(ConfigReader.getProperty("valid_firstname"));
        customer.setFirstName(firstname);
    }

    @Then("User provides a valid Lastname with javafaker as {string}")
    public void userProvidesAValidLastnameWithJavafakerAs(String lastname) {
        lastname=faker.name().lastName();
        this.lastName= lastname;
        Driver.waitAndSendText(registrationPage.lastNameTextBox, lastname, 1);
        //registrationPage.firstNameTextBox.sendKeys(ConfigReader.getProperty("valid_firstname"));
        customer.setLastName(lastname);
    }

    @Then("User provides a valid Address with javafaker as {string}")
    public void userProvidesAValidAddressWithJavafakerAs(String address) {
        address=faker.address().fullAddress();
        Driver.waitAndSendText(registrationPage.addressTextBox, address, 1);
        //registrationPage.firstNameTextBox.sendKeys(ConfigReader.getProperty("valid_firstname"));
        customer.setAddress(address);
    }

    @Then("User provides a valid Mobile Phone Number with javafaker as {string}")
    public void userProvidesAValidMobilePhoneNumberWithJavafakerAs(String mobilenumber) {
        //mobilenumber=faker.phoneNumber().cellPhone();
        mobilenumber= ConfigReader.getProperty("valid_mobile_phone_number");
        registrationPage.mobilePhoneNumberTextBox.sendKeys(mobilenumber);
        customer.setPhoneNumber(mobilenumber);
    }

    @Then("User provides a valid Username with javafaker as {string}")
    public void userProvidesAValidUsernameWithJavafakerAs(String username) {
        username= faker.name().username();
        this.userName=username;
        registrationPage.usernameTextBox.sendKeys(username);
       customer.setUserName(username);

    }

    @Then("User provides a valid Email with javafaker as {string}")
    public void userProvidesAValidEmailWithJavafakerAs(String email) {
       // email= faker.internet().emailAddress();
        email=firstName+lastName+"@gmail.com";
        registrationPage.emailTextBox.sendKeys(email);
        customer.setEmail(email);
    }

    @Then("User provides a valid Password with javafaker as {string}")
    public void userProvidesAValidPasswordWithJavafakerAs(String firstpassword) {
        firstpassword= faker.internet().password(10, 15, true, true);
        this.firstPassword=firstpassword;
        registrationPage.firstPasswordTextBox.sendKeys(firstpassword);
        customer.setFirstPassword(firstPassword);

    }

    @Then("User provides a valid Password to Password confirmation textbox with javafaker as {string}")
    public void userProvidesAValidPasswordToPasswordConfirmationTextboxWithJavafakerAs(String secondPassword) {
        secondPassword=firstPassword;
        registrationPage.secondPasswordTextBox.sendKeys(secondPassword);

    }

    @Then("User clicks on Register button and validates that with a success message as {string}")
    public void userClicksOnRegisterButtonAndValidatesThatWithASuccessMessageAs(String expectedSuccesMessage) throws InterruptedException {

        registrationPage.registerButton.click();
        WriteToTxt.saveAllCustomer(fileName, customer, firstPassword, userName);
      //  System.out.println("Username " + customer.getUser().getUsername());

        //toplu olarak yazdirma
        List<Customer> list2= ReadTxt.returnAWholeCostumer(fileName);
        for (int i = 0; i < list2.size() ; i++) {
            System.out.println("firstname =>" + list2.get(i).getFirstName());
            System.out.println("lastname => " + list2.get(i).getLastName());
        }
        System.out.println("===========");
        //tek tek firstname vs yazdirma
        System.out.println("last element => firstname =>" + list2.get(list2.size()-1).getFirstName());
        System.out.println("last element => last ssn =>" + list2.get(list2.size()-1).getSsn());
        System.out.println("username "+list2.get(list2.size()-1).getUserName());
        System.out.println("password "+list2.get(list2.size()-1).getFirstPassword());

        Thread.sleep(3000);
        String actualSuccessMessage = registrationPage.successfulRegisterMessage.getText();
        System.out.println(actualSuccessMessage);
        expectedSuccesMessage= ConfigReader.getProperty("registration_success_message");
        System.out.println(expectedSuccesMessage);
        // Assert.assertEquals(expectedSuccesMessage,actualSuccessMessage);
        Assert.assertTrue("Success mesaji gorulmedi", actualSuccessMessage.contains(expectedSuccesMessage));
    }

    @And("User validates that he registered succesfully success message as {string}")
    public void userValidatesThatHeRegisteredSuccesfullySuccessMessageAs(String expectedSuccesMessage) {
         String actualSuccessMessage = registrationPage.successfulRegisterMessage.getText();
        System.out.println(actualSuccessMessage);
        expectedSuccesMessage= ConfigReader.getProperty("registration_success_message");
        // Assert.assertEquals(expectedSuccesMessage,actualSuccessMessage);
        Assert.assertTrue("Success mesaji gorulmedi", actualSuccessMessage.contains(expectedSuccesMessage));
    }


    @And("User navigates to registration page")
    public void userNavigatesToRegistrationPage() {
        homePage.homePageRegister.click();
    }

    @Then("User provides a valid SSN")
    public void userProvidesAValidSSN() {
        registrationPage.ssnTextBox.sendKeys(ConfigReader.getProperty("valid_ssn"));
    }

    @Then("User provides a valid Firstname")
    public void userProvidesAValidFirstname() {
        registrationPage.firstNameTextBox.sendKeys(ConfigReader.getProperty("valid_firstname"));

    }

    @Then("User provides a valid Lastname")
    public void userProvidesAValidLastname() {
        registrationPage.lastNameTextBox.sendKeys(ConfigReader.getProperty("valid_lastname"));
    }

    @Then("User provides a valid Address")
    public void userProvidesAValidAddress() {
        registrationPage.addressTextBox.sendKeys(ConfigReader.getProperty("valid_address"));
    }

    @Then("User provides a valid Mobile Phone Number")
    public void userProvidesAValidMobilePhoneNumber() {
        registrationPage.mobilePhoneNumberTextBox.sendKeys(ConfigReader.getProperty("valid_mobile_phone_number"));
    }

    @Then("User provides a valid Username")
    public void userProvidesAValidUsername() {
        registrationPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_username"));
    }

    @Then("User provides a valid Email")
    public void userProvidesAValidEmail() {
        registrationPage.emailTextBox.sendKeys(ConfigReader.getProperty("valid_email"));

    }

    @Then("User provides a valid Password")
    public void userProvidesAValidPassword() {
        registrationPage.firstPasswordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
    }

    @Then("User provides a valid Password to Password confirmation textbox")
    public void userProvidesAValidPasswordToPasswordConfirmationTextbox() {
        registrationPage.secondPasswordTextBox.sendKeys(ConfigReader.getProperty("valid_password_confirm"));
    }

    @Then("User clicks on Register button")
    public void userClicksOnRegisterButton() {
        registrationPage.registerButton.click();
    }

    @And("User validates that he registered succesfully")
    public void userValidatesThatHeRegisteredSuccesfully() {
        String actualSuccessMessage = registrationPage.successfulRegisterMessage.getText();
        System.out.println(actualSuccessMessage);
        String expectedSuccesMessage= ConfigReader.getProperty("registration_success_message");
        // Assert.assertEquals(expectedSuccesMessage,actualSuccessMessage);
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccesMessage));
    }

}

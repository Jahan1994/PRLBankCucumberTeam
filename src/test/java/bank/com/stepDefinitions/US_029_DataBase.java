package bank.com.stepDefinitions;

import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static bank.com.utilities.DatabaseUtility.*;

public class US_029_DataBase {

    // DATABASE
    List<Object> objectList;
    String fileNameSSNDB = "src\\test\\resources\\test_data\\customerSSNDB.txt";
    String fileNameCountryIdDB = "src\\test\\resources\\test_data\\countryIdDB.txt";


    @Given("database user creates a connection with db using {string} , {string} and {string}")
    public void databaseUserCreatesAConnectionWithDbUsingAnd(String url, String user, String password) {
        createConnection(url, user, password);

    }

    @Then("user reads the Customers data using {string} and {string}")
    public void databaseUserReadsTheCustomersDataUsingAnd(String query, String columnName) {
        //  String queryCustomerData = "Select * from tp_customer";
        objectList = getColumnData(query,columnName);
        System.out.println(objectList);
    }

    @Then("user save DB Customer info to correspondent files")
    public void databaseUserSaveDBCustomerInfoToCorrespondentFiles() {
        File file = new File("src\\test\\resources\\test_data\\customerSSNDB.txt");
        if (file != null) {
            file.delete();
        }
        WriteToTxt.saveAllCustomersComingFromDB(fileNameSSNDB,objectList);

    }

    @Then("user validates customers data")
    public void userValidatesCustomersData() {
//        Assert.assertTrue(objectList.contains("246-59-3825"));
//        System.out.println("====================================================");
//        System.out.println("Validation is succesfull");

        List<String> expectedSSNs = new ArrayList<>();
        expectedSSNs.add("473-22-1798");
        expectedSSNs.add("027-31-2727");

        List<String> actualSSNs = ReadTxt.returnCustomerSNNList(fileNameSSNDB);
        Assert.assertTrue("All customer SSNs do not match!", actualSSNs.containsAll(expectedSSNs));
        System.out.println("Validation is succesfull");

    }
//===========================================================================================
    @Then("user reads the country data using {string} and {string}")
    public void userReadsTheCountryDataUsingAnd(String query, String columnName) {
        objectList = getColumnData(query,columnName);
        System.out.println(objectList);
    }

    @Then("user save DB country info to correspondent files")
    public void userSaveDBCountryInfoToCorrespondentFiles() {
        File file = new File("src\\test\\resources\\test_data\\countryIdDB.txt");
        if (file != null) {
            file.delete();
        }

        WriteToTxt.saveAllCustomersComingFromDB(fileNameCountryIdDB,objectList);

    }

    @Then("user validates all countries' info")
    public void userValidatesAllCountriesInfo() {
        List<String> expectedIDs = new ArrayList<>();
        expectedIDs.add("24115");
        expectedIDs.add("1752");

        List<String> actualCountryIdDB = ReadTxt.returnCountryIdList(fileNameCountryIdDB);
        Assert.assertTrue("All country do not match!", actualCountryIdDB.containsAll(expectedIDs));
        System.out.println("Validation is succesfull");
    }
//============================================================================================================

    @Then("user reads the names of the state from USA {string} and {string}")
    public void userReadsTheNamesOfTheStateFromUSAAnd(String query, String columnName) {
        objectList = getColumnData(query,columnName);
        System.out.println(objectList);

    }

    @Then("user validates the names of the state from USA")
    public void userValidatesTheNamesOfTheStateFromUSA() {
        Assert.assertTrue(objectList.contains("California"));
        Assert.assertTrue(objectList.contains("New York"));
        Assert.assertTrue(objectList.contains("Virginia"));
        System.out.println("====================================================");
        System.out.println("Validation is succesfull");

    }
}

package bank.com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static bank.com.utilities.DatabaseUtility.createConnection;
import static bank.com.utilities.DatabaseUtility.getColumnData;

public class US_020_DataBaseCustomer {

    // DATABASE
    List<Object> objectList;

    @Given("database user creates a connection with db using {string} , {string} and {string}")
    public void databaseUserCreatesAConnectionWithDbUsingAnd(String url, String user, String password) {
        createConnection(url, user, password);
        //  String queryCustomerData = "Select * from tp_customer";
    }

    @Then("database user reads the Customers data using {string} and {string}")
    public void databaseUserReadsTheCustomersDataUsingAnd(String query, String ssn) {
        //  String queryCustomerData = "Select * from tp_customer";
        objectList = getColumnData(query, ssn);
        System.out.println(objectList.toString());
    }

    @Then("database validate customers data")
    public void databaseValidateCustomersData() {
        Assert.assertTrue(objectList.contains("246-59-3825"));
        System.out.println("====================================================");
        System.out.println("Validation is succesfull");
        System.out.println(objectList);
    }
}

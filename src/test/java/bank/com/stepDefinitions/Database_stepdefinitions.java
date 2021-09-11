package bank.com.stepDefinitions;

import bank.com.utilities.DatabaseUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static bank.com.utilities.DatabaseUtility.*;

public class Database_stepdefinitions {



    public static void main(String[] args) {

        createConnection();
        String queryCustomerData = "Select * from tp_customer";
        System.out.println(getColumnNames(queryCustomerData));
        System.out.println("=============================================");
        System.out.println(getColumnData(queryCustomerData,"first_name"));
        System.out.println("=============================================");
        System.out.println(getCellValue(queryCustomerData,8,4));
        closeConnection();


    }


    List<Object> objectList;


    @Given("database ders bank7 user creates a connection with db using {string} , {string} and {string}")
    public void database_ders_bank7_user_creates_a_connection_with_db_using_and(String url, String user, String password) {
        createConnection(url, user, password);
    }

    @Given("database ders bank7 user reads the Customers data using {string} and {string}")
    public void database_ders_bank7_user_reads_the_Customers_data_using_and(String query, String ssn) {
        objectList = getColumnData(query,ssn);
        System.out.println(objectList.toString());
    }

    @Then("database ders bank7 validate customers data")
    public void database_ders_bank7_validate_customers_data() {

        Assert.assertTrue(objectList.contains("843-96-3674"));
        System.out.println("====================================================");
        System.out.println("Validation is succesfull");

    }


}
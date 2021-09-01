package bank.com.stepDefinitions;

//import bank.com.pojos.Country5;
import bank.com.pojos.Customer;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.fasterxml.jackson.databind.ObjectMapper;
//import bank.com.pojos.Customer5;
import io.cucumber.java.en.Given;
import bank.com.utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bank.com.jsonModels.CountryJson.createCountry;
import static io.restassured.RestAssured.given;

public class US_020_StepDefinition {

    Response response;
    int createdCountryId;
    Response responseAll;

    @Given("read all customer data using with api endpoint {string}")
    public void read_all_customer_data_using_with_api_endpoint(String api_endpoint) {

        response = given().headers("Authorization",
                "Bearer " + ConfigReader.getProperty("token"),
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

    //    response.prettyPrint();

        System.out.println("===================================================================================");


    }

   @Then("validate customer data")
    public void validate_customer_data() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Customer[] customer = objectMapper.readValue(response.asString(), Customer[].class);
/*
        // ilk musterinin ismi
        System.out.println(customer[0].getFirstName());

        // 5. musterinin email adresi
        System.out.println(customer[4].getEmail());

        System.out.println("===================================================================================");

        // tum musterilerin SsN numaralari
        for (int i = 0; i < customer.length; i++) {
            System.out.println(customer[i].getSsn());
        }

        System.out.println("===================================================================================");

        // M harfi ile baslayan musteri isimleri
        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getFirstName().startsWith("M")) {
                System.out.println(customer[i].getFirstName());
            }
        }

        System.out.println("===================================================================================");

        for (int i = 0; i < customer.length; i++) {
            if (customer[i].getUser() != null) {
                System.out.println(customer[i].getUser().getFirstName());
            }
        }*/


        List <String> customerId = new ArrayList<>();
        for (int i = 0; i< customer.length; i++){
           customerId.add(String.valueOf(customer[i].getId()));
   }
        // System.out.println(customerId);
       WriteToTxt.

}}

//package gmibank.stepdefinitions;
//        import static io.restassured.RestAssured.*;
//        import gmibank.utilities.ConfigurationReader;
//        import io.cucumber.java.en.And;
//        import io.cucumber.java.en.Given;
//        import io.restassured.path.json.JsonPath;
//        import io.restassured.response.Response;
//        import org.junit.Assert;
//        import java.util.*;
//
//public class US_20_Step_Definitions {
//
//    Response response;
//    List<Map<String, Object>> listofCustomers ;
//    JsonPath json;
//
//
//    @Given("use api end point  {string}")
//    public void use_api_end_point(String endPoint) {
//        response = given().
//                auth().
//                oauth2(ConfigurationReader.getProperty("token")).
//                when().
//                get(endPoint);
//
//        json = response.jsonPath();
//
////        response.prettyPrint();
//
//    }
//
//    @Given("get all customers' information as De-Serialization")
//    public void get_all_customers_information_as_De_Serialization() {
//        listofCustomers = response.as(ArrayList.class);
////        System.out.println("De-Serialization Data Type : " +listofCustomers);
//
//    }
//
//    @Given("find out how many customers are and verify")
//    public void find_out_how_many_customers_are_and_verify() {
////        System.out.println("Total Number of Customer : "+ listofCustomers.size());
//        Assert.assertTrue(listofCustomers.size()==20);
//
//    }
//
//    @And("get all the information of the seventh customer")
//    public void getAllTheInformationOfTheSeventhCustomer() {
//        String seventhCustomer = listofCustomers.get(6).toString();
////        System.out.println("Seventh Customer : " + seventhCustomer);
//
//    }
//
//    @And("verify seventh customers {string} and {string}")
//    public void verifySeventhCustomersAnd(String ssnValue, String stateName) {
//        String expectedSsnValue = listofCustomers.get(6).get(ssnValue).toString();
//        Assert.assertEquals(expectedSsnValue,getSeventhCustomerSsn());
//
//        String expectedStateValue = listofCustomers.get(6).get(stateName).toString();
//        Assert.assertEquals(expectedStateValue, getSeventhCustomersState());
//    }
//    public String getSeventhCustomerSsn(){
//        return listofCustomers.get(6).get("ssn").toString();
//    }
//
//    public String getSeventhCustomersState(){
//        return listofCustomers.get(6).get("state").toString();
//    }
//
//    @And("verify first customer's {string}")
//    public void verifyFirstCustomerS(String firstName) {
//        String firstCustomerName = listofCustomers.get(0).get(firstName).toString();
//        String expectedFirstNameOne = listofCustomers.get(0).get("firstName").toString();
//        Assert.assertEquals(expectedFirstNameOne,firstCustomerName);
//
//    }
//
//    @And("verify second customer's {string}")
//    public void verifySecondCustomerS(String lastName) {
//        String lastNameOfSecondCustomer= listofCustomers.get(1).get(lastName).toString();
//        String expectedLastNameTwo = listofCustomers.get(1).get("lastName").toString();
//        Assert.assertEquals(expectedLastNameTwo, lastNameOfSecondCustomer);
//    }
//
//    @And("verify fifth customer's {string}")
//    public void verifyFifthCustomerSCountry(String country) {
//        country =fifthCustomersCountry();
//        String expectedFifthCountry = json.getString("country[4].name");
//        Assert.assertEquals(expectedFifthCountry,country);
//
//    }
//
//    public String fifthCustomersCountry(){
//        return json.get("country[4].name");
//    }
//
//    @Given("get last customer's id and verify")
//    public void get_first_customer_s_id_and_verify() {
//        int actualLastId = json.getInt("id[-1]");
//        int expectedLastId = getLastId();
//        Assert.assertEquals(actualLastId,expectedLastId);
//
//    }
//    public int getLastId(){
//        Response responseGet = given().
//                auth().
//                oauth2(ConfigurationReader.getProperty("token")).
//                when().
//                get("https://www.gmibank.com/api/tp-customers");
//        json = responseGet.jsonPath();
//        int lastId = json.getInt("id[-1]");
//
//        return lastId;
//    }}
//===========================================================================================
//package gmibank.stepdefinitions;
//
//        import com.fasterxml.jackson.core.JsonProcessingException;
//        import com.fasterxml.jackson.databind.ObjectMapper;
//        import gmibank.pojos.Country;
//        import gmibank.pojos.Customer;
//        import gmibank.utilities.ConfigurationReader;
//        import io.cucumber.java.en.Given;
//
//        import io.cucumber.java.en.Then;
//        import io.restassured.http.ContentType;
//
//        import io.restassured.path.json.JsonPath;
//        import io.restassured.response.Response;
//        import org.junit.Assert;
//
//
//        import java.io.IOException;
//        import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.List;
//        import java.util.Map;
//
//        import static io.restassured.RestAssured.given;
//
//public class US_20ApiTestStepDef {
//
//    Response response;
//    JsonPath jsonPath;
//    // Customer[] customer;
//    // List<Integer> id=new ArrayList<>();
//
//    @Given("kullanici api {string} gider")
//    public void kullanici_api_gider(String end_point) {
//
//        response = given().headers("Authorization",
//                "Bearer " + ConfigurationReader.getProperty("token"),
//                "Content-Type", ContentType.JSON,
//                "Accept", ContentType.JSON)
//                .when()
//                .get(end_point)
//                .then()
//                .contentType(ContentType.JSON)
//                .statusCode(200)
//                .extract()
//                .response();
//
//        response.prettyPrint();
//
//
//    }
//
//    @Then("kullanici tum customer bilgilerini okur")
//    public void kullanici_tum_customer_bilgilerini_okur() throws IOException{
//        jsonPath=response.jsonPath();
//        String firstName=jsonPath.getString("firstName");
//        String lastName=jsonPath.getString("lastName");
//        String email=jsonPath.getString("email");
//        String mobilno=jsonPath.getString("mobilePhoneNumber");
//        String city=jsonPath.getString("city");
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(mobilno);
//        System.out.println(city);
//        System.out.println(email);
//        Assert.assertTrue(firstName.contains(ConfigurationReader.getProperty("us_20firstName")));
//        Assert.assertTrue(lastName.contains(ConfigurationReader.getProperty("us_20lastName")));
//        Assert.assertTrue(mobilno.contains(ConfigurationReader.getProperty("us_20mobilePhoneNumber")));
//        Assert.assertTrue(email.contains(ConfigurationReader.getProperty("us_20email")));
//        Assert.assertTrue(city.contains(ConfigurationReader.getProperty("us_20city")));
//    }
//
//    @Then("kullanici okudugu customerlerin verilerini validate yapar")
//    public void kullanici_okudugu_customerlerin_verilerini_validate_yapar() {
//
//    }
//
//
//}

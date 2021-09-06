package bank.com.stepDefinitions;

import bank.com.pojos.Accounts;
import bank.com.pojos.Country;
import bank.com.pojos.Customer;
import bank.com.pojos.User;
import bank.com.utilities.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US_020_StepDefinition {

    Response response;
    String token;
    Customer[] customer;

    @Given("User first should get a token by using API {string}")
    public void userFirstShouldGetATokenByUsingAPI(String tokenEndPoint) {

                  String credentials = "{\n" +
                    "    \"username\" : \"team18_customer\",\n" +
                    "    \"password\" : \"Team18customer\",\n" +
                    "    \"rememberMe\" : false\n" +
                    "}";



        token = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .when()
                    .body(credentials)
                    .post(tokenEndPoint)
                    .then()
                    .extract()
                    .path("id_token");

            System.out.println("token: " + token);
    }

    @Given("read all customer data using with api endpoint {string}")
    public void read_all_customer_data_using_with_api_endpoint(String api_endpoint) {

        response = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .param("size", 2000)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

       //response.prettyPrint();

   }

        @Then("deserialize using ObjectMapper")
        public void deserializeUsingObjectMapper() throws IOException {

            ObjectMapper objectMapper = new ObjectMapper();
            Customer[] customer = objectMapper.readValue(response.asString(), Customer[].class);
    }
        @Then("validate customer data")
        public void validate_customer_data () throws IOException {
//       List <String> allCustomer = new ArrayList<>();
//       for (int i = 0; i< customer.length; i++){
//           allCustomer.add(String.valueOf(customer[i]));
//  }

            File file = new File("All_Customer2");
            if (file != null) {
                file.delete();
            }

            //    Printing all customer as txt
            WriteAndReadText.saveDataInFileWithAllCustomerInfo("All_Customer2", customer);

            List<Customer> actualCustomerList = WriteAndReadText.returnAWholeCostumer("All_Customer2");


            List<Customer> expectedList = new ArrayList<>();

            Customer customerInfo = new Customer("43703", "Alda", "Monahan", "Nichelle Hermann Kohler", "com.github.javafaker.Name@7c011174@gmail.com",
                    "909-162-8114", "231-501-9849", "67321", "I live in St louis MO", "St Louis", "108-53-6655", "0211-09-09T05:50:36Z",
                    false, null, "", null, "null");
            expectedList.add(customerInfo);
          //  System.out.println(expectedList);


            Customer customerInfo2 = new Customer("43707", "Ariel", "Lockman", "Kyla Jacobson Leannon I", "com.github.javafaker.Name@7c011174@gmail.com",
                    "539-783-3603", "277-718-1185", "67321", "I live in St louis MO", "St Louis", "224-71-4004", "0211-09-09T05:50:36Z",
                    false, null, "", null, "null");
            expectedList.add(customerInfo2);
          //    System.out.println(expectedList);


            Customer customerInfo3 = new Customer("61033", "Ricardo", "Mraz", "K", "RicardoMraz@gmail.com",
                    "468-534-3127", "496-514-2808", "02316", "33977 Jerrold Underpass",
                    "New Justin", "612-28-5133", "null", true, null, "", null, "null");

            expectedList.add(customerInfo3);
          //   System.out.println(expectedList);


            Customer customerInfo4 = new Customer("61032", "Lesley", "King", "K", "LesleyKing@gmail.com",
                    "086-377-3814", "252-446-5912", "73710", "32564 Willms Bypass", "Fionaside",
                    "049-43-2360", "null", false, null, "", null, "null");

            expectedList.add(customerInfo4);
          //  System.out.println(expectedList);

            Customer customerInfo5 = new Customer("42323", "Juan", "Breitenberg", "Arnoldo Huels Bergstrom",
                    "com.github.javafaker.Name@2a8a4e0c@gmail.com", "258-209-2899", "423-225-1771", "67321", "I live in St louis MO",
                    "St Louis", "246-59-3825", "2020-12-11T06:00:00Z", false, null, "", null, "null");

            expectedList.add(customerInfo5);
          //  System.out.println(expectedList);

            // negative
            Customer customerInfo6 = new Customer("101010", "Sibel", "Breitenberg", "Arnoldo Huels Bergstrom",
                    "com.github.javafaker.Name@2a8a4e0c@gmail.com", "258-209-2899", "423-225-1771", "67321", "I live in St louis MO",
                    "St Louis", "246-59-3825", "2020-12-11T06:00:00Z", false, null, "", null, "null");

            expectedList.add(customerInfo6);



            for (int j = 0; j < expectedList.size(); j++) {

                for (Customer each : actualCustomerList) {
                    if (each.getId().contains(expectedList.get(j).getId())) {

                        Assert.assertTrue(each.getFirstName().contains(expectedList.get(j).getFirstName()));
                        Assert.assertTrue(each.getLastName().contains(expectedList.get(j).getLastName()));
                        Assert.assertTrue(each.getMiddleInitial().contains(expectedList.get(j).getMiddleInitial()));
                        Assert.assertTrue(each.getEmail().contains(expectedList.get(j).getEmail()));
                        Assert.assertTrue(each.getMobilePhoneNumber().contains(expectedList.get(j).getMobilePhoneNumber()));
                        Assert.assertTrue(each.getPhoneNumber().contains(expectedList.get(j).getPhoneNumber()));
                        Assert.assertTrue(each.getZipCode().contains(expectedList.get(j).getZipCode()));
                        Assert.assertTrue(each.getAddress().contains(expectedList.get(j).getAddress()));
                        Assert.assertTrue(each.getCity().contains(expectedList.get(j).getCity()));
                        Assert.assertTrue(each.getSsn().contains(expectedList.get(j).getSsn()));
                        Assert.assertTrue(each.getCreateDate().contains(expectedList.get(j).getCreateDate()));
                        //  Assert.assertTrue(each.isZelleEnrolled().contains(expectedList.get(0).isZelleEnrolled()));
                        // Assert.assertTrue(each.getCountry().contains(expectedList.get(0).getCountry()));
                        Assert.assertTrue(each.getState().contains(expectedList.get(j).getState()));
                        //   Assert.assertTrue(each.getUser().contains(expectedList.get(0).getUser()));
                        Assert.assertTrue(each.getAccounts().contains(expectedList.get(j).getAccounts()));

                        System.out.println(expectedList);
                    }
                }
            }
        }
    @Given("read customer data using with api endpoint <{string}>")
    public void readCustomerDataUsingWithApiEndpoint(String api_endpoint_id) {
        response = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
           //     .param("size", 2000)
                .when()
                .get(api_endpoint_id)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();
    }

    @Then("validate customer by id")
    public void validateCustomerById() throws IOException {

        JsonPath json=response.jsonPath();

        Assert.assertTrue(json.getString("id").contains("42323"));
        Assert.assertTrue(json.getString("firstName").contains("Juan"));
        Assert.assertTrue(json.getString("lastName").contains("Breitenberg"));
        Assert.assertTrue(json.getString("middleInitial").contains("Arnoldo Huels Bergstrom"));
        Assert.assertTrue(json.getString("email").contains("com.github.javafaker.Name@2a8a4e0c@gmail.com"));
        Assert.assertTrue(json.getString("mobilePhoneNumber").contains("258-209-2899"));
        Assert.assertTrue(json.getString("phoneNumber").contains("423-225-1771"));
        Assert.assertTrue(json.getString("zipCode").contains("67321"));
        Assert.assertTrue(json.getString("address").contains("I live in St louis MO"));
        Assert.assertTrue(json.getString("city").contains("St Louis"));
        Assert.assertTrue(json.getString("ssn").contains("246-59-3825"));
        Assert.assertTrue(json.getString("createDate").contains("2020-12-11T06:00:00Z"));
        Assert.assertEquals(false,json.getBoolean("zelleEnrolled"));
//        Assert.assertTrue(json.getString("country").contains("null"));
        Assert.assertTrue(json.getString("state").contains(""));
//        Assert.assertTrue(json.getString("user").contains("null"));
//        Assert.assertTrue(json.getString("accounts").contains("null"));
        System.out.println("test pass");
    }
}









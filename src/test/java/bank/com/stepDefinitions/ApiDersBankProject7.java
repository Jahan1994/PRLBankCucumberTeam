package bank.com.stepDefinitions;

import bank.com.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiDersBankProject7 {


    @Given("real all customer data using with api endpoint {string}")
    public void real_all_customer_data_using_with_api_endpoint(String api_endpoint) {

        Response response= given().headers("Authorization",
                "Bearer"+ ConfigReader.getProperty("token"),
                "Content-Type", ContentType.JSON,"Accept",ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract().
                        response();

        response.prettyPrint();


    }

    @Then("validate customer data")
    public void validate_customer_data() {


    }
}

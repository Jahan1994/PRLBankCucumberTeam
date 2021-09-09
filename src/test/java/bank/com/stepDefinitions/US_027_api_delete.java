package bank.com.stepDefinitions;

import bank.com.pojos.States;
import bank.com.utilities.ConfigurationReader;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bank.com.jsonModels.StateJson.*;
import static io.restassured.RestAssured.*;


public class US_027_api_delete {

    Response response;
    int createdStateId;
    Response responseAll;
    String token;

    @Given("User should get a token as first step {string}")

    public void userFirstShouldGetATokenByUsingAPI(String tokenEndPoint) {

        // Automation ile token alma methodu


        String credentials = "{\n" +
                "    \"username\" : \"team18_customer\",\n" +
                "    \"password\" : \"Team18customer\",\n" +
                "    \"rememberMe\" : false\n" +
                "}";

        token = RestAssured.given().headers("Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .body(credentials)
                .post(tokenEndPoint)
                .then()
                .extract()
                .path("id_token");

        System.out.println("token: " + token);


    }
    @Then("User using api end point {string} create {string} and {string}")
    public void userUsingApiEndPointCreateAnd(String endpoint, String stateName, String id) {
        //map olusturduk
        Map<String, Object> putState = new HashMap<>();
        putState.put("name",stateName);

        response = given().headers("Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .body(putState)
                .post(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        createdStateId = jsonPath.getInt("id");

        System.out.println("===============================================");
        System.out.println(createdStateId);


    }

    @Then("User reads all states from end point {string}")
    public void usUserReadsAllStatesFromEndPoint(String string) throws IOException {


        responseAll = given().headers(
                        "Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON)
                .when()
                .get(string)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        responseAll.prettyPrint();
    }

    @Then("User verifies new state using {string}")
    public void userVerifiesStatesUsingAnd(String idJson) {


        JsonPath jsonPath = responseAll.jsonPath();
        // int id1= jsonPath.getInt("id"); string metohlarini kullanmak icin json.getString olarak cagirdik

        String id = jsonPath.getString("id");
        String stringCreatedStateId = String.valueOf(createdStateId);

        Assert.assertTrue("not contain", id.contains(stringCreatedStateId));
        System.out.println("Validation is succesfull");

    }

    @Then("user deletes a state using {string} and {string}")
    public void userDeletesAStateUsingAnd(String api_endpoint, String id) {

        response = given().headers("Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .delete(api_endpoint + id)
                .then()
                .extract()
                .response();
        response.prettyPrint();
        System.out.println(id);

    }


    @Then("User verifies new state deleted {string}")
    public void userVerifiesNewStateDeleteAnd(String id1) {

        responseAll = given().headers(
                        "Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON)
                .when()
                .get("https://gmibank-qa-environment.com/api/tp-states")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        responseAll.prettyPrint();

        JsonPath jsonPath = responseAll.jsonPath();
        // int id1= jsonPath.getInt("id"); string metohlarini kullanmak icin json.getString olarak cagirdik

        String id = jsonPath.getString("id");
        String stringCreatedStateId = String.valueOf(createdStateId);


        Assert.assertFalse("not contain", id.contains("59132"));
        System.out.println("Validation is succesfull");

    }

}
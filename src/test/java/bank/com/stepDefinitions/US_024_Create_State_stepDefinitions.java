package bank.com.stepDefinitions;

import bank.com.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static bank.com.jsonModels.StateJson.*;
import static io.restassured.RestAssured.*;


public class US_024_Create_State_stepDefinitions {

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


    @Given("User using api end point {string} create state")
    public void userUsingApiEndPointCreateState(String string) {

        response=given().headers("Authorization",
                "Bearer "+ token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
                .when()
                .body(CREATE_STATE8)
                .post(string)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        createdStateId=jsonPath.getInt("id");

        System.out.println("===============================================");
        System.out.println(createdStateId);


    }

    @Then("User reads all states from end pointt {string}")
    public void usUserReadsAllStatesFromEndPointt(String string) {


        responseAll=given().headers(
                "Authorization",
                "Bearer "+ token,
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

    @Then("User verifies new state using {string} and {string}")
    public void userVerifiesStatesUsingAnd(String idJson, String nameJson) {



        JsonPath jsonPath=responseAll.jsonPath();
       // int id1= jsonPath.getInt("id"); string metohlarini kullanmak icin json.getString olarak cagirdik

        String id= jsonPath.getString("id");
        String stringCreatedStateId = String.valueOf(createdStateId);

        Assert.assertTrue("not contain",id.contains(stringCreatedStateId));
        System.out.println("Validation is succesfull");



    }
























    @Then("User verifies new state creation")
    public void userVerifiesNewStates() {

//
//        JsonPath jsonPath1=responseAll.jsonPath();
//        JsonPath jsonPath2=response.jsonPath();
//
//        String stringIds=jsonPath2.getString("id");
//
//        String stringCreatedStateId=String.valueOf(createdStateId);
//
//        Assert.assertTrue("not contain",stringIds.contains(stringCreatedStateId));
//        System.out.println("validation is succesfull");



//        String stateName=jsonPath2.getString("name");
//        String stateNames=jsonPath1.getString("name");
//        Assert.assertTrue("verify",stateNames.contains(stateName));
//        System.out.println("**** new state can be added ****");

    }




}



/*
// Automation ile token alma methodu
// String token;

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

 */
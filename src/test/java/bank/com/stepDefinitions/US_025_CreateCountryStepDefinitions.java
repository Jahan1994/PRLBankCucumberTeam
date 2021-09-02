package bank.com.stepDefinitions;

import bank.com.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import static bank.com.jsonModels.CountryJson.createCountry;
import static io.restassured.RestAssured.given;

public class US_025_CreateCountryStepDefinitions {

    @Given("user sets the response using api end point {string} and creates country")
    public void userSetsTheResponseUsingApiEndPointAndCreatesCountry(String endpoint) {
        Response response = given().headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty("token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(createCountry)
                .post(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        response.prettyPrint();
    }

    @Then("user reads all countries from end point {string}")
    public void userReadsAllCountriesFromEndPoint(String endpoint) {
        Response responseAll = given().headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty("token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        responseAll.prettyPrint();
    }

    @Then("user asserts for new country")
    public void userAssertsForNewCountry() {
        Response response = null;
        Response responseAll =null;
        JsonPath jsonPath=responseAll.jsonPath();
        JsonPath jsonPath2=response.jsonPath();
        String countryName=jsonPath2.getString("name");
        String countryNames=jsonPath.getString("name");
        Assert.assertTrue("not verify",countryNames.contains(countryName));
        System.out.println("================Countries can be addded=================");
    }
}

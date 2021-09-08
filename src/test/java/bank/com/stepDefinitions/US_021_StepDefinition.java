package bank.com.stepDefinitions;

import bank.com.pojos.Country;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class US_021_StepDefinition {

    Response response;
    String token;
    int expectedId;

    Country [] countryArr;
    Faker faker = new Faker();




    @Given("User first should get a token by using API {string}")
    public void userFirstShouldGetATokenByUsingAPI(String tokenEndPoint) {
        String credentials = "{\n" +
                "    \"username\" : \"team18_customer\",\n" +
                "    \"password\" : \"Team18customer\",\n" +
                "    \"rememberMe\" : false\n" +
                "}";

        token = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(credentials)
                .post(tokenEndPoint)
                .then()
                .extract()
                .path("id_token");

        System.out.println("token: " + token);

    }

    @Then("User should read all country by using API  {string}")
    public void userShouldReadAllCountryByUsingAPI(String countryEndPoint) {



        countryArr = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .get(countryEndPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .as(Country[].class);


        
    }

    @And("User should validate a country")
    public void userShouldValidateACountry() {

        List<String> expectedCountryNames = new ArrayList<>();
        expectedCountryNames.add("USA");
        expectedCountryNames.add("Kenya");
        expectedCountryNames.add("Turkey");
        expectedCountryNames.add("FRANCE");


        List<String> actualCountryNames = new ArrayList<>();
        for (Country country : countryArr) {
            actualCountryNames.add(country.getName());
        }

        System.out.println(actualCountryNames);
        System.out.println(expectedCountryNames);


        Assert.assertTrue(actualCountryNames.containsAll(expectedCountryNames));


        System.out.println("=========================================");
    }


    @And("Read all country you created and validate them one by one using API {string}")
    public void readAllCountryYouCreatedAndValidateThemOneByOneUsingAPI(String ApiURL) {

        Map<String, Object> expectedCountry = new HashMap<>();
        expectedCountry.put("name", faker.address().country());
        expectedCountry.put("state", null);




        // CREATING STATE WITH POST REQUEST
        response = given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().body(expectedCountry).post(ApiURL);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        expectedId = jsonPath.getInt("id");




        // READING DATA WITH GET REQUEST
        response = given().
                accept(ContentType.JSON).
                auth().
                oauth2(token).
                get(ApiURL + "/" + expectedId).
                then().
                assertThat().
                body("name", equalTo(expectedCountry.get("name")),
                        "state", equalTo(null)).
                extract().
                response();

        response.prettyPrint();

        jsonPath = response.jsonPath();
        Assert.assertEquals(expectedCountry.get("name").toString(), jsonPath.getString("name"));
        Assert.assertEquals(expectedCountry.get("state"), jsonPath.get("state"));

    }
}





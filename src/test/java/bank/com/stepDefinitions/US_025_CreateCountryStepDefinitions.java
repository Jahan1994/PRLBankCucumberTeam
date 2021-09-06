package bank.com.stepDefinitions;

import bank.com.pojos.Country;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static bank.com.jsonModels.CountryJson.createCountry;
import static io.restassured.RestAssured.given;

public class
US_025_CreateCountryStepDefinitions {
    String token;
    Response response;
    Response responseAll;
    int createdCountryId;

   /*
    @Given("user should get a token by using API {string}")
    public void userShouldGetATokenByUsingAPI(String token) {
        String credentials = "{\n" +
                "    \"username\" : \"team18_customer\",\n" +
                "    \"password\" : \"Team18customer\",\n" +
                "    \"rememberMe\" : false\n" +
                "}";

        token = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(credentials)
                .post(token)
                .then()
                .extract()
                .path("id_token");

        System.out.println("token: " + token);
    }


    */
    @Then("user sets the response using api end point {string} and creates country")
    public void userSetsTheResponseUsingApiEndPointAndCreatesCountry(String endpoint) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty(token),
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

        //olusturulan country id
        JsonPath jsonPath = response.jsonPath();
        createdCountryId = jsonPath.getInt("id");
        System.out.println("=======================================================");
        System.out.println(createdCountryId);
    }

    @Then("user reads all countries from end point {string}")
    public void userReadsAllCountriesFromEndPoint(String endpoint) throws IOException {
         responseAll = given().headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty(token),
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

        // validate isleminde kullanmak icin tum ulke idlerini bir listin icine atalim
        List<String> countryId = new ArrayList<>();

        // objectmapper kullanarak deserilazition yapiyoruz
        ObjectMapper objectMapper = new ObjectMapper();
        Country[] country5 = objectMapper.readValue(response.asString(), Country[].class);

        // for dongusu ile tum country id lerini daha  once olusturdugumuz listin icine ekleyelim
        for (int i = 0; i < country5.length; i++) {
            countryId.add(String.valueOf(country5[i].getId()));
        }
        //Eger dosya bos degilse silmek icin
        File file = new File("countryId2");
        if (file != null) {
            file.delete();
        }
        // ulke idlerini txt olarak yazdiralim
        WriteToTxt.saveDataInFileWithCountryId("countryId2", country5);

        // txt olarak yazdirdigimiz idleri readtxt uzerinden okutalim
        List<String> readId = ReadTxt.returnCountryIdListesi("countryId2");

        // validasyon
        Assert.assertEquals("mot match", countryId, readId);
        System.out.println("Validation is succesfull");

    }

    @Then("user asserts for new country")
    public void userAssertsForNewCountry() throws IOException {
        response = given().headers("Authorization",
                        "Bearer " + ConfigReader.getProperty(token),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .get("https://www.gmibank.com/api/tp-countries")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        String stringIds = jsonPath.getString("id");

        String stringCreatedCountryId = String.valueOf(createdCountryId);

        Assert.assertTrue("not contain", stringIds.contains(stringCreatedCountryId));
        System.out.println("Validation is succesfull");

    }

}


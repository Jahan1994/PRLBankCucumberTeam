package bank.com.stepDefinitions;

import bank.com.pojos.Country;
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

    Response response;
    Response responseAll;
    int createdCountryId;
    String token;

    @Given("user should get a token by using API {string}")
    public void userShouldGetATokenByUsingAPI(String endtoken) {
        String credentials = "{\n" +
                "    \"username\" : \"team18_customer\",\n" +
                "    \"password\" : \"Team18customer\",\n" +
                "    \"rememberMe\" : false\n" +
                "}";

        token = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(credentials)
                .post(endtoken)
                .then()
                .extract()
                .path("id_token");

        System.out.println("token: " + token);
    }

    @Then("user reads all countries from end point {string}")
    public void userReadsAllCountriesFromEndPoint(String endpoint) throws IOException {
        responseAll = given().headers(
                        "Authorization",
                        "Bearer " + token,
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
        Country[] country = objectMapper.readValue(response.asString(), Country[].class);

        // for dongusu ile tum country id lerini daha  once olusturdugumuz listin icine ekleyelim
        for (int i = 0; i < country.length; i++) {
            countryId.add(String.valueOf(country[i].getId()));
        }
        //Eger dosya bos degilse silmek icin
        File file = new File("countryId2");
        if (file != null) {
            file.delete();
        }
        // ulke idlerini txt olarak yazdiralim
        WriteToTxt.saveDataInFileWithCountry5Id("countryId2", country);

        // txt olarak yazdirdigimiz idleri readtxt uzerinden okutalim
        List<String> readId = ReadTxt.returnCountryIdListesi("countryId2");

        // validasyon
        Assert.assertEquals("mot match", countryId, readId);
        System.out.println("Validation is succesfull");

    }

    @Then("user sets the response using api end point {string} and creates country")
    public void userSetsTheResponseUsingApiEndPointAndCreatesCountry(String endpoint) {
        response = given().headers("Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .body(createCountry)
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

    @Then("user asserts for new country")
    public void userAssertsForNewCountry() throws IOException {
        response = given().headers("Authorization",
                        "Bearer " + token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .get("https://gmibank-qa-environment.com/api/tp-countries")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        String stringIds = jsonPath.getString("id");
        System.out.println("stringIds = " + stringIds);

        String stringCreatedCountryId = String.valueOf(createdCountryId);
        System.out.println("stringCreatedCountryId = " + stringCreatedCountryId);

        Assert.assertTrue("not contain", stringIds.contains("21196"));
        System.out.println("Validation is succesfull");
        System.out.println("stringCreatedCountryId :" + stringCreatedCountryId);
    }

}


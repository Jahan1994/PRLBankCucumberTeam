package bank.com.stepDefinitions;


import bank.com.pojos.Registration;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US_023_StepDefinition {

    Response response;
    String token;
    Faker faker = new Faker();
    int expectedId;
    @Given("user takes a token by using api {string}")
    public void userTakesATokenByUsingApi(String tokenEndPoint) {
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

    @Given("read all registration data using with api endpoint {string}")
    public void read_all_registration_data_using_with_api_endpoint(String api_endpoint) {
        response = given().headers("Authorization", "Bearer " + token,
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        response.prettyPrint();

    }

    @Then("validate registration data")
    public void validate_registration_data() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Registration[] registrations = objectMapper.readValue(response.asString(), Registration[].class);


        List<String> actualIdList = new ArrayList<>();
        for (int i = 0; i < registrations.length; i++) {
            actualIdList.add(registrations[i].getSsn());
        }
        List<String> expectedIdList = new ArrayList<>();
        expectedIdList.add("456-87-9876");
        expectedIdList.add("432-67-1234");
        expectedIdList.add("231-43-6587");
        expectedIdList.add("654-97-3210");
        expectedIdList.add("123-43-4312");

        Assert.assertTrue(actualIdList.containsAll(expectedIdList));

    }


    @Given("Read all registration you created and validate them one by one using API {string}")
    public void readAllRegistrationYouCreatedAndValidateThemOneByOneUsingAPI(String api_url) {


        Map<Object, Object> expectedRegistration = new HashMap<>();

        expectedRegistration.put("ssn", faker.number().digit());
        expectedRegistration.put("firstName", faker.name().firstName());
        expectedRegistration.put("lastName", faker.name().lastName());
        expectedRegistration.put("address", faker.address().city());
        expectedRegistration.put("mobilePhoneNumber", faker.phoneNumber().phoneNumber());
        expectedRegistration.put("userId", faker.number().digit());
        expectedRegistration.put("userName", faker.name().username());
        expectedRegistration.put("email", faker.internet().emailAddress());
        expectedRegistration.put("createDate", null);




//create reg
        response = given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().body(expectedRegistration).post(api_url);
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        int expectedId = jsonPath.getInt("id");


        response = given().headers("Authorization", "Bearer " + token,
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
        response.prettyPrint();


        Assert.assertEquals(expectedRegistration.get("ssn"), jsonPath.getString("ssn"));
        Assert.assertEquals(expectedRegistration.get("firstName"), jsonPath.getString("firstName"));
        Assert.assertEquals(expectedRegistration.get("lastName"), jsonPath.getString("lastName"));
        Assert.assertEquals(expectedRegistration.get("address"), jsonPath.getString("address"));
        Assert.assertEquals(expectedRegistration.get("mobilePhoneNumber"), jsonPath.getString("mobilePhoneNumber"));
        Assert.assertEquals(expectedRegistration.get("userId"), jsonPath.getString("userId"));
        Assert.assertEquals(expectedRegistration.get("userName"), jsonPath.getString("userName"));
        Assert.assertEquals(expectedRegistration.get("email"), jsonPath.getString("email"));
        Assert.assertEquals(expectedRegistration.get("createDate"), jsonPath.getString("createDate"));


    }
}


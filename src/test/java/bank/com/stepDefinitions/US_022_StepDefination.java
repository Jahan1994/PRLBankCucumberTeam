package bank.com.stepDefinitions;


import bank.com.pojos.State;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bank.com.jsonModels.StateJson.CREATE_STATE;
import static bank.com.jsonModels.StateJson.CREATE_STATE16;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class US_022_StepDefination {

    Response response;
    String token;
    State[] statesArr;
    int expectedId;
    Faker faker = new Faker();


    @Given("User first should get a token by using Api_ {string}")
    public void userFirstShouldGetATokenByUsingAPIs(String tokenEndPoint) {
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

    @Then("User should read all states by using API  {string}")
    public void userShouldReadAllStatesByUsungAPI(String stateEndPoint) {
        statesArr = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .get(stateEndPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .as(State[].class);

//        response = given().headers("Authorization",
//                "Beares" + token, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
//                .when().get(stateEndPoint).then().contentType(ContentType.JSON).extract().response();
//        response.prettyPrint();

//        ObjectMapper objectMapper = new ObjectMapper();
//        State[] state = objectMapper.readValue(response.asString(), State[].class);

    }


    @And("User should validate a state")
    public void userShouldValidateAState() throws IOException {


        List<String> expectedStateNames = new ArrayList<>();
        expectedStateNames.add("California");
        expectedStateNames.add("Trabzon");
        expectedStateNames.add("Virginia");


        List<String> actualStateNames = new ArrayList<>();
        for (State state : statesArr) {
            actualStateNames.add(state.getName());
        }

        System.out.println(actualStateNames);
        System.out.println(expectedStateNames);


        Assert.assertTrue(actualStateNames.containsAll(expectedStateNames));


        System.out.println("=========================================");
    }


    @And("Read all states you created and validate them one by one using API {string}")
    public void readAllStatesYouCreatedAndValidateThemOneByOneUsingAPI(String ApiURL) {


        Map<String, Object> expectedState = new HashMap<>();
        expectedState.put("name", faker.address().state());
        expectedState.put("tpcountry", null);

        //State expectedState = new State(faker.address().state(),null);


        // CREATING STATE WITH POST REQUEST
        response = given().headers("Authorization", "Bearer " + token,
                "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().body(expectedState).post(ApiURL);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        expectedId = jsonPath.getInt("id");


        //State expectedState = new State(expectedId,expectedName,null);

        // READING DATA WITH GET REQUEST
        response = given().
                accept(ContentType.JSON).
                auth().
                oauth2(token).
                get(ApiURL + "/" + expectedId).
                then().
                assertThat().
                body("name", equalTo(expectedState.get("name")),
                        "tpcountry", equalTo(null)).
                extract().
                response();

        response.prettyPrint();

//        jsonPath = response.jsonPath();
//        Assert.assertEquals(expectedState.get("name").toString(), jsonPath.getString("name"));
//        Assert.assertEquals(expectedState.get("tpcountry"), jsonPath.get("tpcountry"));

    }
}
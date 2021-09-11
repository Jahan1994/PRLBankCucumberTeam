package bank.com.stepDefinitions;



import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

import bank.com.pages.US_009Page;
import bank.com.pojos.Country;

import static bank.com.utilities.ApiUtility.*;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static bank.com.jsonModels.CountryJson.createCountry;
import static bank.com.utilities.DatabaseUtility.createConnection;
import static bank.com.utilities.DatabaseUtility.getColumnData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class US_026_API_Update_CountryStepDefinitions {

    /*
    1 - UI'dan Customer olusturup API'dan validation
        2 - API'dan Country olusturup UI'dan validation
        3 - DB'den Customer olusturup UI'dan validation
        4 - API'dan State olusturup DB'den validation
     */
    US_009Page us_009Page=new US_009Page();
    Response response;
    Response responseNew;
   // String bearerToken = ConfigurationReader.getProperty("api_bearer_token");
    int createdCountryId;
    String updatedCountryName;
    Response responseAll;
    String token;

    //Bu method ile otomatik olarak token aliniyor. Guzel bir method
    @Given("user should first get a bearer token with end point {string}")
    public void userShouldFirstGetABearerTokenWithEndPoint(String tokenEndPoint) {
        String username = "team53employee";
        String password = "Team53employee.";
        takeToken(username, password, tokenEndPoint);

    }


    @Given("user reads all countries and write country ids to txt using api endpoint {string}")
    public void userReadsAllCountriesAndWriteCountryIdsToTxtUsingApiEndpoint(String api_url) throws IOException {

        //ApiUtility icerisinde static kod olusturup ordan cagirdim
        response = getWithApiEndPoint(api_url);
      response.prettyPrint();


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
         File file = new File("src\\test\\resources\\test_data\\countryNameAndIdFromAPI.txt");
        if (file != null) {
            file.delete();
        }
        // ulke idlerini txt olarak yazdiralim
        WriteToTxt.saveDataInFileWithCountry5Id("src\\test\\resources\\test_data\\countryIdFromAPI.txt", country5);

        //id ve name ile write
        WriteToTxt.saveDataInFileWithCountryIdAndName("src\\test\\resources\\test_data\\countryIdANDNameFromAPI.txt", country5);

        // txt olarak yazdirdigimiz idleri readtxt uzerinden okutalim
       List<String> readId = ReadTxt.returnCountry5IdList("src\\test\\resources\\test_data\\countryIdFromAPI.txt");

        // validasyon
       Assert.assertEquals("mot match", countryId, readId);
        System.out.println("Validation is succesfull");

    }

    // ============================  create all countries =================================

    @And("user creates an country {string}")
    public void userCreatesAnCountry(String api_url) {
        response = createWithApiEndPoint(createCountry, api_url);
        response.prettyPrint();

        //olusturulan country id
        JsonPath jsonPath = response.jsonPath();
        createdCountryId = jsonPath.getInt("id");
        System.out.println("=======================================================");
        System.out.println(createdCountryId);

    }

    // ============================  validate created country =================================
    @Then("user validates this created new country")
    public void userValidatesThisCreatedNewCountry() {

        System.out.println(createdCountryId);
        String api_url= "https://gmibank-qa-environment.com/api/tp-countries";
        response = getWithApiEndPoint(api_url);

        JsonPath jsonPath = response.jsonPath();
        String stringIds = jsonPath.getString("id");
        System.out.println(stringIds);

        String stringCreatedCountryId = String.valueOf(createdCountryId);

        Assert.assertTrue("not contain", stringIds.contains(stringCreatedCountryId));
        System.out.println("Validation is succesfull");
        System.out.println(stringCreatedCountryId);


    }

    @Given("user update a country using api end point {string}  {string} and its extension {string}")
    public void userUpdateACountryUsingApiEndPointAndItsExtension(String api_url, String name, String id) throws IOException {

        //map olusturduk
        Map<String, Object> putCountry = new HashMap<>();
       putCountry.put("id", id);
        putCountry.put("name",name);
        putCountry.put("states", null);

        responseNew = updateWithApiEndPoint(api_url,putCountry);
        responseNew.prettyPrint();

//        JsonPath jsonPath = responseNew.jsonPath();
//        String stringNames = jsonPath.getString("name");
////        id = String.valueOf(createdCountryId);
//       updatedCountryName=name;
//        Assert.assertTrue("not contain", stringNames.contains(name));
//        System.out.println("Validation is succesfull voor id " + id + " with " + name);

//        //3.Way: By using body()
//        responseNew.
//                then().
//                assertThat().
//                statusCode(200).
//                body("id", equalTo("21183"),
//                        "name", equalTo(name));
    }
    @And("user validates this updated country with Api end point {string} {string} and its extension {string}")
    public void userValidatesThisUpdatedCountryWithApiEndPointAndItsExtension(String api_url, String name, String id) throws IOException {
        responseNew= getWithApiEndPoint(api_url);
        responseNew.prettyPrint();

        //Json path ile dogrulama
       JsonPath jsonPath = responseNew.jsonPath();
       String stringNames = jsonPath.getString("name");
       System.out.println(stringNames);
       String idNames = jsonPath.getString("id");
       updatedCountryName=name;
       createdCountryId= Integer.parseInt(id);
       // this.updatedCountryName= name;
       Assert.assertTrue("not contain", stringNames.contains(updatedCountryName));
         System.out.println("Validation is succesfull voor id " + createdCountryId + " with " + updatedCountryName);
        //En son calisani yazdirir.
        Assert.assertTrue("not contain", stringNames.contains(jsonPath.getString("name[-1]")));
        Assert.assertEquals("not contain", jsonPath.getString("name[-1]"), updatedCountryName);
        System.out.println(jsonPath.getString("name[-1]"));

        //================================================================
        ObjectMapper objectMapper = new ObjectMapper();
        Country[] country5 = objectMapper.readValue(responseNew.asString(), Country[].class);

       //    response.prettyPrint();
        // validate isleminde kullanmak icin tum ulke idlerini bir listin icine atalim
        List<String> countryId = new ArrayList<>();
        // objectmapper kullanarak deserilazition yapiyoruz. bBurada GSON da kullanilabilirdi.
//        ObjectMapper objectMapper = new ObjectMapper();
//        Country[] country5 = objectMapper.readValue(response.asString(), Country[].class);

        // for dongusu ile tum country id lerini daha  once olusturdugumuz listin icine ekleyelim
        for (int i = 0; i < country5.length; i++) {
            countryId.add(String.valueOf(country5[i].getId()));
        }

        //Eger dosya bos degilse silmek icin
        File file = new File("src\\test\\resources\\test_data\\countryNameAndIdFromAPI.txt");
        if (file != null) {
            file.delete();
        }
        //id ve name ile write
        WriteToTxt.saveDataInFileWithCountryIdAndName("src\\test\\resources\\test_data\\countryIdANDNameFromAPI.txt", country5);

 //==============================================================================

         //===BURAYA CALIS====
       //map yapmaya calistim ama olmadi Integer hatasi veriyor.=>NumberFormatException: For input string: "22347 "
        //Cozuldu
        Map<String, Object> expectedDataMap= new HashMap<>();
        List<String> list1 = ReadTxt.returnCountryIdNameList("src\\test\\resources\\test_data\\countryIdANDNameFromAPI.txt");
        //Map list kullanarak ekleme yaptim
       //sonMap.put(list1.get(0), list1.get(1));
        for (int i = 1; i < list1.size()-1 ; i++) {
            if(i%2 ==1) {
                expectedDataMap.put(list1.get(i-1), list1.get(i));
            }
        }

        //Map tum elemanlari okuma ==> for each ile
        for (Map.Entry<String, Object> entry : expectedDataMap.entrySet()) {
          System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
       // System.out.println(expectedDataMap.containsValue("Updated ULKE")); //true
      //  System.out.println(expectedDataMap.get("21156"));


        Assert.assertEquals("not equal", expectedDataMap.get("21184"), updatedCountryName);
        System.out.println("succesfully");
//        Assert.assertEquals("not equal", expectedDataMap.get("21156"), actualDataMap.get("21156"));


//        //liste olusturduk ==> burada name ve id yazdrimistim name cagirip bakacam
//        List<Country5> countryIdandName = ReadTxt.returnCountryIdNameList("src\\test\\resources\\test_data\\countryIdANDNameFromAPI.txt");
//        System.out.println(countryIdandName.get(countryIdandName.size()-1).getName());
//        String updatedCountry = countryIdandName.get(countryIdandName.size()-1).getName();
//        Assert.assertEquals("not equal", updatedCountry, updatedCountryName);

    }


    @Then("user validates this updated country with UI {string}")
    public void userValidatesThisUpdatedCountryWithUI(String countryName) throws InterruptedException {
        Select select = new Select(us_009Page.countryList);
        select.selectByVisibleText(countryName);
        Thread.sleep(3000);

     //Tum country leri listeye alip burada assert etmeliyim.
        //1. yol
        List<WebElement> allCountriesFromUI = select.getOptions();

        //Tum elemanlari yazdirmak icin
//        for (WebElement w : allCountriesFromUI) {
//            System.out.println(w.getText());
//        }
        //2. yol==>//tum dropdownu yazdirir
        //  System.out.println(us_009Page.countryList.getText());
        //=== Dropdown’un boyutu===
        //  System.out.println("dropdown daki web elementlerinin sayisi : " + tumOpsiyonlar.size());
        System.out.println(updatedCountryName);
        System.out.println(allCountriesFromUI.get(allCountriesFromUI.size()-1).getText());
        Assert.assertEquals("country name doesnt exist",countryName, allCountriesFromUI.get(allCountriesFromUI.size()-1).getText());

    }


    List<Object> objectList;

    @Given("user creates a connection with db using {string} , {string} and {string}")
    public void userCreatesAConnectionWithDbUsingAnd(String url, String user, String password) {
        createConnection(url, user, password);
    }

    @And("user updates a country data by using {string} and {string}")
    public void userUpdatesACountryDataByUsingAnd(String query, String id) {
        objectList = getColumnData(query,id);
        System.out.println(objectList.toString());
    }

    @Then("user validates this updated country with Database")
    public void userValidatesThisUpdatedCountryWithDatabase() {
        Assert.assertTrue(objectList.contains(24106));
        System.out.println("====================================================");
        System.out.println("Validation is succesfull");
    }

}


/*

    @Then("read all countries and write country ids to txt using api endpoint {string}")
    public void readAllCountriesAndWriteCountryIdsToTxtUsingApiEndpoint(String arg0) {
    }

    @And("create country {string}")
    public void createCountry(String arg0) {
    }

    @Then("validate created a country")
    public void validateCreatedACountry() {
    }

    @Given("delete updated a country using endpoint {string} and its extension {string} and validate")
    public void deleteUpdatedACountryUsingEndpointAndItsExtensionAndValidate(String arg0, String arg1) {
    }
 */

/*

import bank.com.pojos.Country;
import bank.com.pojos.Customer;
import bank.com.utilities.ConfigReader;
import bank.com.utilities.ReadTxt;
import bank.com.utilities.WriteToTxt;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bank.com.jsonModels.CountryJson.createCountry;
import static io.restassured.RestAssured.given;

public class ApiTest_Ders_CountryStepDef {

    Response response;
    String bearerToken = ConfigReader.getProperty("api_bearer_token");
    int createdCountryId;


    @Then("read all countries and write country ids to txt using api endpoint {string}")
    public void read_all_countries_and_write_country_ids_to_txt_using_api_endpoint(String api_url) throws IOException, IOException {

        response = given().headers("Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .get(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        // validate isleminde kullanmak icin tum ulke idlerini bir listin icine atalim

        List<String> countryId = new ArrayList<>();

        // objectmapper kullanarak deserilazition yapiyoruz

        ObjectMapper objectMapper = new ObjectMapper();

        Country[] country = objectMapper.readValue(response.asString(), Country[].class);

        // for dongusu ile tum country id lerini daha  once olusturdugumuz listin icine ekleyelim

        for (int i = 0; i < country.length; i++) {
            countryId.add(String.valueOf(country[i].getId()));
        }
        //Write ==>"countryId2 isimli bir dosya olusturdu
        WriteToTxt.saveDataInFileWithCountry5Id("countryId2",country);

        //Read
        List<String> readId= ReadTxt.returnCountry5IdList("countryId2");

        //validation
        Assert.assertEquals("not match", countryId, readId);
    }

    @And("create country {string}")
    public void createCountry(String api_url) {

        response = given().headers("Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .body(createCountry)
                .post(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        createdCountryId=jsonPath.getInt("id");
        System.out.println(createdCountryId);
    }

    //===========validate created country====
    @Then("validate created a country")
    public void validateCreatedACountry() {

        response = given().headers("Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .get("https://www.gmibank.com/api/tp-countries")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        //Butun id leri cekecegiz.
        JsonPath jsonPath =response.jsonPath();

        String stringIds = jsonPath.getString("id");

        //burada int olan createdCountryId'yi String cevirdik
        String stringCreatedCountryId = String.valueOf(createdCountryId);

        Assert.assertTrue("not contain", stringIds.contains(stringCreatedCountryId));
        System.out.println("Validation successful");


    }

    @And("update created a country using api end point {string}  {string} and its extension {string}")
    public void updateCreatedACountryUsingApiEndPointAndItsExtension(String api_url, String name, String id) {

        //map olusturduk
        Map<String, Object> putCountry = new HashMap<>();

        putCountry.put("id", id);
        putCountry.put("name",name);
        putCountry.put("states", null);

        response = given().headers("Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .body(putCountry)
                .put(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();
    }

    @Given("delete updated a country using endpoint {string} and its extension {string} and validate")
    public void deleteUpdatedACountryUsingEndpointAndItsExtensionAndValidate(String api_url, String id) {
        response = given().headers("Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .delete(api_url+id)
                .then()
                .extract()
                .response();

        //silinmeden sonrraki iresponse almak icin get yaptik bir daha
       Response responseNew = given().headers("Authorization",
                "Bearer " + bearerToken,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
               .get(api_url)
               .then()
               .contentType(ContentType.JSON)
               .extract()
               .response();

       JsonPath jsonPath = responseNew.jsonPath();
       String ids =jsonPath.getString("id");

       //id feature icinde String olarak tanimlanmisti
       Assert.assertFalse("not delete", ids.contains(id));
        System.out.println("valiation is succesfull");
    }
}
 */
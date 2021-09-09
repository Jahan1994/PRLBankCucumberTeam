package bank.com.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static bank.com.jsonModels.CountryJson.createCountry;
import java.util.HashMap;

public class ApiUtility {

    static Response response;
    private static String token;

    //===== Bu metod ile otomatik olarak TOKEN alinabilir.======//
    public static void takeToken(String username, String password, String tokenEndPoint) {
        String credentials = "{\"username\" : \""+ username + "\",\n" +
                "\"password\" : \""+ password + "\",\n" +
                "\"rememberMe\" : false}";
        token = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .body(credentials)
                .post(tokenEndPoint)
                .then()
                .extract()
                .path("id_token");
        System.out.println("token: " +token);

    }
                        //====READ metodu=====//
    public static Response getWithApiEndPoint(String api_endpoint) {
        response = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(api_endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        return response;
    }

    // ============================CREATE METODU =================================

    public static Response createWithApiEndPoint(String createdBody, String api_url) {
        response = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .body(createdBody) // this comes from JsonModels class for Country and States
                .post(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        return response;

    }

    // ============================  UPDATE metodu =================================
    public static Response updateWithApiEndPoint(String api_url, Map<String, Object> updateBody) {
        //bu ornege uygun bir Map olusturulabilir.
//        Map<String, Object> updateBody = new HashMap<>();
//        updateBody.put("id", id);
//        updateBody.put("name",name);
//        updateBody.put("states", null);

        response = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .body(updateBody) //buraya update edilecek kisma gore MAP formatindda data girilebilir.Uts kisimda ornegi var.
                .put(api_url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        return response;

    }

    // ============================  DELETE METODU=================================
    //EndPointin sonuna veya id onune "/"  isareti koymaya gerek yok bu metodda
    // ==>api_url + "/"+ id boyle yeterli
    public static Response deleteWithApiEndPoint(String api_url, String id) {
        response = given().headers("Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept", ContentType.JSON)
                .when()
                .delete(api_url + "/"+ id) //api_url + "/"+ id ==> araya / konuldu.
                .then()
                .extract()
                .response();
        return response;
    }

}


package Practice;

import frameWork.RestUtils;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RetrievingValueFromResponseBody extends RestUtils {
    static JsonPath j;

    public static void main(String[] args) {
        payLoad p = new payLoad();
        baseURI = "https://rahulshettyacademy.com";
        String response = given()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                //directly passing request payload body as a string
                .body(p.AddPlace())
                .when()
                .post("maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", equalTo("Apache/2.4.52 (Ubuntu)"))
                .extract().response().asString();

        System.out.println(response);
        String status = getStringValueFromResponse(response, "status");
        String placeID = getStringValueFromResponse(response, "place_id");

        System.out.println("Status is " + status + " and the Place id is " + placeID);


        System.out.println("****************** PutRequest ********************");

        String newAddress = "Budharaopet";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"place_id\":\"" + placeID + "\",\r\n" +
                        "\"address\":\"" + newAddress + "\",\r\n" +
                        "\"key\":\"qaclick123\"\r\n" +
                        "}").
                when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        System.out.println("************** get ******************");

        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeID)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        String ActualAddress = getStringValueFromResponse(getPlaceResponse, "address");
        Assert.assertEquals(ActualAddress, newAddress);
    }
}

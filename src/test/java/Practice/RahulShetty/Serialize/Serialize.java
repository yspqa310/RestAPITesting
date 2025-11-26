package Practice.RahulShetty.Serialize;

import Practice.RahulShetty.Jsonpath;
import frameWork.RestUtils;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class Serialize extends RestUtils {
    public static void main(String[] args) {
        AddPlacePOJO apj = new AddPlacePOJO();
        apj.setAccuracy(50);
        apj.setAddress("29, side layout, cohen 09");
        apj.setLanguage("French-IN");
        apj.setName("Frontline house");
        apj.setWebsite("http://google.com");
        apj.setPhone_number("(+91) 983 893 3937");

        ArrayList<String> typesList = new ArrayList<>();
        typesList.add("shoe park");
        typesList.add("shop");

        apj.setTypes(typesList);

        locationPojo lpj = new locationPojo();
        lpj.setLat(-38.383494);
        lpj.setLng(33.427362);

        apj.setLocation(lpj);

        baseURI = "https://rahulshettyacademy.com";
        response = given().queryParam("key", "qaclick123")
                .body(apj).log().all()
                .when().post("/maps/api/place/add/json")
                .then().log().all().extract().response();
        Assert.assertEquals(getStringValueFromResponse("scope"),"APP");

    }
}

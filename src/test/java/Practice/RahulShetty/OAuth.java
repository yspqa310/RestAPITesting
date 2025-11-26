package Practice.RahulShetty;

import static io.restassured.RestAssured.*;

import frameWork.RestUtils;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class OAuth extends RestUtils {


    public static void main(String[] args) {
        AccessToken();
        oAuthTest();
    }

    static String AccessToken;

    @Test(priority = 1)
    public static String AccessToken() {
        baseURI = "https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";
        String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("grant_type", "client_credentials")
                .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParam("scope", "trust")
                .log().all()
                .when().post()
                .then().log().all().extract().response().asString();
        AccessToken = getStringValueFromResponse(response, "access_token");
        System.out.println(AccessToken);
        return AccessToken;
    }
    @Test(priority = 2)
    public static void oAuthTest() {
        String resp=
                given().param("access_token", AccessToken)
                .log().all()
                .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .then().log().all().extract().response().asString();
        System.out.println(resp);
        Assert.assertEquals(getStringValueFromResponse(resp,"instructor"),"RahulShetty");

    }
}

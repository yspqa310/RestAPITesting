package Practice.RahulShetty.DeserialPOJOClass;

import org.testng.annotations.Test;

import java.util.List;

import static frameWork.RestUtils.getStringValueFromResponse;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Deserialize {
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
        Object_POJO resp = given()
                .param("access_token", AccessToken)
                .when()
                .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
                .as(Object_POJO.class);
        System.out.println(resp.getLinkedIn());
        System.out.println(resp.getCourses().getWebAutomation().get(1).getCourseTitle());
        List<api_POJO> apiList = resp.getCourses().getApi();
        for (int i = 0; i < apiList.size(); i++) {
            System.out.println(apiList.get(i).getCourseTitle());
            System.out.println(apiList.get(i).getPrice());
        }
    }
}

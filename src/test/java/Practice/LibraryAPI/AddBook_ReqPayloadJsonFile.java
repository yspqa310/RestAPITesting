package Practice.LibraryAPI;

import static io.restassured.RestAssured.*;

import frameWork.RestUtils;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddBook_ReqPayloadJsonFile extends RestUtils {

  /*  Converting Static Json file as a new String and using it in the body()
    As Request payload */
    static JsonPath js;
    @Test
    public static void addBooks() throws IOException {
        baseURI = "http://216.10.245.166";
        responseText = given().log().all()
                .header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\yspqa\\OneDrive\\Desktop\\REST_API_Testing\\RestApiTesting" +
                        "\\src\\test\\resources\\AddLibraryAPI.json"))))
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(200).log().all().extract().response().asString();
        js = stringToJson();
        String message = js.getString("Msg");
        String ID = js.getString("ID");
        Assert.assertEquals(message, "successfully added");
        System.out.println("Id is :" + ID);
    }
}

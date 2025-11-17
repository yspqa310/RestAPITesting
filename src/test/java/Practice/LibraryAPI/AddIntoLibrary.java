package Practice.LibraryAPI;

import frameWork.RestUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddIntoLibrary extends RestUtils {
    static AddLibraryPayLoad ad = new AddLibraryPayLoad();
    static JsonPath js;
    static String ID;

    @Test
   public void adbook(){
       baseURI = "http://216.10.245.166";
       String addBookResponse = given().log().all()
               .header("Content-Type","application/json")
               .body(ad.AddBook())
               .when()
               .post("/Library/Addbook.php")
               .then()
               .assertThat().statusCode(200).log().all().extract().response().asString();
       js = stringToJson(addBookResponse);
       String message = js.getString("Msg");
       ID = js.getString("ID");
       Assert.assertEquals(message, "successfully added");
       System.out.println("Id is :" + ID);
   }
}

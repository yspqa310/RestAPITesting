package Practice.LibraryAPI;

import frameWork.RestUtils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddIntoLibrary extends RestUtils {
    static AddLibraryPayLoad ad = new AddLibraryPayLoad();
    static JsonPath js;
    static String ID;

    @Test(dataProvider = "Books Data")
    public void adbook(String bookname, String isbn, String aisle, String author) {
        baseURI = "http://216.10.245.166";
        responseText = given().log().all()
                .header("Content-Type", "application/json")
                .body(ad.AddBook(bookname, isbn, aisle, author))
                .when()
                .post("/Library/Addbook.php")
                .then()
                .assertThat().statusCode(200).log().all().extract().response().asString();
        js = stringToJson();
        String message = js.getString("Msg");
        ID = js.getString("ID");
        Assert.assertEquals(message, "successfully added");
        System.out.println("Id is :" + ID);
    }

    @DataProvider(name = "Books Data")
    public Object[][] getPayLoad() {
        return new Object[][]{{"tearss", "ysp", "shaik", "ysh"}, {"tarss", "ysps", "shik", "ys"}, {"terss", "yp", "sha", "sh"}, {"earss", "ys", "sh", "y"}};
    }
}

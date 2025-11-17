package Practice;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Jsonpath extends payLoad {

    //1 Mocking the Response
    static JsonPath js = new JsonPath(courses());

    public static void main(String[] args) {
        int coursesArraySize = js.getInt("courses.size()");
        System.out.println("Courses array size is : " + coursesArraySize);
        int price;
        String CourseName;
        for (int i = 0; i < coursesArraySize; i++) {
            CourseName = js.getString("courses[" + i + "].title");
            price = js.getInt("courses[" + i + "].price");
            System.out.println("Price of the " + CourseName + " is :" + price);
        }

        for (int i = 0; i < coursesArraySize; i++) {
            CourseName = js.getString("courses[" + i + "].title");
            if (CourseName.equalsIgnoreCase("rpa")) {
                price = js.getInt("courses[" + i + "].price");
                int copies = js.getInt("courses[" + i + "].copies");
                System.out.println("Price of the " + CourseName + " is :" + price + " and number of copies are " + copies);
                break;
            }
        }
    }
}

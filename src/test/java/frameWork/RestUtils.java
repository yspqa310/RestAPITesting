package frameWork;

import io.restassured.path.json.JsonPath;

public class RestUtils {
    public static JsonPath stringToJson(String responseText) {
        return new JsonPath(responseText);
    }

    public static String getStringValueFromResponse(String responseText, String keyPath) {
        JsonPath js = stringToJson(responseText);
        String value = js.getString(keyPath);
        System.out.println(value);
        return value;
    }
}

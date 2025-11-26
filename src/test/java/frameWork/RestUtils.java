package frameWork;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestUtils {
    public static Response response;
    public static String responseText;

    public static JsonPath stringToJson() {
        return new JsonPath(responseText);
    }

    public static Response getResponse() {
        return response;
    }

    public static String getResponseText() {
        return responseText;
    }

    public static String getStringValueFromResponse(String responseText, String keyPath) {
        JsonPath js = stringToJson();
        String value = js.getString(keyPath);
        System.out.println(value);
        return value;
    }

    public static String getStringValueFromResponse(String keyPath) {
        JsonPath js = stringToJson();
        String value = js.getString(keyPath);
        System.out.println(value);
        return value;
    }

    public static int getIntValueFromResponse(Response response, String keyPath) {
        JsonPath js = stringToJson();
        int value = js.getInt(keyPath);
        System.out.println(value);
        return value;
    }

    public static int getIntValueFromResponse(String response, String keyPath) {
        JsonPath js = stringToJson();
        int value = js.getInt(keyPath);
        System.out.println(value);
        return value;
    }
}

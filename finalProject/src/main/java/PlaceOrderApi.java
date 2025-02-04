import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class PlaceOrderApi{
    public static Response postOrder(String requestBody) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured()) // For Allure reporting
                .accept("application/json")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("v2/store/order")
                .then()
                .extract()
                .response();
    }
}

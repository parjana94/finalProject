import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetOrderApi {

    public static Response getOrder(String orderId) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .pathParam("id", orderId)
                .when()
                .get("v2/store/order/{id}")
                .then()
                .extract().response();
    }
}
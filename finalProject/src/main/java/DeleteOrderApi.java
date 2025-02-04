import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.qameta.allure.restassured.AllureRestAssured;

public class DeleteOrderApi {

    public static Response deleteOrder(String orderId) {
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .pathParam("id", orderId)
                .when()
                .delete("v2/store/order/{id}")
                .then()
                .extract().response();
    }
}
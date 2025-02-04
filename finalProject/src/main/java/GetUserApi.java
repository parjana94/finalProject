import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserApi {
    public static Response getUser(String username){
        return RestAssured
                .given()
                .filter(new AllureRestAssured())
                .pathParam("username", username)
                .when()
                .get("v2/user/{username}")
                .then()
                .extract().response();
    }
}

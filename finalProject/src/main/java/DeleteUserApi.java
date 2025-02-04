import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUserApi {

    public static Response deleteUser(String username) {
        return RestAssured
                .given()
                .pathParam("username", username)
                .when()
                .delete("v2/user/{username}")
                .then()
                .extract()
                .response();
    }
}
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateUserApiTest extends UserDataProvider {
    @DataProvider(name = "userData")
    @Override
    public Object[][] userData() throws IOException {
        return super.userData();  // იძახებს მეთოდს chtgpt
    }
    @Test(dataProvider = "userData", description = "Testing create user with Valid Data", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void createUserApiTest(int id, String username, String firstName, String lastName, String email,
                                  String password, String phone, int userStatus) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("username", username);
        requestBody.put("firstName", firstName);
        requestBody.put("lastName", lastName);
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("phone", phone);
        requestBody.put("userStatus", userStatus);
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .accept("application/json")
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("v2/user")
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"Status Code Must Be 200");
    }
}

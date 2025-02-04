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

public class UpdateUserApiTest extends UserDataProvider {
    @DataProvider(name = "userData")
    @Override
    public Object[][] userData() throws IOException {
        return super.userData();  // იძახებს მეთოდს chtgpt
    }
    @Test(dataProvider = "userData", description = "Testing Update user with Valid Data", priority = 3)
    @Severity(SeverityLevel.NORMAL)
    public void updateUserApiTest(int id, String username, String firstName, String lastName, String email,
                                  String password, String phone, int userStatus) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("username", username);
        requestBody.put("firstName", "John");
        requestBody.put("lastName", lastName);
        requestBody.put("email", "john@gmail.com");
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
                .put("v2/user/tanneruser1")
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
    }

}

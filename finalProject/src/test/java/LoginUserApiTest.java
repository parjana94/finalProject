import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginUserApiTest extends UserDataProvider {
    @DataProvider(name = "userData")
    @Override
    public Object[][] userData() throws IOException {
        return super.userData();  // იძახებს მეთოდს chtgpt
    }
    @Test(dataProvider = "userData", description = "Login use Valid data Test", priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    public void createUserApiTest(int id, String username, String firstName, String lastName,
                                  String email, String password, String phone, int userStatus){
        Response response = RestAssured
                .given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/v2/user/login")
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"Status Code Must Be 200");
        Assert.assertNotNull(response.jsonPath().getString("message"),"Message Must Not Be Null");
        }
}

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutUserApiTest extends UserDataProvider {
    @Test(description = "Logout user api test", priority = 6)
    @Severity(SeverityLevel.NORMAL)
    public void logoutUserApiTest(){
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .when()
                .get("/v2/user/logout")
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"Status Code Must Be 200");
        Assert.assertEquals(response.jsonPath().getString("message"),"ok", "Message Must Be Ok");
    }
}

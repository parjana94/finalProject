import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserAfterUpdateTest extends UserDataProvider {
    @Test(description = "Testing get userdata after update", priority = 4)
    @Severity(SeverityLevel.NORMAL)
    public void getUserAfterUpdateTest(){
        Response response = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .when()
                .get("https://petstore.swagger.io/v2/user/tanneruser1")
                .then()
                .extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
        Assert.assertEquals(response.jsonPath().getString("firstName"), "John", "First name is not John");
        Assert.assertEquals(response.jsonPath().getString("email"), "john@gmail.com", "Email is not john@.gmail.com");
    }
}

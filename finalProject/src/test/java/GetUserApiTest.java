import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserApiTest extends UserDataProvider {
    @DataProvider(name = "userData")
    @Override
    public Object[][] userData() throws IOException {
        return super.userData();  // იძახებს მეთოდს chtgpt
    }
    @Test(dataProvider = "userData", description = "Testing Get User Method", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void getUser(int id, String username, String firstName, String lastName, String email,
                        String password, String phone, int userStatus){
  Response response = GetUserApi.getUser(username);
        Assert.assertEquals(response.jsonPath().getString("username"), username, "UserName does not match!");
        Assert.assertEquals(response.jsonPath().getString("firstName"), firstName, "FirstName does not match!");
        Assert.assertEquals(response.jsonPath().getString("lastName"), lastName, "LastName does not match!");
        Assert.assertEquals(response.jsonPath().getString("email"), email, "Email does not match!");
        Assert.assertEquals(response.jsonPath().getString("password"), password, "Password does not match!");
        Assert.assertEquals(response.jsonPath().getString("phone"), phone, "Phone does not match!");
        Assert.assertEquals(Integer.parseInt(response.jsonPath().getString("userStatus")), userStatus, "User Status does not match!");

    }

}

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteUserApiTest extends UserDataProvider {

    @DataProvider(name = "userData")
    @Override
    public Object[][] userData() throws IOException {
        return super.userData();
    }

    @Test(dataProvider = "userData", description = "Delete User API Test", priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    public void deleteUserTest(int id, String username, String firstName, String lastName,
                               String email, String password, String phone, int userStatus) {

        Response deleteResponse = DeleteUserApi.deleteUser(username);
        Assert.assertEquals(deleteResponse.getStatusCode(), 200, "User deletion failed!");
        System.out.println("User " + username + " deleted successfully!");
    }
}

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderApiTest extends PetDataProvider {
    @Test(dataProvider = "petData", priority = 1, description = "Testing Post Method with Valid Data")
    @Severity(SeverityLevel.CRITICAL)
    public void testApi(String id, String petId, String quantity, String status){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("petId", petId);
        requestBody.put("quantity", quantity);
        requestBody.put("status", status);

        Response response = PlaceOrderApi.postOrder(requestBody.toString());
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Must Be 200");
        Assert.assertEquals(response.jsonPath().getString("id"), id, "ID does not match");
        Assert.assertEquals(response.jsonPath().getString("petId"), petId, "Pet ID does not match");
        Assert.assertEquals(response.jsonPath().getString("quantity"), quantity, "Quantity does not match");
        Assert.assertEquals(response.jsonPath().getString("status"), status, "Status does not match");

    }
}

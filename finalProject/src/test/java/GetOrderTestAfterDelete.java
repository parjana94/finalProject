import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetOrderTestAfterDelete extends PetDataProvider {
    @Test(dataProvider = "petData", priority = 5, description = "Testing Get  Method After Delete Order Item")
    @Severity(SeverityLevel.NORMAL)
    public void testGetApiSecTime(String id, String petId, String quantity, String status){
        Response response = GetOrderApi.getOrder(id);
        Assert.assertEquals(response.getStatusCode(), 404, "Status Code Must Be 404");
        Assert.assertEquals(response.jsonPath().getString("message"), "Order not found", "Error message i not Order not found");
    }
}

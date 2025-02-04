import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePlacedOrder extends PetDataProvider {
    @Test(dataProvider = "petData", priority = 3, description = "Testing Delete Method")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteOrderApiTest(String id, String petId, String quantity, String status) {
        Response response = DeleteOrderApi.deleteOrder(id);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Must Be 200");
    }
    @Test(dataProvider = "petData", priority = 4, description = "Testing Delete Method Again")
    @Severity(SeverityLevel.CRITICAL)
    public void tryDeleteSecTime(String id, String petId, String quantity, String status){
        Response response = DeleteOrderApi.deleteOrder(id);
        Assert.assertEquals(response.getStatusCode(), 404, "Status Code Must Be 404");
        Assert.assertEquals(response.jsonPath().getString("message"), "Order Not Found", "Error message is not Order Not Found !! ");
    }
}

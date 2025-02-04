import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPlacedOrderApiTest extends PetDataProvider {
    @Test(dataProvider = "petData",priority = 2, description = "Testing Get  Method")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetApi(String id, String petId, String quantity, String status){
        Response response = GetOrderApi.getOrder(id);
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Must Be 200");
        Assert.assertEquals(response.jsonPath().getString("id"), id, "ID does not match");
        Assert.assertEquals(response.jsonPath().getString("petId"), petId, "Pet ID does not match");
        Assert.assertEquals(response.jsonPath().getString("quantity"), quantity, "Quantity does not match");
        Assert.assertEquals(response.jsonPath().getString("status"), status, "Status does not match");
    }

}

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PlaceOrderWrongData extends PetDataProvider {

    @Test(dataProvider = "petData", priority = 1, description = "Testing Post Method with Invalid ID")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidIdDataTest(String id, String petId, String quantity, String status) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "test");
        requestBody.put("petId", petId);
        requestBody.put("quantity", quantity);
        requestBody.put("status", status);

        Response response = PlaceOrderApi.postOrder(requestBody.toString());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 500, "Incorrect status code!");
        softAssert.assertEquals(response.jsonPath().getString("message"), "something bad happened", "Incorrect error message!");
        softAssert.assertAll();
    }

    @Test(dataProvider = "petData", priority = 2, description = "Testing Post Method with Invalid Pet ID")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidPetIdDataTest(String id, String petId, String quantity, String status) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("petId", "test");
        requestBody.put("quantity", quantity);
        requestBody.put("status", status);

        Response response = PlaceOrderApi.postOrder(requestBody.toString());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 500, "Incorrect status code!");
        softAssert.assertEquals(response.jsonPath().getString("message"), "something bad happened", "Incorrect error message!");
        softAssert.assertAll();
    }
    @Test(dataProvider = "petData", priority = 3, description = "Testing Post Method with Invalid Quantity")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidquantityDataTest(String id, String petId, String quantity, String status) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("petId", petId);
        requestBody.put("quantity", "test");
        requestBody.put("status", status);

        Response response = PlaceOrderApi.postOrder(requestBody.toString());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 500, "Incorrect status code!");
        softAssert.assertEquals(response.jsonPath().getString("message"), "something bad happened", "Incorrect error message!");
        softAssert.assertAll();
    }
}

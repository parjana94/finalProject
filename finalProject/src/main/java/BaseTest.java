import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.sql.SQLException;
import java.util.List;

public class BaseTest {
    @BeforeTest(description = "Provide Site  Base Url")
    public void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io";
    }
}

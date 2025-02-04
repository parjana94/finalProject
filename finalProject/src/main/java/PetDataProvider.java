import org.testng.annotations.DataProvider;

import java.sql.SQLException;
import java.util.List;

public class PetDataProvider extends BaseTest {
    @DataProvider(name = "petData")
    public Object[][] getPetData() throws SQLException {
        List<Object[]> data = GetDataFromDb.getUserData();
        return data.toArray(new Object[0][0]);
    }
}
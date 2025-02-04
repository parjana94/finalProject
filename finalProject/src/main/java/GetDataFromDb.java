import Utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class GetDataFromDb extends DatabaseUtils {
    public static List<Object[]> getUserData() throws SQLException {
        List<Object[]> userData = new ArrayList<>();
        String query = " select *   FROM [master].[dbo].[petData]";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String petId = resultSet.getString("petId");
                String quantity = resultSet.getString("quantity");
                String status = resultSet.getString("quantity");

                userData.add(new Object[]{id, petId, quantity,status});
            }
        }
        return userData;
    }
}

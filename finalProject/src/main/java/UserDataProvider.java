import Utils.ExcelReader;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserDataProvider extends BaseTest {
    public Object[][] userData() throws IOException {
        // იღებს დატას ექსელის ფაილიდან
        List<Object[]> data = ExcelReader.getTestData("src/main/resources/userdata.xlsx", "Sheet1");

        // სია სწორი მონაცემების შესანახად(ცარიელი გრაფების გარეშე)
        List<Object[]> validData = new LinkedList<>();

        // ლუპი მონაცემების ჩასაწერად
        for (Object[] row : data) {
            // Check if the row is valid (non-empty)
            boolean isValid = true;

            // გადის თითოეულ უჯრას და ნახულობს ცარიელია თუ არა
            for (Object cell : row) {
                // თუ რომელიმე სტრიქონი ან უჯრა ცარიელია, აღიქვამს არასწორსტრიქონად და აჩერებს ლუპს
                if (cell == null || cell.toString().trim().isEmpty()) {
                    isValid = false;
                    break;
                }
            }

            // თუ მკრივი არარის ცარიელი ამატებს ვალიდური დატას სიაში
            if (isValid) {
                validData.add(row);
            }
        }

        // validata ლისტს აქცევს ობიექტად და აბრუნებს
        return validData.toArray(new Object[0][]);
    }
}

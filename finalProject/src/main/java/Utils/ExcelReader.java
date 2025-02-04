package Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelReader {
    public static List<Object[]> getTestData(String excelPath, String sheetName) throws IOException {
        List<Object[]> testData = new LinkedList<>();
        FileInputStream fis = new FileInputStream(new File(excelPath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rows = sheet.iterator();

        // Skip header row
        rows.next();

        while (rows.hasNext()) {
            Row row = rows.next();
            Object[] rowData = new Object[row.getPhysicalNumberOfCells()];

            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                Cell cell = row.getCell(i);

                if (cell == null) {
                    rowData[i] = ""; //ცარიელი სტრიქონი ცარიელი უჯრედებისთვის
                } else {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        // თუ მონაცემი ციფრია, ამოწმებს მთელი რიცხვია თუ ათწილადი
                        if (cell.getNumericCellValue() % 1 == 0) {
                            // მთელი რიცხვი
                            rowData[i] = (int) cell.getNumericCellValue();
                        } else {
                            // ათწილადი
                            rowData[i] = cell.getNumericCellValue();
                        }
                    } else if (cell.getCellType() == CellType.STRING) {
                        // თუ სტრინგია ინახავს სტრინგად
                        rowData[i] = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        // თუ ბულეანია ინახავს ბულენადა
                        rowData[i] = cell.getBooleanCellValue();
                    } else {
                        // სხვა შემთხვევები( ფორმულები, შეცდომები)
                        rowData[i] = "";
                    }
                }
            }
            testData.add(rowData);
        }
        workbook.close();
        return testData;
    }

}
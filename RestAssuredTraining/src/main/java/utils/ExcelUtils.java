package utils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    static HSSFWorkbook workbook;
    static HSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) throws IOException {
        workbook = new HSSFWorkbook(new FileInputStream(excelPath));
        sheet = workbook.getSheet(sheetName);
    }

    public static void main(String[] args) throws IOException {
    }

    public static void getCellData(int rowIndex, int colIndex) {
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowIndex).getCell(colIndex));
        System.out.println(value);
    }

    public static void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of rows: " + rowCount);
    }
}

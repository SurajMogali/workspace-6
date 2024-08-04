package utils;

import java.io.IOException;

public class ExcelUtilsTest {

    public static void main(String[] args) throws IOException {
        String excelPath = "./data/TestData.xls";
        String sheetName = "Sheet1";

        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        excel.getRowCount();
        excel.getCellData(1, 0);
        excel.getCellData(1, 1);
        excel.getCellData(1, 2);
    }
}
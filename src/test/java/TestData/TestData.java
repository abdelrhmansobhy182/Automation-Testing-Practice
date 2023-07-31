package TestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import io.cucumber.java.bs.I;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

    String Path= "";
    String SheetName= "";
    XSSFSheet sheet ;

    XSSFWorkbook workbook;

    HashMap<String, String> TestData = new HashMap<>();

    public TestData(String path, String sheetName)throws IOException {
        Path = path;
        SheetName = sheetName;
        FileInputStream fs = new FileInputStream(Path);
        //Creating a workbook
        workbook = new XSSFWorkbook(fs);
        // get sheet name
        sheet = workbook.getSheet(SheetName);


    }

    public HashMap<String, String> copyTestCaseDataToHashTable(int IndexOfTestCase)
    {
        Row AttributeRow = sheet.getRow(0);
        Row DataRow = sheet.getRow(IndexOfTestCase);
        String[] cellValues = new String[DataRow.getLastCellNum()];

        for (int i = 0; i < DataRow.getLastCellNum(); i++) {
            Cell AttributeCell = AttributeRow.getCell(i);
            Cell cell = DataRow.getCell(i);
            if (cell != null) {
                TestData.put(AttributeCell.getStringCellValue(),cell.getStringCellValue());
                System.out.println(TestData.get("Name"));

            }
        }
        return TestData;
    }



    public String getValueOfColumn (String ColumnName, int Index){
        int ColumnIndex = getColumnIndex(sheet,ColumnName);
        Row row = sheet.getRow(Index); // Get the row
        Cell cell = row.getCell(ColumnIndex); // Get the cell at column index 0 (first column)
        String Data = String.valueOf(cell);
        return Data;
    }
    private static int getColumnIndex(XSSFSheet sheet, String columnName) {
        XSSFRow headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            XSSFCell cell = headerRow.getCell(i);
            if (cell != null && cell.getStringCellValue().equals(columnName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Column '" + columnName + "' not found.");
    }

}
package Utilities.Reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ReadDataFromExcelFile {
    private static Random random = new Random();

    public static Map<String, String> getRandomRowValues(String fileName, String sheetName) {
        Map<String, String> rowValues = new HashMap<>();

        try {
            Workbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet != null) {
                int rowCount = sheet.getPhysicalNumberOfRows();
                int randomRowIndex = random.nextInt(rowCount-1)+1;
                Row randomRow = sheet.getRow(randomRowIndex);

                Row headerRow = sheet.getRow(0);
                int columnCount = headerRow.getPhysicalNumberOfCells();

                for (int i = 0; i < columnCount; i++) {
                    Cell headerCell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    Cell dataCell = randomRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String columnName = getCellValueAsString(headerCell);
                    String columnValue = getCellValueAsString(dataCell);
                    rowValues.put(columnName, columnValue);
                }
            } else {
                System.out.println("Sheet with name " + sheetName + " not found!");
            }

            workbook.close();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        return rowValues;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string for null cells
        }
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);}
}

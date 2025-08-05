package com.fxhive.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Reads Excel (.xlsx) files and returns a 2-D Object array
 * suitable for TestNG @DataProvider.
 */
public final class ExcelUtil {

    private ExcelUtil() {}

    public static Object[][] readSheet(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];
            DataFormatter df = new DataFormatter();

            for (int i = 1; i < rows; i++) {            // skip header
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
                }
            }
            return data;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
    }
}

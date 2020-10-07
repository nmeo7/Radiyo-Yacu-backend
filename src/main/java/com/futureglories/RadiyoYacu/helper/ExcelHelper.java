package com.futureglories.RadiyoYacu.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
  static String SHEET = "WORKPLAN";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static void excelToTutorials(InputStream is) {
    try {
        // OPCPackage pkg = OPCPackage.open(is);
        // XSSFWorkbook wb = new XSSFWorkbook(pkg);
        // Workbook workbook = new XSSFWorkbook(pkg);
        // Workbook workbook = new XSSFWorkbook(is);

        Workbook workbook = WorkbookFactory.create(is);
        System.out.println ("DEBUG 0");

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      // List<Tutorial> tutorials = new ArrayList<Tutorial>();
        System.out.println ("DEBUG 1");

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();
        
        System.out.println ("DEBUG 2");

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        
        Iterator<Cell> cellsInRow = currentRow.iterator();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          System.out.println (currentCell.getStringCellValue());

          switch (cellIdx) {
          case 0:
            // tutorial.setId((long) currentCell.getNumericCellValue());
            break;

          case 1:
            // tutorial.setTitle(currentCell.getStringCellValue());
            break;

          case 2:
            // tutorial.setDescription(currentCell.getStringCellValue());
            break;

          case 3:
            // tutorial.setPublished(currentCell.getBooleanCellValue());
            break;

          default:
            break;
          }

          cellIdx++;
        }
      }

      workbook.close();
      System.out.println ("DEBUG 4");

      // return tutorials;
    } catch (IOException e) {
        System.out.println ("DEBUG 5");
        System.out.println (e.getMessage());
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}

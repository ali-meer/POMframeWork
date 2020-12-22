package readExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class getExcel extends readExcelSheet{

        public static XSSFRow Row;
        public static XSSFCell cell;

        static Object[][] objArray;

        public static String FilePath = System.getProperty("user.dir") + "\\data\\dataFile.xlsx";
        public static String sheetName = "Login";

        @DataProvider(name = "getLoginData")
        public static Object[][] getLoginData(){

            sheet = dataSet(FilePath,sheetName);

             int rowCount = sheet.getLastRowNum();
            //int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("rowCount : " + rowCount);

            int colCount = sheet.getRow(0).getLastCellNum();
            System.out.println("colCount" + colCount);

            objArray = new Object[rowCount][colCount];

            for(int i=1; i<=rowCount; i++){
                for(int x=0; x<colCount; x++){
                    objArray[i-1][x] = dataCell(i, x);
                    System.out.println(objArray[i-1][x]);

                }
            }
            return objArray;
        }

        public static String dataCell(int row, int col){

            try {
                sheet = wb.getSheetAt(0);
                Row = sheet.getRow(row);
                if (Row == null)
                    return "";
                cell = Row.getCell(col);
                if (cell == null)
                    return "";
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        return cell.getStringCellValue();
                    case Cell.CELL_TYPE_BLANK:
                        return "";
                    case Cell.CELL_TYPE_BOOLEAN:
                        return String.valueOf(cell.getBooleanCellValue());
                    case Cell.CELL_TYPE_NUMERIC:
                        return String.valueOf(cell.getNumericCellValue());
                    case Cell.CELL_TYPE_ERROR:
                        return cell.getStringCellValue();
                    default:
                        return "Cell not found..";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "row " + row + " or column " + col + " Does not exist in xlsx";
            }


        }
    }


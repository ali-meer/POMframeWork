package readExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class readExcelSheet {
    static XSSFWorkbook wb;
    static File file;
    static FileInputStream fis;
    static XSSFSheet sheet;

    public static XSSFSheet dataSet(String filePath, String sheetName) {

        file = new File(filePath);
        try {
             fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }
}

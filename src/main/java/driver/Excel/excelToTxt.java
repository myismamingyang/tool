package driver.Excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/9/14 16:22
 * @Version: 1.0
 * @Function:
 */
public class excelToTxt {
    public static void main(String[] args) {
        try {
            // 打开Excel文件
            FileInputStream fis = new FileInputStream("E:\\opt\\zTestFilePath\\excelToTxt\\excel.xlsx");
            // 创建工作簿对象
            Workbook workbook = new XSSFWorkbook(fis);
            // 获取第一个工作表（你可以根据需要进行更改）
            Sheet sheet = workbook.getSheetAt(0);
            // 创建文本文件
            File txtFile = new File("E:\\opt\\zTestFilePath\\excelToTxt\\excel.txt");
            FileOutputStream fos = new FileOutputStream(txtFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter writer = new BufferedWriter(osw);
            // 遍历Excel文件的每一行和单元格，并写入文本文件
            for (Row row : sheet) {
                for (Cell cell : row) {
                    String cellValue = "";
                    if (cell.getCellType() == CellType.STRING) {
                        cellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    // 将单元格值写入文本文件
                    writer.write(cellValue + "\t");
                }
                // 换行
                writer.newLine();
            }
            // 关闭写入器和流
            writer.close();
            osw.close();
            fos.close();
            // 关闭文件流和工作簿
            fis.close();
            workbook.close();
            System.out.println("Excel文件已成功转换为文本文件。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
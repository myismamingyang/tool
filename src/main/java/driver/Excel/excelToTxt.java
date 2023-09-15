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
            FileInputStream fileInputStream = new FileInputStream("E:\\opt\\zTestFilePath\\excelToTxt\\excel.xlsx");
            // 创建工作簿对象
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                // 获取第一个工作表（你可以根据需要进行更改）
                Sheet sheet = workbook.getSheetAt(i);
                // 创建文本文件
                File txtFile = new File("E:\\opt\\zTestFilePath\\excelToTxt\\excel_Sheet_" + (i+1) +".txt");
                FileOutputStream fileOutputStream = new FileOutputStream(txtFile);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
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
                        bufferedWriter.write(cellValue + "\001");
                    }
                    // 换行
                    bufferedWriter.newLine();
                }
                // 关闭写入器和流
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
                System.out.println("Excel  Sheet " + (i+1) + " 已成功转换为文本文件: excel_Sheet_" + (i+1) + ".txt 。");
            }
            // 关闭文件流和工作簿
            fileInputStream.close();
            workbook.close();
            System.out.println("Excel文件已成功转换为文本文件。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
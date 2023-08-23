package driver.convertFormat;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/8/23 9:37
 * @Version: 1.0
 * @Function: 调用类
 */
public class driverJpg2Txt {
    public static void main(String[] args) throws IOException {
        String inputImagePath = "C:\\Users\\14652\\Desktop\\testFile\\GitHub.jpg";
        String outputTxtPath = "C:\\Users\\14652\\Desktop\\testFile\\GitHub.txt";

        JpgTotxt jpgTotxt = new JpgTotxt();
        String jpgvalue = jpgTotxt.jpgTotxt(inputImagePath);
        FileWriter fileWriter = new FileWriter(outputTxtPath);
        fileWriter.write(jpgvalue);
        fileWriter.close();

    }
}

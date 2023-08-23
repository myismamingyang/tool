package driver.convertFormat;

import java.io.*;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/8/23 9:37
 * @Version: 1.0
 * @Function: 调用类
 */
public class driverTxt2Jpg {
    public static void main(String[] args) throws IOException {
        String inputTxtPath = "C:\\Users\\14652\\Desktop\\testFile\\GitHub.txt";
        String outputImagePath = "C:\\Users\\14652\\Desktop\\testFile\\GitHub22.jpg";

        try {
            FileReader reader = new FileReader(inputTxtPath);
            BufferedReader bufferedReader = new BufferedReader(reader);

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }

            bufferedReader.close();

            String fileContent = content.toString();

            txtTojpg txtTojpg = new txtTojpg();
            txtTojpg.txtTojpg(fileContent,outputImagePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

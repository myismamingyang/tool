package driver.convertFormat;


/**
 * @Author: Mingyang Ma
 * @Date: 2023/8/23 9:37
 * @Version: 1.0
 * @Function: 调用类
 */
public class driverJpgAndTxt {
    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\14652\\Desktop\\GitHub.jpg";
        String outputTXTPath = "C:\\Users\\14652\\Desktop\\";

        JpgTotxt jpgTotxt = new JpgTotxt();
        String jpgvalue = jpgTotxt.jpgTotxt(inputImagePath);

        TxtTojpg txtTojpg = new TxtTojpg();
        txtTojpg.txtTojpg(jpgvalue,outputTXTPath);
    }
}

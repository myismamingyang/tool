package driver.convertFormat;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/8/23 13:19
 * @Version: 1.0
 * @Function:
 */
public class test {
    public static void main(String[] args) {
        String outputImagePath = "C:\\Users\\14652\\Desktop\\testFile\\GitHub22.jpg";
        String[] split = outputImagePath.split("\\.",2);

        for (int i = 0; i < split.length; i++) {
            System.out.println("分割后的位数: " + i +  " , 分割后的数据长度: " + split.length + " , 分割后的数据: " + split[i]);
        }
    }
}

package driver.convertFormat;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/8/23 9:16
 * @Version: 1.0
 * @Function: 将txt文件转为图片
 */
public class txtTojpg {

    //public static String fileformat = "png";
    //public static String fileNameFormat = "yyyy-MM-dd_HH-mm-ss";

    // 将字符串格式的图片转换为图片并保存
    public void txtTojpg(String string, String saveDir) {
        if (string.contains(",")) {
            // 这里没有自带的那个分割方法，原因是分割速度没有这个快，有人考证在分割字符长度很大的情况下，系统的分割方法容易造成内存溢出。
            // 还有subString方法，不知道最新版本的jdk改了源码了么
            String[] imagetemp = split(string, ",");
            byte[] image = new byte[imagetemp.length];
            for (int i = 0; i < imagetemp.length; i++) {
                image[i] = Byte.parseByte(imagetemp[i]);
            }
            saveImage(image, saveDir);
        } else {
            // 不能解析格式的字符串
        }
    }

    // 将byte[] 转换为BufferedImage
    private BufferedImage readImage(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        return ImageIO.read(bais);
    }

    // 保存图片
    public  String saveImage(byte[] imgages, final String saveDir) {
        try {
            BufferedImage bis = readImage(imgages);
//            DateFormat sdf = new SimpleDateFormat(fileNameFormat);
//            String fileTime = sdf.format(new Date());
//            final String name = fileTime + "_" + "." + fileformat;
//            File f = new File(saveDir + name);
            File f = new File(saveDir);
            boolean istrue = false;
            String[] split = saveDir.split("\\.");
            String fileformat = split[1];
            if (f.exists()) {
                istrue = ImageIO.write(bis, fileformat, f);
            } else {
                f.mkdirs();
                istrue = ImageIO.write(bis, fileformat, f);
            }
            if (istrue) {
                return f.getName();
            }
        } catch (Exception e) {
        }
        return null;
    }

    // 分割字符串
    public String[] split(String s, String token) {
        if (s == null)
            return null;
        if (token == null || s.length() == 0)
            return new String[] { s };
        int size = 0;
        String[] result = new String[4];
        while (s.length() > 0) {
            int index = s.indexOf(token);
            String splitOne = s;
            if (index > -1) {
                splitOne = s.substring(0, index);
                s = s.substring(index + token.length());
            } else {
                s = "";
            }
            if (size >= result.length) {
                String[] tmp = new String[result.length * 2];
                System.arraycopy(result, 0, tmp, 0, result.length);
                result = tmp;
            }
            if (splitOne.length() > 0) {
                result[size++] = splitOne;
            }
        }
        String[] tmp = result;
        result = new String[size];
        System.arraycopy(tmp, 0, result, 0, size);
        return result;
    }
}
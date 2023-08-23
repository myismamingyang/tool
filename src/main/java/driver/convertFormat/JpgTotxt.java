package driver.convertFormat;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/8/23 9:07
 * @Version: 1.0
 * @Function: 将图片转为txt
 */
public class JpgTotxt {
    private static Log log = LogFactory.getLog(JpgTotxt.class);

    // 根据图片地址将图片转换为字符串类型的数据
    public String jpgTotxt(String inputImagePath) {
        StringBuffer sb2 = new StringBuffer();
        BufferedImage image1 = getImage(inputImagePath);
        byte[] img = getBytes(image1);

        for (int i = 0; i < img.length; i++) {
            if (sb2.length() == 0) {
                sb2.append(img[i]);
            } else {
                sb2.append("," + img[i]);
            }
        }
        return sb2.toString();
    }
    // 将BufferImage 转换为字节数组
    private byte[] getBytes(BufferedImage image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "JPG", baos);
        } catch (Exception e) {
            log.info(e);
        }
        return baos.toByteArray();
    }
    // 根据图片地址得到BufferedImage
    public static BufferedImage getImage(String inputImagePath) {
        try {

            BufferedImage bImage = ImageIO.read(new File(inputImagePath));
            return bImage;
        } catch (Exception ex) {
            log.info(ex);
            return null;
        }
    }
}
package driver.convertFormat.base64;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/10/15 16:17
 * @Version: 1.0
 * @Function:
 */
public class transBase64ToStream {
    public static void main(String[] args) throws IOException {
        String base64Path = "C:\\Users\\14652\\Desktop\\testFile\\inFile_Base64.txt";
        String base64ToJpgPath = "C:\\Users\\14652\\Desktop\\testFile\\base64\\Base64.jpg";
        BufferedReader br = new BufferedReader(new FileReader(base64Path));
        FileOutputStream fos = new FileOutputStream(base64ToJpgPath,true);
        String lien;
        while((lien=br.readLine())!=null){
            fos.write(Base64.getDecoder().decode(lien));
            fos.flush();
        }
        fos.close();
        br.close();
        //TODO: ERROR: Input byte array has incorrect ending byte at 68
    }
}

package driver.convertFormat.base64;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author: Mingyang Ma
 * @Date: 2023/10/15 15:33
 * @Version: 1.0
 * @Function:
 */
public class transStreamToBase64 {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\14652\\Desktop\\testFile\\inFile.jpg";
        String outPath = "C:\\Users\\14652\\Desktop\\testFile\\inFile_jpg.txt";
        String outBase64Path = "C:\\Users\\14652\\Desktop\\testFile\\inFile_Base64.txt";
        readStreamToTxt(inPath,outPath);
        toBase64svString(outPath,outBase64Path);

    }

    /**
     * 将txt转换成Base64编码
     * @param inPath
     * @param outPath
     * @throws IOException
     */
    public static void toBase64svString(String inPath,String outPath) throws IOException {
        File inPutFile = new File(inPath);
        File outPathFile = new File(outPath);
        BufferedReader br = new BufferedReader(new FileReader(inPutFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outPathFile,true));
        String lien;
        while((lien = br.readLine())!=null){
            String s = Base64.getEncoder().encodeToString(lien.getBytes(StandardCharsets.UTF_8));
            bw.write(s);
            bw.flush();
        }
        bw.close();
        br.close();
        System.out.println("文件已转换成Base64编码");
    }

    /**
     * 用FileInputStream读取影像输出成txt
     * @param inPath
     * @param outPath
     * @throws IOException
     */
    public static void readStreamToTxt(String inPath, String outPath) throws IOException {
        File inPutFile = new File(inPath);
        File outPathFile = new File(outPath);
        FileInputStream fis = new FileInputStream(inPutFile);
        FileOutputStream fos = new FileOutputStream(outPathFile);
        byte[] bytes = new byte[1024];
        int lien;
        while ((lien= fis.read(bytes))!=-1){
            fos.write(bytes,0,lien);
        }
        fos.close();
        fis.close();
        System.out.println("文件已转换成txt格式");
    }
}

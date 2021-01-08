package com.ac;


import com.ac.test.BufferedImageLuminanceSource;
import com.ac.test.QRCodeUtil;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
public class QrCodeTest {

    @Test
    public void testQrCode() throws Exception {

        // 生成的二维码的路径及名称
        String destPath = "D:\\C_DESKTOP\\新建文件夹\\2020-11-19_17-14-34.png";
        InputStream inputStream =new FileInputStream(destPath);
       /* QRCodeUtil qrCodeUtil =new QRCodeUtil();
        String str = qrCodeUtil.decode(destPath);*/
        // 打印出解析出的内容
        System.out.println(decode(inputStream));
    }


    public static String decode(InputStream input) {

        BufferedImage image;
        String txt = "";
        try {
            if (null == input) {
                return "";
            }
            image = ImageIO.read(input);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Map<DecodeHintType,Object> hints = new LinkedHashMap<DecodeHintType,Object>();
            // 解码设置编码方式为：utf-8，
            hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
            //优化精度
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            //复杂模式，开启PURE_BARCODE模式
            hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
            Result result = new MultiFormatReader().decode(bitmap, hints);
            txt = result.getText();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("解码失败，请确认的你二维码是否正确，或者图片有多个二维码");
        }
        return  txt;
    }
}

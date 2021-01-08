package com.ac;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class HttpTest {

    @Test
    public void test1(){
        String gh = "";
        //String cp = "鄂A5TK68";
        String cp = "鄂A5TK68";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        String z = simpleDateFormat.format(new Date());
            String methodUrl = "http://10.101.67.97/exec/interface.ashx";
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String line = null;
            System.out.println(methodUrl+"?z="+z+"&x=CAR&gh="+gh+"&cp="+cp);
            try {
                URL url = new URL(methodUrl+"?z="+z+"&x=CAR&gh="+gh+"&cp="+cp);
                connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
                connection.setRequestMethod("GET");// 默认GET请求
                connection.connect();//建立TCP连接
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
                    StringBuilder result = new StringBuilder();
                    // 循环读取流
                    while ((line = reader.readLine()) != null) {
                        result.append(line).append(System.getProperty("line.separator"));// "\n"
                    }
                    System.out.println(result.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connection.disconnect();
            }
    }
}

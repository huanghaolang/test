package com.ac;

import com.ac.entity.Token;
import com.ac.jwtToken.TokenUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@SpringBootTest
class AcmsApplicationTests {

    @Resource
    private Token t;

    @Resource
    private TokenUtil tokenUtil;

    @Test
    public void token() throws Exception{
       String tk= tokenUtil.getFinalToken();
        Map<String, Claim> claims = tokenUtil.verifyToken(tk);
       //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0IiwiaXNzIjoidGVzdCIsImV4cCI6MTU3MzExNTA2MX0.svXBJOwMnGk_WLUO9T5WSFthDOhAwnrUzTum6CbCrgI
       //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0IiwiaXNzIjoidGVzdCIsImV4cCI6MTU3MzExNDY4NH0.GcNCODIEosC6a-yo68HeML0OiDijjruPq6qLYZRuaRw
       // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0IiwiaXNzIjoidGVzdCIsImlkIjoiMSIsImV4cCI6MTU3MzExNDE1NH0.fKkM9pXSbC59PRU9xCWUcnWGR6U_eONSK0HnI7ZHutY
    }
    @Test
    public void token2() throws Exception{
        String a="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0IiwiaXNzIjoidGVzdCIsImlkIjoiMSIsImV4cCI6MTU3MzExNDY1MH0.vyU0Xx3vJjQlyRNcUmJsjNjgQ6fnc4bOx5QswZsLueM";
        Map<String, Claim> claims = tokenUtil.verifyToken(a);
        //JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("")).build();
    }


    @Test
    void contextLoads() throws IOException {
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(filePath);

        //当前项目下xml文件夹
        File file1 = new File("");
        String filePath1 = file1.getCanonicalPath()+ File.separator+"xml\\";
        System.out.println(filePath1);

        //获取类加载的根路径
        File file3 = new File(this.getClass().getResource("/").getPath());
        System.out.println(file3);

        //获取当前类的所在工程路径
        File file4 = new File(this.getClass().getResource("").getPath());
        System.out.println(file4);

        //获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
    }
    @Test
    public void getLujing() throws Exception{
        //当前项目下路径
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println(filePath);

        //当前项目下xml文件夹
        File file1 = new File("");
        String filePath1 = file1.getCanonicalPath()+ File.separator+"xml\\";
        System.out.println(filePath1);

        //获取类加载的根路径
        File file3 = new File(this.getClass().getResource("/").getPath());
        System.out.println(file3);

        //获取当前类的所在工程路径
        File file4 = new File(this.getClass().getResource("").getPath());
        System.out.println(file4);

        //获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}

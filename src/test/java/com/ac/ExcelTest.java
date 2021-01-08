package com.ac;

import com.ac.entity2.AdmissionInfo;
import com.ac.helper.ExcelUtils;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ExcelTest {

    public ExcelUtils excelUtils = new ExcelUtils();

    @Test
    public void getBatchDir() throws Exception {
        File file = new File("D:\\C_DESKTOP\\完整版管理类联考全国院校");
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                    } else {
                        this.getExcel(file2.getName());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }

    }

    @Test
    public void getExcel() throws Exception {
        this.getExcel("2019入学考期北京新版知识库2.xlsx");
    }

    public  void getExcel(String filename) throws Exception {
        List<List<Object>> list = ExcelUtils.getExcelByPath("D:\\C_DESKTOP\\完整版管理类联考全国院校\\"+filename);

        AdmissionInfo admissionInfo = null;
        List<AdmissionInfo> admissionInfoList = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            try {


            List<Object> item  = list.get(i);

            if(i%4==0){
                admissionInfo = new AdmissionInfo();
                admissionInfo.setSchoolName(String.valueOf(item.get(0)));

                admissionInfo.setSchoolQuality(String.valueOf(item.get(2))); //学校性质  1

                admissionInfo.setSchoolProp4(String.valueOf(item.get(4)));//全日制学费 1

                admissionInfo.setSchoolProp6(String.valueOf(item.get(5)));//正常批考生 1
                admissionInfo.setSchoolProp7(String.valueOf(item.get(7)));//提前批考生 1
                admissionInfo.setSchoolProp8(String.valueOf(item.get(9)));//转档案及转户要求 1
                admissionInfo.setSchoolProp9(String.valueOf(item.get(10)));//院校地址 1


                admissionInfo.setSchoolProp10(String.valueOf(item.get(12)));//研究方向 1

                admissionInfo.setSchoolProp13(String.valueOf(item.get(14)));//注意事项全日制 1

            }else if(i%4==1){
                admissionInfo.setSchoolProp1(String.valueOf(item.get(2)));//所获认证 2
                admissionInfo.setSchoolProp14(String.valueOf(item.get(14)));//注意事项非全日制 3  todo

            }else if(i%4==2){
                admissionInfo.setSchoolProp2(String.valueOf(item.get(2)));//学制及招生人数 3
                admissionInfo.setSchoolProp5(String.valueOf(item.get(4)));//非全日制学费 2 todo
                admissionInfo.setSchoolProp11(String.valueOf(item.get(12)));//招生简章 3


            }else if(i%4==3){
                admissionInfo.setSchoolProp3(String.valueOf(item.get(2)));//联系方式 4
                admissionInfo.setSchoolProp12(String.valueOf(item.get(12)));//院校网址 4
                admissionInfo.setSchoolProp15(String.valueOf(item.get(14)));///注意事项历年分数线 4

                admissionInfoList.add(admissionInfo);

            }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("error========="+i+"===="+filename);
            }
            //aa
        }

        XSSFWorkbook xssfWorkbook  = new XSSFWorkbook();
        xssfWorkbook =  excelUtils.getWordBook(xssfWorkbook,"sheet1",admissionInfoList);
        FileOutputStream fos = new FileOutputStream(new File("D:\\ACMSWhiteExcel\\export\\完整版管理类联考全国院校\\"+filename));

        ZipSecureFile.setMinInflateRatio(-1.0d);
        xssfWorkbook.write(fos);
        //work.close();
        fos.close();

    }
}

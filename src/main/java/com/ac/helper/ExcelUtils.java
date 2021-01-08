package com.ac.helper;

import com.ac.entity2.AdmissionInfo;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

		private final static String excel2003L =".xls";    //2003- 版本的excel
	    private final static String excel2007U =".xlsx";   //2007+ 版本的excel

	    /**
	     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
	     * @param in,fileName
	     * @return
	     * @throws IOException
	     * */
	    public static  List<List<Object>> getExcel(InputStream in,String fileName) throws Exception{
	        List<List<Object>> list = null;

	        //创建Excel工作薄
	        Workbook work =  getWorkbook(in,fileName);

	        if(null == work){
	            throw new Exception("创建Excel工作薄为空！");
	        }else {
	        	 Workbook wb=work;
	        	FileOutputStream fos = new FileOutputStream(new File("D:\\ACMSWhiteExcel\\import\\"+fileName));

                ZipSecureFile.setMinInflateRatio(-1.0d);
	        	wb.write(fos);
	        	//work.close();
				fos.close();
	        }
	        Sheet sheet = null;
	        Row row = null;
	        Cell cell = null;

	        list = new ArrayList<List<Object>>();
	        //遍历Excel中所有的sheet
	        for (int i = 0; i < work.getNumberOfSheets(); i++) {
	            sheet = work.getSheetAt(i);

	            if(sheet==null){continue;}

	            //遍历当前sheet中的所有行
	            for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum()+1; j++) {
	                row = sheet.getRow(j);
	                if(row==null||row.getFirstCellNum()==j){continue;}

	                //遍历所有的列
	                List<Object> li = new ArrayList<Object>();
	                int benginNum=row.getFirstCellNum();
	                int endNum=row.getLastCellNum();
	                for (int y = benginNum; y < endNum; y++) {
	                    cell = row.getCell(y);
	                    li.add(getCellFormatValue(cell));
	                }
	                list.add(li);
	            }
	        }
	        in.close();
	        return list;
	    }

    public static  List<List<Object>> getExcel2(InputStream in,String fileName) throws Exception{
        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work =  getWorkbook(in,fileName);

        ZipSecureFile.setMinInflateRatio(-1.0d);
        if(null == work){
            throw new Exception("Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet work.getNumberOfSheets()
        //遍历第一个sheet
        for (int i = 0; i < 1; i++) {
            sheet = work.getSheetAt(i);

            if(sheet==null){continue;}

            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                if(row==null||row.getFirstCellNum()==j){continue;}

                //遍历所有的列
                List<Object> li = new ArrayList<Object>();
                int benginNum=row.getFirstCellNum();
                int endNum=row.getLastCellNum();
                for (int y = benginNum; y < endNum; y++) {
                    cell = row.getCell(y);
                    li.add(getCellFormatValue(cell));
                }
                list.add(li);
            }
        }
        in.close();
        return list;
    }

    public static  List<List<Object>> getExcelByPath(String filePath) throws Exception{
        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work =  readExcel(filePath);

        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }else {
            Workbook wb=work;
            //FileOutputStream fos = new FileOutputStream(new File("D:\\ACMSWhiteExcel\\import\\"+fileName));

            ZipSecureFile.setMinInflateRatio(-1.0d);
            //wb.write(fos);
            //work.close();
            //fos.close();
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        list = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);

            if(sheet==null){continue;}

            //遍历当前sheet中的所有行
            for (int j = 3; j < sheet.getLastRowNum()+1; j++) {
                //for (int j = sheet.getFirstRowNum(); j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                if(row==null||row.getFirstCellNum()==j){continue;}

                //遍历所有的列
                List<Object> li = new ArrayList<Object>();
                int benginNum=row.getFirstCellNum();
                int endNum=row.getLastCellNum();
                for (int y = benginNum; y < endNum; y++) {
                    cell = row.getCell(y);
                    li.add(getCellFormatValue(cell));
                }
                if(li.size()>0){
                    list.add(li);

                }
            }
        }
        //in.close();
        return list;
    }

    /**
	     * 描述：根据文件后缀，自适应上传文件的版本
	     * @param inStr,fileName
	     * @return
	     * @throws Exception
	     */
	    public static Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{
	        Workbook wb = null;
	        String fileType = fileName.substring(fileName.lastIndexOf("."));
	        if(excel2003L.equals(fileType)){
	            wb = new HSSFWorkbook(inStr);  //2003-
	        }else if(excel2007U.equals(fileType)){
	            wb = new XSSFWorkbook(inStr);  //2007+
	        }else{
	            throw new Exception("解析的文件格式有误！");
	        }
	        return wb;
	    }
	 // 读取excel
		@SuppressWarnings("resource")
		public static Workbook readExcel(String filePath) {
			Workbook wb = null;
			if (filePath == null) {
				return null;
			}
			String extString = filePath.substring(filePath.lastIndexOf("."));
			InputStream is = null;
			try {
				is = new FileInputStream(filePath);
				if (".xls".equals(extString)) {
					return wb = new HSSFWorkbook(is);
				} else if (".xlsx".equals(extString)) {
					return wb = new XSSFWorkbook(is);
				} else {
					return null;
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return wb;
		}

	    /**
	     * 描述：对表格中数值进行格式化
	     * @param cell
	     * @return
	     */
	   /* public static  Object getCellValue(Cell cell){
	        Object value = null;
	        //com.ac.helper.ExcelUtils.getCellValue(Cell)
	      //  DecimalFormat df = new DecimalFormat("#");  //格式化number String字符
	       // SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
	        //DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

	        switch (cell.getCellType()) {
	            case Cell.CELL_TYPE_STRING:
	                value = cell.getRichStringCellValue().getString().trim();
	                break;
	            case Cell.CELL_TYPE_NUMERIC:
	            	if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    value = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
	                } else {
	                    DataFormatter dataFormatter = new DataFormatter();
	                    value = dataFormatter.formatCellValue(cell);
	                }

	                break;
	            case Cell.CELL_TYPE_BOOLEAN:
	                value = cell.getBooleanCellValue();
	                break;
	            case Cell.CELL_TYPE_BLANK:
	                value = "";
	                break;
	            default:
	                break;
	        }
	        if("彭荆川1".equals(value)) {
	        	System.out.println(value);
	        }
	        return value;
	    }*/
	    public static Object getCellFormatValue(Cell cell) {
			Object cellValue = null;
			if (cell != null) {
				// 判断cell类型
				switch (cell.getCellType()) {
				case NUMERIC: {
					//DecimalFormat df = new DecimalFormat("#");// 转换成整型
					//cellValue = df.format(cell.getNumericCellValue()).trim();

					if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
	                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
	                } else {
	                    DataFormatter dataFormatter = new DataFormatter();
	                    cellValue = dataFormatter.formatCellValue(cell);
	                }
					break;
				}
				case FORMULA: {
					if (DateUtil.isCellDateFormatted(cell)) {
						// 转换为日期格式YYYY-mm-dd
						//cellValue = cell.getDateCellValue();

					} else {
						cellValue = String.valueOf(cell.getNumericCellValue()).trim();
					}
					break;
				}
				case STRING: {
					cellValue = cell.getRichStringCellValue().getString().trim();
					break;
				}
				default:
					cellValue = "";
				}
			} else {
				cellValue = "";
			}
			return cellValue;
		}

    public XSSFWorkbook getWordBook(XSSFWorkbook wb, String sheetName, List<AdmissionInfo> admissionInfoList){
        XSSFSheet sheet=wb.createSheet(sheetName);
        XSSFRow row=sheet.createRow(0);
        CellStyle cellStyle =wb.createCellStyle();
        // 设置这些样式
        //
        // HorizontalAlignment.CENTER
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
       // cellStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
       // cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
      //  cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
       // cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
       // cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        XSSFFont font = wb.createFont();
      //  font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        cellStyle.setFont(font);

        XSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("院校名称");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(0, 5500);
        cell = row.createCell((short) 1);
        cell.setCellValue("学校性质");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(1, 5000);
        cell = row.createCell((short) 2);
        cell.setCellValue("所获认证");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(2, 5000);
        cell = row.createCell((short) 3);
        cell.setCellValue("学制及招生人数");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(3, 5000);
        cell = row.createCell((short) 4);
        cell.setCellValue("联系方式");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(4, 5000);
        cell = row.createCell((short) 5);
        cell.setCellValue("全日制");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(5, 5000);
        cell = row.createCell((short) 6);
        cell.setCellValue("非全日制");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(6, 4000);
        cell = row.createCell((short) 7);
        cell.setCellValue("正常批考生");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(7, 4000);
        cell = row.createCell((short) 8);
        cell.setCellValue("提前批考生");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(8, 4000);

        cell = row.createCell((short) 9);
        cell.setCellValue("转档案及转户要求");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(9, 4000);
        cell = row.createCell((short) 10);
        cell.setCellValue("院校地址");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(10, 4000);
        cell = row.createCell((short) 11);
        cell.setCellValue("研究方向");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(11, 4000);
        cell = row.createCell((short) 12);
        cell.setCellValue("招生简章");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(12, 4000);
        cell = row.createCell((short) 13);
        cell.setCellValue("院校网址");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(13, 4000);
        cell = row.createCell((short) 14);
        cell.setCellValue("全日制");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(14, 4000);
        cell = row.createCell((short) 15);
        cell.setCellValue("非全日制");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(15, 4000);
        cell = row.createCell((short) 16);
        cell.setCellValue("历年分数线");
        cell.setCellStyle(cellStyle);
        sheet.setColumnWidth(16, 4000);

        wb.setSheetName(0, sheetName);
        if(admissionInfoList.size() == 0){
            XSSFRow rows=sheet.createRow(1);
            rows.setHeight((short) 500);
            rows.createCell(0).setCellValue("没有查询结果！");
            return wb;
        }

        for(int i = 0; i < admissionInfoList.size(); i ++){
            XSSFRow rows=sheet.createRow(i+1);
            rows.setHeight((short) 500);
           // Map<String,Object> map = sheetResult.get(info);
            AdmissionInfo admissionInfo = admissionInfoList.get(i);
            rows.createCell(0).setCellValue(admissionInfo.getSchoolName() + "");
            rows.createCell(1).setCellValue(admissionInfo.getSchoolQuality() + "");
            rows.createCell(2).setCellValue(admissionInfo.getSchoolProp1() + "");
            rows.createCell(3).setCellValue(admissionInfo.getSchoolProp2() + "");
            rows.createCell(4).setCellValue(admissionInfo.getSchoolProp3() + "");
            rows.createCell(5).setCellValue(admissionInfo.getSchoolProp4() + "");
            rows.createCell(6).setCellValue(admissionInfo.getSchoolProp5() + "");
            rows.createCell(7).setCellValue(admissionInfo.getSchoolProp6() + "");
            rows.createCell(8).setCellValue(admissionInfo.getSchoolProp7() + "");
            rows.createCell(9).setCellValue(admissionInfo.getSchoolProp8() + "");
            rows.createCell(10).setCellValue(admissionInfo.getSchoolProp9() + "");
            rows.createCell(11).setCellValue(admissionInfo.getSchoolProp10() + "");
            rows.createCell(12).setCellValue(admissionInfo.getSchoolProp11() + "");
            rows.createCell(13).setCellValue(admissionInfo.getSchoolProp12() + "");
            rows.createCell(14).setCellValue(admissionInfo.getSchoolProp13() + "");
            rows.createCell(15).setCellValue(admissionInfo.getSchoolProp14() + "");
            rows.createCell(16).setCellValue(admissionInfo.getSchoolProp15() + "");
            //多插一行，避免单元格溢出
            rows.createCell(17).setCellValue(" ");
        }

        return wb;
    }


	}

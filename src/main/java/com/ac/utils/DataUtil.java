package com.ac.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataUtil {
    /**
     * 预设不同的时间格式
     */
    //精确到年月日（英文） eg:2019-12-31
    public static String FORMAT_LONOGRAM = "yyyy-MM-dd";
    //精确到时分秒的完整时间（英文） eg:2010-11-11 12:12:12
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    //精确到毫秒完整时间（英文） eg:2019-11-11 12:12:12.55
    public static String FORMAT_LONOGRAM_MILL = "yyyy-MM-dd HH:mm:ss.SSS";
    //精确到年月日（中文）eg:2019年11月11日
    public static String FORMAT_LONOGRAM_CN = "yyyy年MM月dd日";
    //精确到时分秒的完整时间（中文）eg:2019年11月11日 12时12分12秒
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日 HH时MM分SS秒";
    //精确到毫秒完整时间（中文）
    public static String FORMAT_LONOGRAM_MILL_CN = "yyyy年MM月dd日HH时MM分SS秒SSS毫秒";

    /**
     * 预设默认的时间格式
     */
    public static String getDefaultFormat() {
        return FORMAT_FULL;
    }
    /**
     * 预设格式格式化日期
     */
    public static String format(Date date) {
        return format(date,getDefaultFormat());
    }
    /**
     * 自定义格式格式化日期
     */
    private static String format(Date date, String format) {
        String value = "";
        if(date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            value = sdf.format(date);
        }
        return value;
    }
    /**
     * 根据预设默认格式，返回当前日期
     */
    public static String getNow() {
        return format(new Date());
    }
    /**
     * 自定义时间格式，返回当前日期
     */
    public static String getNow(String format) {
        return format(new Date(),format);
    }
    /**
     *根据预设默认时间 String->Date
     */
    public static Date parse(String strDate) {
        return parse(strDate,getDefaultFormat());
    }
    /**
     * 自定义时间格式：Stirng->Date
     */
    public static Date parse(String strDate,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(strDate);
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date LongParseDate(String strlong){
        Date date = null;
        if(strlong.length()==10){
             date = new Date(Long.valueOf(strlong) * 1000);
        }else if((strlong.length()==13)){
            date = new Date(Long.valueOf(strlong));
        }else {
            new Exception("参数不是10位或者13的");
        }
        return date;
    }

    public static String LongParseDateStr(String strlong,String format){
        Date date = null;
        if(strlong.length()==10){
            date = new Date(Long.valueOf(strlong) * 1000);
        }else if((strlong.length()==13)){
            date = new Date(Long.valueOf(strlong));
        }else {
            new Exception("参数不是10位或者13的");
        }
        return format(date,format);
    }



    public static String LongParseDateStr(String strlong){
        Date date = null;
        if(strlong.length()==10){
            date = new Date(Long.valueOf(strlong) * 1000);
        }else if((strlong.length()==13)){
            date = new Date(Long.valueOf(strlong));
        }else {
            new Exception("参数不是10位或者13的");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getDefaultFormat());
        return simpleDateFormat.format(date);
    }

    public static List<Date> batchStrParseDate(List<String> strList){
        if(strList==null || strList.size()==0){
            new Exception("批量转换strList不能是空集合");
        }
        List<Date> list =new ArrayList<>();
        for (String str : strList){
            list.add(LongParseDate(str));
        }
        return list;

    }
    /**
     * 基于指定日期增加年
     * @param num  正数往后推，负数往前移
     * Calendar:它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR
     *                 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
     */
    public static Date addYear(Date date,int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, num);
        return cal.getTime();
    }
    /**
     * 基于指定日期增加整月
     * @param date
     * @param num 整数往后推，负数往前移
     * @return
     */
    public static Date addMonth(Date date,int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, num);
        return cal.getTime();
    }
    /**
     * 基于指定日期增加天数
     * @param date
     * @param num 整数往后推，负数往前移
     * @return
     */
    public static Date addDay(Date date,int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, num);
        return cal.getTime();
    }
    /**
     * 基于指定日期增加分钟
     * @param date
     * @param num 整数往后推，负数往前移
     * @return
     */
    public static Date addMinute(Date date,int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, num);
        return cal.getTime();
    }
    /**
     * 获取时间戳 eg:yyyy-MM-dd HH:mm:ss.S
     * @return
     */
    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_LONOGRAM_MILL);
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }
    /**
     * 获取日期的年份
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0,4);
    }
    /**
     * 获取年份+月
     */
    public static String getYearMonth(Date date) {
        return format(date).substring(0, 7);
    }
    /**
     *获取日期的小时数
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    /**
     *   自定义时间格式字符串距离今天的天数
     * @param strDate
     * @param format
     * @return
     */
    public static int countDays(String strDate,String format) {
        long time = Calendar.getInstance().getTime().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(strDate,format));
        long diff = cal.getTime().getTime();
        long a = time/1000;
        long b = diff/1000;
        return (int) (a - b)/3600/24;
    }
    /**
     * 预设格式的字符串距离今天的天数
     * @param strDate
     * @return
     */
    public static int countDays(String strDate) {
        return countDays(strDate,getDefaultFormat());
    }
    /**
     * 获取天数差值(依赖时间)
     * @param date1
     * @param date2
     * @return
     */
    public static int diffDays(Date date1,Date date2) {
        if(date1 == null || date2 == null) {
            return 0;
        }
        return (int) (Math.abs(date1.getTime() - date2.getTime()) / (60 * 60 * 24 * 1000));
    }
    /**
     * 获取年份差值
     * @param year1
     * @param year2
     * @return
     */
    public static int diffYear(Date year1,Date year2) {
        return diffDays(year1,year2) / 365;
    }
    /**
     * 获取天数差值(依赖Date类型的日期)
     * @param d1
     * @param d2
     * @return
     */
    public static int diffByDays(Date d1,Date d2) {
        Date s1 = parse(format(d1,FORMAT_LONOGRAM),FORMAT_LONOGRAM);
        Date s2 = parse(format(d2,FORMAT_LONOGRAM),FORMAT_LONOGRAM);
        return diffDays(s1,s2);
    }
    /**
     * 获取时间分割集合
     *
     * @param date 查询日期
     * @param strs 带拆分的时间点
     * @return
     */
    public static List<Date> collectTimes(Date date, String[] strs){
        List<Date> result = new ArrayList<Date>();
        List<String> times = Arrays.asList(strs);
        String dateStr = format(date,FORMAT_LONOGRAM);
        String pattern = FORMAT_LONOGRAM + "K";
        if(times.size() > 0 ) {
            times.stream().forEach(t -> {
                result.add(parse(date +" "+ t,pattern));
            });
        }
        return result;
    }

    /**
     * 根据日期查询当前为周几
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"7","1","2","3","4","5","6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK);   //1--7的值,对应：星期日，星期一，星期二，星期三....星期六
        //System.out.println(w);
        return weekDays[w-1];

    }

    /**
     * 将时间转换成汉字
     * @param hour
     * @return
     */
    public static String hourToCn(String hour) {
        String[] timeArray = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
        String[] hourArray = hour.split(":");
        int hourInt = Integer.parseInt(hourArray[0]);
        int minute = Integer.parseInt(hourArray[1]);
        String result = intToCn(hourInt,timeArray) + "点\n" + intToCn(minute,timeArray) + "分";
        return result;
    }
    private static String intToCn(int hourInt, String[] timeArray) {
        String result = "";
        if(hourInt >= 0 && hourInt <= 10) {
            result += timeArray[hourInt] + "\n";
        } else if (hourInt >= 11 && hourInt <= 19) {
            result += (timeArray[10] + "\n" + timeArray[hourInt % 10]) + "\n";
        }else {
            result += (timeArray[hourInt / 10] + "\n" + timeArray[10]) + "\n" + (hourInt % 10 == 0 ? "" : timeArray[hourInt % 10] + "\n");
        }
        return result;
    }
    /**
     * 获取当前日期后的一周时间，并返回LinkedHashMap<String, Date>
     * @param startTime
     * @return
     */
    public static LinkedHashMap<String, Date> dateAfterWeek(String startTime) {
        LinkedHashMap<String, Date> result = new LinkedHashMap<>();
        try {
            Date date = parse(startTime,FORMAT_LONOGRAM);
            for (int i = 0; i < 7; i++) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DATE, i);  //把日期往后增加一天,整数往后推,负数往前移动  时间戳转时间
                Date newDate = calendar.getTime();
                String str = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
                result.put(str, newDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    /**
     * 获取当前日期 后的一周时间，并返回yyyy-MM-dd字符串数组
     * @param startTime
     * @return
     */
    public static String[] dateAfterWeekArray(String startTime) {
        String weekArray[] = new String[7];
        try {
            Date date = parse(startTime,FORMAT_LONOGRAM);
            for (int i = 0; i < 7; i++) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.DATE, i);//把日期往后增加一天,整数往后推,负数往前移动  时间戳转时间
                Date newDate = calendar.getTime();
                weekArray[i] = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weekArray;
    }
    /**
     * 根据传入的时间获取本周开始（0-表示本周，1-表示下周，-1-表示上周  ）
     * @param date
     * @return
     */
    public static String getMonDayToDate(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date, "yyyy-MM-dd"));
        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, 0 * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return format(cal.getTime());
    }

    public static Date getDayBegin(){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);//0点
        cal.set(Calendar.MINUTE, 0);//0分
        cal.set(Calendar.SECOND, 0);//0秒
        cal.set(Calendar.MILLISECOND, 0);//0毫秒
        return cal.getTime();
    }


    /**
     * 获取当天结束时间
     * @return
     */
    public static Date getDayEnd(){
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);//23点
        cal.set(Calendar.MINUTE, 59);//59分
        cal.set(Calendar.SECOND, 59);//59秒
        return cal.getTime();
    }


    /**
     * 获取昨天开始时间
     * @return
     */
    public static Date getBeginDayOfYesterday(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(getDayBegin());//当天开始时间
        cal.add(Calendar.DAY_OF_MONTH, -1);//当天月份天数减1
        return cal.getTime();
    }


    /**
     * 获取昨天结束时间
     * @return
     */
    public static Date getEndDayOfYesterday(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(getDayEnd());//当天结束时间
        cal.add(Calendar.DAY_OF_MONTH, -1);//当天月份天数减1
        return cal.getTime();
    }


    /**
     * 获取明天开始时间
     * @return
     */
    public static Date getBeginDayOfTomorrow(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(getDayBegin());//当天开始时间
        cal.add(Calendar.DAY_OF_MONTH, 1);//当天月份天数加1
        return cal.getTime();
    }


    /**
     * 获取明天结束时间
     * @return
     */
    public static Date getEndDayOfTomorrow(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(getDayEnd());//当天结束时间
        cal.add(Calendar.DAY_OF_MONTH, 1);//当天月份天数加1
        return cal.getTime();
    }


    /**
     * 获取某个日期的开始时间
     * @param d
     * @return
     */
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar=Calendar.getInstance();
        if(null!=d){
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取某个日期的结束时间
     * @param d
     * @return
     */
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar=Calendar.getInstance();
        if(null!=d){
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }


    /**
     * 获取本周的开始时间
     * @return
     */
    @SuppressWarnings("unused")
    public static Date getBeginDayOfWeek(){
        Date date=new Date();
        if(date==null){
            return null;
        }
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==1){
            dayOfWeek+=7;
        }
        cal.add(Calendar.DATE, 2-dayOfWeek);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本周的结束时间
     * @return
     */
    public static Date getEndDayOfWeek(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取上周开始时间
     */
    @SuppressWarnings("unused")
    public static Date getBeginDayOfLastWeek() {
        Date date=new Date();
        if (date==null) {
            return null;
        }
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        int dayofweek=cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek==1) {
            dayofweek+=7;
        }
        cal.add(Calendar.DATE, 2-dayofweek-7);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取上周的结束时间
     * @return
     */
    public static Date getEndDayOfLastWeek(){
        Calendar cal=Calendar.getInstance();
        cal.setTime(getBeginDayOfLastWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }


    /**
     * 获取今年是哪一年
     * @return
     */
    public static Integer getNowYear(){
        Date date = new Date();
        GregorianCalendar gc=(GregorianCalendar)Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }


    /**
     * 获取本月是哪一月
     * @return
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc=(GregorianCalendar)Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }


    /**
     * 获取本月的开始时间
     * @return
     */
    public static Date getBeginDayOfMonth() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth()-1, 1);
        return getDayStartTime(calendar.getTime());
    }


    /**
     * 获取本月的结束时间
     * @return
     */
    public static Date getEndDayOfMonth() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth()-1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth()-1, day);
        return getDayEndTime(calendar.getTime());
    }


    /**
     * 获取上月的开始时间
     * @return
     */
    public static Date getBeginDayOfLastMonth() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth()-2, 1);
        return getDayStartTime(calendar.getTime());
    }


    /**
     * 获取上月的结束时间
     * @return
     */
    public static Date getEndDayOfLastMonth() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth()-2, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth()-2, day);
        return getDayEndTime(calendar.getTime());
    }


    /**
     * 获取本年的开始时间
     * @return
     */
    public static java.util.Date getBeginDayOfYear() {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return getDayStartTime(cal.getTime());
    }


    /**
     * 获取本年的结束时间
     * @return
     */
    public static java.util.Date getEndDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, getNowYear());
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return getDayEndTime(cal.getTime());
    }


    /**
     * 两个日期相减得到的天数
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDiffDays(Date beginDate, Date endDate) {
        if(beginDate==null||endDate==null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }
        long diff=(endDate.getTime()-beginDate.getTime())/(1000*60*60*24);
        int days = new Long(diff).intValue();
        return days;
    }


    /**
     * 两个日期相减得到的毫秒数
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms=beginDate.getTime();
        long date2ms=endDate.getTime();
        return date2ms-date1ms;
    }


    /**
     * 获取两个日期中的最大日起
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date max(Date beginDate, Date endDate) {
        if(beginDate==null) {
            return endDate;
        }
        if(endDate==null) {
            return beginDate;
        }
        if(beginDate.after(endDate)) {//beginDate日期大于endDate
            return beginDate;
        }
        return endDate;
    }


    /**
     * 获取两个日期中的最小日期
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Date min(Date beginDate, Date endDate) {
        if(beginDate==null) {
            return endDate;
        }
        if(endDate==null) {
            return beginDate;
        }
        if(beginDate.after(endDate)) {
            return endDate;
        }
        return beginDate;
    }


    /**
     * 获取某月该季度的第一个月
     * @param date
     * @return
     */
    public static Date getFirstSeasonDate(Date date) {
        final int[] SEASON={ 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4 };
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        int sean = SEASON[cal.get(Calendar.MONTH)];
        cal.set(Calendar.MONTH, sean*3-3);
        return cal.getTime();
    }


    /**
     * 返回某个日期下几天的日期
     * @param date
     * @param i
     * @return
     */
    public static Date getNextDay(Date date, int i) {
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE,cal.get(Calendar.DATE)+i);
        return cal.getTime();
    }


    /**
     * 返回某个日期前几天的日期
     * @param date
     * @param i
     * @return
     */
    public static Date getFrontDay(Date date, int i) {
        Calendar cal=new GregorianCalendar();
        cal.setTime(date);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE)-i);
        return cal.getTime();
    }



    /**
     * 获取某年某月按天切片日期集合（某个月间隔多少天的日期集合）
     * @param beginYear
     * @param beginMonth
     * @param k
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List getTimeList(int beginYear, int beginMonth, int k) {
        List list = new ArrayList();
        Calendar begincal=new GregorianCalendar(beginYear,beginMonth, 1);
        int max = begincal.getActualMaximum(Calendar.DATE);
        for (int i = 1; i < max; i = i + k) {
            list.add(begincal.getTime());
            begincal.add(Calendar.DATE, k);
        }
        begincal = new GregorianCalendar(beginYear, beginMonth, max);
        list.add(begincal.getTime());
        return list;
    }


    /**
     * 获取某年某月到某年某月按天的切片日期集合（间隔天数的集合）
     * @param beginYear
     * @param beginMonth
     * @param endYear
     * @param endMonth
     * @param k
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List getTimeList(int beginYear,int beginMonth,int endYear,int endMonth, int k) {
        List list = new ArrayList();
        if (beginYear==endYear){
            for(int j=beginMonth;j<=endMonth;j++){
                list.add(getTimeList(beginYear,j,k));
            }
        }else{
            {
                for(int j=beginMonth;j<12;j++){
                    list.add(getTimeList(beginYear,j,k));
                }
                for(int i=beginYear+1;i<endYear;i++) {
                    for (int j=0; j<12; j++) {
                        list.add(getTimeList(i,j,k));
                    }
                }
                for (int j=0;j <= endMonth; j++) {
                    list.add(getTimeList(endYear, j, k));
                }
            }
        }
        return list;
    }




    //=================================时间格式转换==========================

    /**
     * date类型进行格式化输出（返回类型：String）
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }


    /**
     * 将"2015-08-31 21:08:06"型字符串转化为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String str) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) formatter.parse(str);
        return date;
    }


    /**
     * 将CST时间类型字符串进行格式化输出
     * @param str
     * @return
     * @throws ParseException
     */
    public static String CSTFormat(String str) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = (Date) formatter.parse(str);
        return dateFormat(date);
    }



    /**
     * 将long类型转化为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date LongToDare(long str) throws ParseException{
        return new Date(str * 1000);
    }




    //====================================其他常见日期操作方法======================

    /**
     * 判断当前日期是否在[startDate, endDate]区间
     *
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @author jqlin
     * @return
     */
    public static boolean isEffectiveDate(Date startDate, Date endDate){
        if(startDate == null || endDate == null){
            return false;
        }
        long currentTime = new Date().getTime();
        if(currentTime >= startDate.getTime()
                && currentTime <= endDate.getTime()){
            return true;
        }
        return false;
    }


    /**
     * 得到二个日期间的间隔天数
     * @param secondString：后一个日期
     * @param firstString：前一个日期
     * @return
     */
    public static String getTwoDay(String secondString, String firstString) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            java.util.Date secondTime = myFormatter.parse(secondString);
            java.util.Date firstTime = myFormatter.parse(firstString);
            day = (secondTime.getTime() - firstTime.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }


    /**
     * 时间前推或后推分钟,其中JJ表示分钟.
     * @param StringTime：时间
     * @param minute：分钟（有正负之分）
     * @return
     */
    public static String getPreTime(String StringTime, String minute) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            Date date1 = format.parse(StringTime);
            long Time = (date1.getTime() / 1000) + Integer.parseInt(minute) * 60;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {
            return "";
        }
        return mydate1;
    }


    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }



    /**
     * 得到一个时间延后或前移几天的时间
     * @param nowdate：时间
     * @param delay：前移或后延的天数
     * @return
     */
    public static String getNextDay(String nowdate, String delay) {
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            Date d = strToDate(nowdate);
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        }catch(Exception e){
            return "";
        }
    }


    /**
     * 判断是否闰年
     * @param ddate
     * @return
     */
    public static boolean isLeapYear(String ddate) {
        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        Date d = strToDate(ddate);
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(d);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0){
            return true;
        }else if ((year % 4) == 0){
            if ((year % 100) == 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }


    /**
     * 返回美国时间格式
     * @param str
     * @return
     */
    public static String getEDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(str, pos);
        String j = strtodate.toString();
        String[] k = j.split(" ");
        return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
    }


    /**
     * 判断二个时间是否在同一个周
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if(0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)){
                return true;
            }
        }else if(1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)){
                return true;
            }
        }else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR)){
                return true;
            }
        }
        return false;
    }



    /**
     * 产生周序列,即得到当前时间所在的年度是第几周
     * @return
     */
    public static String getSeqWeek() {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
        if (week.length() == 1) {
            week = "0" + week;
        }
        String year = Integer.toString(c.get(Calendar.YEAR));
        return year +"年第"+ week+"周";
    }


    /**
     * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
     * @param sdate：日期
     * @param num：星期几（星期天是一周的第一天）
     * @return
     */
    public static String getWeek(String sdate, String num) {
        // 再转换为时间
        Date dd = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(dd);
        switch (num) {
            case "1":
// 返回星期一所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case "2":
// 返回星期二所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case "3":
// 返回星期三所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case "4":
// 返回星期四所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case "5":
// 返回星期五所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            case "6":
// 返回星期六所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
            case "0":
// 返回星期日所在的日期
                c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }


    /**
     * 根据一个日期，返回是星期几的字符串
     * @param sdate
     * @return
     */
    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        // int hour=c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }


    /**
     * 根据一个日期，返回是星期几的字符串
     * @param sdate
     * @return
     */
    public static String getWeekStr(String sdate){
        String str = "";
        str = getWeek(sdate);
        if("1".equals(str)){
            str = "星期日";
        }else if("2".equals(str)){
            str = "星期一";
        }else if("3".equals(str)){
            str = "星期二";
        }else if("4".equals(str)){
            str = "星期三";
        }else if("5".equals(str)){
            str = "星期四";
        }else if("6".equals(str)){
            str = "星期五";
        }else if("7".equals(str)){
            str = "星期六";
        }
        return str;
    }


    /**
     * 两个时间之间的天数
     * @param date1
     * @param date2
     * @return
     */
    public static long getDays(String date1, String date2) {
        if (date1 == null || date1.equals("")) {
            return 0;
        }
        if (date2 == null || date2.equals("")) {
            return 0;
        }
        // 转换为标准时间
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        java.util.Date mydate = null;
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }


    /**
     * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
     * 此函数返回该日历第一行星期日所在的日期
     * @param sdate
     * @return
     */
    public static String getNowMonth(String sdate) {
        // 取该时间所在月的一号
        sdate = sdate.substring(0, 8) + "01";

        // 得到这个月的1号是星期几
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int u = c.get(Calendar.DAY_OF_WEEK);
        String newday = getNextDay(sdate, (1 - u) + "");
        return newday;
    }


    /**
     * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写
     * @param sformat
     * @return
     */
    public static String getUserDate(String sformat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(sformat);
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    /**
     * 返回一个i位数的随机数
     * @param i
     * @return
     */
    public static String getRandom(int i) {
        Random jjj = new Random();
        // int suiJiShu = jjj.nextInt(9);
        if (i == 0) {
            return "";
        }
        String jj = "";
        for (int k = 0; k < i; k++) {
            jj = jj + jjj.nextInt(9);
        }
        return jj;
    }


    /**
     * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
     * @param k：表示是取几位随机数，可以自己定
     * @return
     */
    public static String getNo(int k) {
        return getUserDate("yyyyMMddhhmmss") + getRandom(k);
    }



}

package com.sq.ncreport.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    /**
     * 定义一些long类型的时间毫秒值
     */
    public static final long MINUTE = 60 * 1000L;
    public static final long HOUR = MINUTE * 60;
    public static final long DAY = HOUR * 24;
    public static final long WEEK = DAY * 7;

    public static final String U_MINUTE = "MINUTE";
    public static final String U_HOUR = "HOUR";
    public static final String U_DAY = "DAY";
    public static final String U_WEEK = "WEEK";
    public static final String U_MONTH = "MONTH";
    public static final String U_YEAR = "YEAR";

    public static final String first_second = " 00:00:00";
    public static final String last_second = " 23:59:59";

    /**
     * 定义一些常用的 format 类型
     */
    public static final String format_default_date = "yyyy-MM-dd";
    public static final String format_default_datetime = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    public static final String yyyy = "yyyy";
    public static final String yyyyMM = "yyyyMM";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMddHH = "yyyyMMddHH";
    public static final String yyyyMMddHHmm = "yyyyMMddHHmm";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

    private DateTimeUtils(){}

    public static String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_date);
        return sdf.format(new Date());
    }

    public static String getDatetime(){
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_datetime);
        return sdf.format(new Date());
    }

    public static String getDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getDatetime(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static String getDate(long millisecond){
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_date);
        return sdf.format(new Date(millisecond));
    }

    public static String getDatetime(long millisecond){
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_datetime);
        return sdf.format(new Date(millisecond));
    }

    public static String getDate(long millisecond, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(millisecond));
    }

    public static String getDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_date);
        return sdf.format(date);
    }

    public static String getDatetime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_datetime);
        return sdf.format(date);
    }

    public static String getDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getDateByStr(String datestr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format_default_datetime);
        return sdf.parse(datestr);
    }

    public static Date getDateByStr(String datestr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(datestr);
    }

    /**
     * @author 单强 2018年11月2日13:28:31
     * @param  date		开始日期
     * @param  unit		计算单位
     * @param  amount	单位数量
     * @param  format	返回的日期格式
     * @return 返回指定格式的日期字符串
     * @功能 :
     *  根据传入的时间，单位，数量，格式——计算得到返回的时间字符串
     *  例如：
     *    如果传入的时间是day，而 amount 为 1， 则返回传入的时间+1天后的时间，如果amount为-1，则返回传入的时间-1天后的时间
     *    如果传入的时间为其他单位，则同理
     *
     */
    public static String getNext(Date date, String unit, int amount, String format) {
        Date date1 = null;
        if(U_MINUTE.equalsIgnoreCase(unit)) {
            date1 = org.apache.commons.lang3.time.DateUtils.addMinutes(date, amount);
        } else if(U_HOUR.equalsIgnoreCase(unit)) {
            date1 = org.apache.commons.lang3.time.DateUtils.addHours(date, amount);
        } else if(U_DAY.equalsIgnoreCase(unit)) {
            date1 = org.apache.commons.lang3.time.DateUtils.addDays(date, amount);
        } else if(U_WEEK.equalsIgnoreCase(unit)){
            date1 = org.apache.commons.lang3.time.DateUtils.addDays(date, amount * 7);
        } else if(U_MONTH.equalsIgnoreCase(unit)) {
            date1 = org.apache.commons.lang3.time.DateUtils.addMonths(date, amount);
        } else if(U_YEAR.equalsIgnoreCase(unit)) {
            date1 = org.apache.commons.lang3.time.DateUtils.addYears(date, amount);
        }
        return getDate(date1, format);
    }

    public static String getCurDateBeforeOneDay() {
        return getNext(new Date(), U_DAY, -1, yyyyMMdd);
    }

    public static String getNext(String unit, int amount, String format) {
        return getNext(new Date(), unit, amount, format);
    }

    public static String getNextDate(Date date, String unit, int amount) {
        return getNext(date, unit, amount, format_default_date);
    }

    public static String getNextDate(String unit, int amount) {
        return getNext(new Date(), unit, amount, format_default_date);
    }

    public static String getNextDatetime(Date date, String unit, int amount) {
        return getNext(date, unit, amount, format_default_datetime);
    }

    public static String getNextDatetime(String unit, int amount) {
        return getNext(new Date(), unit, amount, format_default_datetime);
    }


}




package com.kit.deliver.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description Operations related to date
 * @Author jihainan
 * @Date 2021/11/2 1:02 上午
 * @Version 1.0
 */
public class DateUtils {

    static ThreadLocal<DateFormat> safeSdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    /**
     * @Author jihainan
     * @Description Returns today's date as java.util.Date object
     * @Date 1:08 上午 2021/11/2
     * @return java.util.Date
     */
    public static Date today() {
        return new Date();
    }

    /**
     * @Author jihainan
     * @Description Returns today's date as yyyy-MM-dd format
     * @Date 1:08 上午 2021/11/2
     * @return java.lang.String
     */
    public static String todayStr() {
        return safeSdf.get().format(today());
    }

    /**
     * @Author jihainan
     * @Description Returns the formatted String date for the passed java.util.Date object
     * @Date 1:09 上午 2021/11/2
     * @Param [date]
     * @return java.lang.String
     */
    public static String formattedDate(Date date) {
        return date != null ? safeSdf.get().format(date) : todayStr();
    }
}

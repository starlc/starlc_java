package com.starlc;

import com.starlc.util.Console;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCal {
    private static volatile ThreadLocal<SimpleDateFormat> FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) throws Exception {

        System.out.println(5/6);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 7, 11);
        getTheSameDayOfHalfYear(calendar.getTime());

        test();

        getWeek();
    }

    static void test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 6, 30);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        calendar.set(Calendar.MONTH, 1);
        //calendar.add(Calendar.MONTH,-5);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(calendar.getTime()));

        Date date = new Date();
    }
    private static final String STR_WEEKS = "{0}年{1}周";
    static void getWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 2, 24);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(calendar.getTime()));
        Console.log("ce"+calendar.getTime().before(new Date()));
        Console.log(calendar.get(Calendar.WEEK_OF_YEAR));
String year = 2020+"";
int weekOfYear = 1;
       Console.log(MessageFormat.format(STR_WEEKS,year,weekOfYear)); ;
        for (int i = 0; i < 12; i++) {
            Console.log(i/3);
        }

        ;
    }

    /**
     * 根据配置的首次提醒时间获取今年的同一天
     */
    public static Date getTheSameDayOfHalfYear(Date firstTime) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date theSameDayOfYear = getTheSameDayOfYear(firstTime);
        calendar.setTime(theSameDayOfYear);

        Calendar current = Calendar.getInstance();
        //如果获取到的同年的一天 和 今天相差半年 就增减半年
        int diffMonth = current.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
        int diffDay = current.get(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
        //如果当前日期比获取到的日期大6个月 就返回半年后的日期
        if ((diffMonth >= 6 && diffDay >= 0)) {
            calendar.add(Calendar.MONTH, 6);
        } else if ((diffMonth <= -6 && diffDay <= 0)) {
            calendar.add(Calendar.MONTH, -6);
        }

        Console.log("获取到的今年最接近日期为{0}", FORMAT.get().format(calendar.getTime()));
        return calendar.getTime();
    }

    /**
     * 根据配置的首次提醒时间获取今年的同一天
     */
    public static Date getTheSameDayOfYear(Date firstTime) throws ParseException {
        Calendar old = Calendar.getInstance();
        old.setTime(firstTime);
        //当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, old.get(Calendar.MONTH));
        //判断当月天数是否超过设置日期的天数,比如设置的是2月29，则自动切换到2月28
        if (old.get(Calendar.DAY_OF_MONTH) > calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, old.get(Calendar.DAY_OF_MONTH));
        }
        Console.log("设置的原始日期为{0}", FORMAT.get().format(firstTime));
        Console.log("获取到的今年日期为{0}", FORMAT.get().format(calendar.getTime()));
        return calendar.getTime();
    }
}

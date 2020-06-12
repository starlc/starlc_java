package com.starlc.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CDTDateTest {

    public static void main(String[] args) {
        String strDate = "Fri Jul 13 00:00:00 CDT 1990";
        String strDate3 = "Mon Oct 01 00:00:00 CST 1990";
        String strDate2 = "Thu Oct 17 2019 16:15:24 GMT+0800";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(strDate);
        System.out.println(df.format(date));
        System.out.println(df.format(new Date(strDate3)));

    }
}

package com.mojtaba_shafaei.android.dateDialog.calendar;

import android.util.SparseArray;
import java.util.Map;
import java.util.WeakHashMap;

public class Constants {
    public final static String DAY = "day";
    public final static String IS_OUT_OF_RANGE = "is out of range!";
    public final static String NOT_IMPLEMENTED_YET = "not implemented yet!";
    public final static String MONTH = "month";
    public final static String YEAR_0_IS_INVALID = "Year 0 is invalid!";

    private static SparseArray<String> monthNames = null;
    private static Map<String, String> weekDayNames = null;

    public static SparseArray<String> getMonthNames() {
        if (monthNames == null) {
            monthNames = new SparseArray<>();
            monthNames.put(0, "فروردین");
            monthNames.put(1, "اردیبهشت");
            monthNames.put(2, "خرداد");
            monthNames.put(3, "تیر");
            monthNames.put(4, "مرداد");
            monthNames.put(5, "شهریور");
            monthNames.put(6, "مهر");
            monthNames.put(7, "آبان");
            monthNames.put(8, "آذر");
            monthNames.put(9, "دی");
            monthNames.put(10, "بهمن");
            monthNames.put(11, "اسفند");
        }

        return monthNames;
    }

    public static Map<String, String> getWeekDayNames() {
        if (weekDayNames == null) {
            weekDayNames = new WeakHashMap<>();
            weekDayNames.put("saturday", "شنبه");
            weekDayNames.put("sunday", "یکشنبه");
            weekDayNames.put("monday", "دوشنبه");
            weekDayNames.put("tuesday", "سه‌شنبه");
            weekDayNames.put("wednesday", "چهارشنبه");
            weekDayNames.put("thursday", "پنجشنبه");
            weekDayNames.put("friday", "جمعه");
        }
        return weekDayNames;
    }
}

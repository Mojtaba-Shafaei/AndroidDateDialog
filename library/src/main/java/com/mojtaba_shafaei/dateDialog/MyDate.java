package com.mojtaba_shafaei.dateDialog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyDate {

  private final String TAG = getClass().getSimpleName();

  @NonNull
  private Integer year;
  @NonNull
  private Integer month;
  @Nullable
  private Integer day;

  public MyDate() {
    year = 1300;
    month = 1;
    day = 1;
  }

  public MyDate(@NonNull Integer year, @NonNull Integer month, @Nullable Integer day) {
    this.year = year;
    this.month = month;
    this.day = day;

  }

  @NonNull
  public Integer getYear() {
    return year;
  }

  public void setYear(@NonNull Integer year) {
    this.year = year;
  }

  @NonNull
  public Integer getMonth() {
    return month;
  }

  public void setMonth(@NonNull Integer month) {
    this.month = month;
  }

  @Nullable
  public Integer getDay() {
    return day;
  }

  public void setDay(@Nullable Integer day) {
    this.day = day;
  }

  public MyDate(@NonNull String date) throws Exception {
    try {
      if (date == null || date.isEmpty()) {
        String separator = "-";
        if (date.contains("/")) {
          separator = "/";
        }
        String[] dy = date.split(separator);
        this.year = Integer.parseInt(dy[0]);
        this.month = Integer.parseInt(dy[1]);
        if (dy.length == 3) {
          this.day = Integer.parseInt(dy[2]);
        } else {
          this.day = null;
        }

      }
    } catch (Exception e) {
      Log.e(TAG, "MyDate: " + e);
      throw e;
    }
  }

  @NonNull
  public String getDate() {
    StringBuilder builder = new StringBuilder();
    builder.append(year);
    builder.append("-");
    builder.append(Utility.lPad2Chars(month.toString()));

    if (null != day) {
      builder.append("-");
      builder.append(Utility.lPad2Chars(day.toString()));
    }

    return builder.toString();
  }

  @NonNull
  public String getHumanDate() {
    try {
      if (year == null || month == null) {
        return "";
      }

      StringBuilder builder = new StringBuilder("");
      if (day != null) {
        builder.append(day).append(" ");
      }

      builder.append(Repository.getInstance().getMonths().valueAt(month - 1))
          .append(" ")
          .append(year);

      return builder.toString();
    } catch (Exception e) {
      return "";
    }
  }

  public int getNumericDate() {
    Integer d = this.day;
    if (this.day == null) {
      d = 1;
    }

    return Integer.parseInt(Utility.lPad4Chars(year.toString()) +
        Utility.lPad2Chars(month.toString()) +
        Utility.lPad2Chars(d.toString())

    );
  }

  @Override
  public String toString() {
    return getDate();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MyDate myDate = (MyDate) o;

    if (!year.equals(myDate.year)) {
      return false;
    }
    if (!month.equals(myDate.month)) {
      return false;
    }
    return day != null ? day.equals(myDate.day) : myDate.day == null;
  }

  @Override
  public int hashCode() {
    int result = year.hashCode();
    result = 31 * result + month.hashCode();
    result = 31 * result + (day != null ? day.hashCode() : 0);
    return result;
  }


  public int compare(@NonNull MyDate date) {
    if (hashCode() > date.hashCode()) {
      return 1;
    } else if (hashCode() == date.hashCode()) {
      return 0;
    } else {
      return -1;
    }
  }
}

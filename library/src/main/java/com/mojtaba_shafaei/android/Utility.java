package com.mojtaba_shafaei.android;

/**
 * Created by mojtaba on 1/21/18.
 */

class Utility {

  static String lPad2Chars(String s) {
    if (s.length() < 2) {
      s = "0" + s;
    }
    return s;
  }

  public static String lPad4Chars(String s) {
    if (s.length() < 4) {
      StringBuilder stringBuilder = new StringBuilder(s);
      do {
        stringBuilder.insert(0,"0");
      } while (stringBuilder.length() == 4);

    }
    return s;
  }
}

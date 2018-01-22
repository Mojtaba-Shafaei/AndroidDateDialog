package com.mojtaba_shafaei.dateDialog;

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
        stringBuilder.insert(0, "0");
      } while (stringBuilder.length() == 4);

    }
    return s;
  }

  public static String format(String input) {
    if (null == input || input.isEmpty()) {
      return "";
    }
    String[][] replacements = {
        {"ا", "ا"}, {"أ", "ا"}, {"آ", "آ"}, {"ب", "ب"}, {"پ", "پ"}, {"ت", "ت"}, {"ث", "ث"}, {"ج", "ج"},
        {"چ", "چ"}, {"ح", "ح"}, {"خ", "خ"}, {"د", "د"}, {"ذ", "ذ"}, {"ر", "ر"}, {"ز", "ز"}, {"ژ", "ژ"},
        {"س", "س"}, {"ش", "ش"}, {"ص", "ص"}, {"ض", "ض"}, {"ط", "ط"}, {"ظ", "ظ"}, {"ع", "ع"}, {"غ", "غ"},
        {"ف", "ف"}, {"ق", "ق"}, {"ک", "ک"}, {"ك", "ک"}, {"گ", "گ"}, {"ل", "ل"}, {"م", "م"}, {"ن", "ن"},
        {"و", "و"}, {"ؤ", "و"}, {"ه", "ه"}, {"ة", "ه"}, {"ئ", "ئ"}, {"ى", "ی"}, {"ي", "ی"}, {"ی", "ی"},
        {"0", "۰"}, {"1", "۱"}, {"2", "۲"}, {"3", "۳"}, {"4", "۴"}, {"5", "۵"}, {"6", "۶"}, {"7", "۷"},
        {"8", "۸"}, {"9", "۹"}, {"٠", "۰"}, {"١", "۱"}, {"٢", "۲"}, {"٣", "۳"}, {"٤", "۴"}, {"٥", "۵"},
        {"٦", "۶"}, {"٧", "۷"}, {"٨", "۸"}, {"٩", "۹"}
    };

    for (String[] replacement : replacements) {
      input = input.replace(replacement[0], replacement[1]);
    }

    return input;
  }
}

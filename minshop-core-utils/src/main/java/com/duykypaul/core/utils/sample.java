package com.duykypaul.core.utils;

import java.util.ArrayList;
import java.util.List;

public class sample {
//    public static void main(String[] args) {
//        System.out.println(result("abcdabaaacbdbbbddcceeddbbeeffkkgg", "abcdefgk", 2));
//    }
    public static String result(String str, String strOnly, int maxSize) {
        str = str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        List<String> resultArr = new ArrayList<>();
        String insertStringValue = "";
        for (int i = 0; i < strOnly.length(); i++) {
            insertStringValue = handleInsertStringValue(str, strOnly, i, maxSize)[0];
            str = handleInsertStringValue(str, strOnly, i, maxSize)[1];
            resultArr.add(insertStringValue);
        }
        int i = 0;
        while (i < strOnly.length()) {
            if (str.indexOf(strOnly.charAt(i)) >= 0) {
                insertStringValue = handleInsertStringValue(str, strOnly, i, maxSize)[0];
                str = handleInsertStringValue(str, strOnly, i, maxSize)[1];
                for (int item = strOnly.indexOf(insertStringValue.charAt(0)); item < resultArr.size(); item++) {
                    if (!resultArr.get(item).contains(insertStringValue) || item == resultArr.size() - 1) {
                        resultArr.set(item, resultArr.get(item) + insertStringValue);
                        break;
                    }
                }
            } else {
                i++;
            }
        }
        return resultArr.toString();
    }
    public static String[] handleInsertStringValue(String str, String strOnly, int i, int maxSize) {
        int last = str.lastIndexOf(strOnly.charAt(i));
        int first = str.indexOf(strOnly.charAt(i));
        String insertStringValue;
        if (last - first + 1 >= maxSize) {
            insertStringValue = str.substring(first, maxSize + first);
            str = str.substring(0, first) + str.substring(maxSize + first);
        } else {
            insertStringValue = str.substring(first, last + 1);
            str = str.substring(0, first) + str.substring(last + 1);
        }
        return new String[]{insertStringValue, str};
    }
}

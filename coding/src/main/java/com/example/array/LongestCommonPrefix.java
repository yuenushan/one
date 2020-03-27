package com.example.array;

public class LongestCommonPrefix {

    private String longestCommonPrefix(String str1, String str2) {
        int index = -1;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                index = i;
            } else {
                break;
            }
        }
        return str1.substring(0, index + 1);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
            if (commonPrefix.length() == 0) {
                break;
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix("abc", "bc"));
    }
}

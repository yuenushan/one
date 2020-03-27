package com.example.random;


public class MinimumSwap {
    public int minimumSwap(String s1, String s2) {
        int xyCount = 0;
        int yxCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (s1.charAt(i) == 'x') {
                xyCount++;
            } else {
                yxCount++;
            }
        }
        if (xyCount != yxCount && (xyCount + yxCount) % 2 != 0) {
            return -1;
        }
        return xyCount / 2 + yxCount / 2 + xyCount % 2 * 2;
    }

    public static void main(String[] args) {
//        String s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx";
        String s1 = "xx", s2 = "yy";
        System.out.println(new MinimumSwap().minimumSwap(s1, s2));
    }
}

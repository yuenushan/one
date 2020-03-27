package com.example.array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int jw = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + jw;
            digits[i] = sum % 10;
            jw = sum / 10;
        }
        if (jw > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9})));
    }
}

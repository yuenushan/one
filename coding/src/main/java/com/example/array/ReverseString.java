package com.example.array;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String str = "hello";
        char[] chars = str.toCharArray();
        new ReverseString().reverseString(chars);
        System.out.println(chars);
    }
}

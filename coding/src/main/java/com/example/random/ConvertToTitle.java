package com.example.random;

public class ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.append(convert((n - 1) % 26));
            n = (n - 1) / 26;
        }
        return res.reverse().toString();
    }

    private char convert(int n) {
        return (char) ('A' + n);
    }

    public static void main(String[] args) {
        // 52 => AZ 200
        System.out.println(new ConvertToTitle().convertToTitle(52));
    }
}

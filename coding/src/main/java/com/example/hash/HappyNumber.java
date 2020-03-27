package com.example.hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            int val = quartSum(n);
            if (val == 1) {
                return true;
            }
            set.add(n);
            n = val;
        }
        return false;
    }

    private int quartSum(int num) {
        int sum = 0;
        while (num != 0) {
            int yu = num % 10;
            sum += yu * yu;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}

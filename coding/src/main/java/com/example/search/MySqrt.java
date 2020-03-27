package com.example.search;

public class MySqrt {
    public int mySqrt(int x) {
        return search(0, x, x);
    }

    private int search(int left, int right, int target) {
        int mid = left + (right - left) / 2;
        double midmid = (double) mid * mid;
        if (midmid <= target && (double)(mid+1) * (mid+1) > target) {
            return mid;
        } else if (midmid < target) {
            return search(mid + 1, right, target);
        } else {
            return search(left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
//        System.out.println(mySqrt.mySqrt(0));
//        System.out.println(mySqrt.mySqrt(1));
//        System.out.println(mySqrt.mySqrt(4));
//        System.out.println(mySqrt.mySqrt(8));
        System.out.println(new MySqrt().mySqrt(2147395600));
    }
}

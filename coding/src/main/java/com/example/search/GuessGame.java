package com.example.search;

public class GuessGame {

    private int pick = 6;

    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (true) {
            int mid = left + (right - left) / 2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                return mid;
            } else if (guessResult == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private int guess(int num) {
        if (pick < num) {
            return -1;
        } else if (pick > num) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new GuessGame().guessNumber(10));
    }
}

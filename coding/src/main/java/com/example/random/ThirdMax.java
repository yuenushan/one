package com.example.random;

        import java.util.TreeSet;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            if (treeSet.contains(num)) {
                continue;
            }
            if (treeSet.size() == 3) {
                if (num > treeSet.first()) {
                    treeSet.pollFirst();
                    treeSet.add(num);
                }
            } else {
                treeSet.add(num);
            }
        }
        if (treeSet.size() == 3) {
            return treeSet.first();
        } else {
            return treeSet.last();
        }
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{2, 2, 3, 1}));
    }
}

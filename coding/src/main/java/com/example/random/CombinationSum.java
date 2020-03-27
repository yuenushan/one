package com.example.random;

import java.util.*;

public class CombinationSum {

//    private List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        return combinationSum(candidates, 0, target, new Stack<>());
//    }
//
//    private List<List<Integer>> combinationSum(int[] candidates, int index, int target, Stack<Integer> stack) {
//        if (target == 0) {
//            List<Integer> row = new ArrayList<>(stack);
//            res.add(row);
//            return res;
//        }
//        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
//            System.out.println(i + ": " + target);
//            stack.push(candidates[i]);
//            combinationSum(candidates, i, target - candidates[i], stack);
//            stack.pop();
//        }
//        return res;
//    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        return combinationSum(candidates, 0, target);
//    }
//
//    private List<List<Integer>> combinationSum(int[] candidates, int index, int target) {
//        System.out.println(index + ": " + target);
//        List<List<Integer>> res = new ArrayList<>();
//        if (index >= candidates.length || candidates[index] > target) {
//            return res;
//        }
//        if (candidates[index] == target) {
//            List<Integer> row = new ArrayList<>();
//            row.add(target);
//            res.add(row);
//            return res;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            List<List<Integer>> lists = combinationSum(candidates, i, target - candidates[i]);
//            for (List<Integer> list : lists) {
//                list.add(0, candidates[i]);
//            }
//            res.addAll(lists);
//        }
//        return res;
//    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        return combinationSum(candidates, 0, target);
//    }
//
//    private List<List<Integer>> combinationSum(int[] candidates, int index, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (index >= candidates.length || candidates[index] > target) {
//            return res;
//        }
//        if (candidates[index] == target) {
//            List<Integer> row = new ArrayList<>();
//            row.add(target);
//            res.add(row);
//            return res;
//        }
//        List<List<Integer>> lists = combinationSum(candidates, index, target - candidates[index]);
//        for (List<Integer> list : lists) {
//            list.add(0, candidates[index]);
//        }
//        res.addAll(lists);
//        List<List<Integer>> lists1 = combinationSum(candidates, index + 1, target - candidates[index]);
//        for (List<Integer> list : lists1) {
//            list.add(0, candidates[index]);
//        }
//        res.addAll(lists1);
//        List<List<Integer>> lists2 = combinationSum(candidates, index + 1, target);
//        res.addAll(lists2);
//        return res;
//    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        combinationSum(candidates, 0, target, new LinkedList<>(), res);
        return res;
    }

    private void combinationSum(int[] candidates, int index, int target, List<Integer> prefix, List<List<Integer>> res) {
        if (target == 0) {
            if (!prefix.isEmpty()) {
                List<Integer> item = new LinkedList<>();
                item.addAll(prefix);
                res.add(item);
                return;
            }
        }
        if (index == candidates.length || target < 0) {
            return;
        }
        int candidate = candidates[index];
        for (int i = 0; i <= target / candidate; i++) {
            for (int j = 0; j < i; j++) {
                prefix.add(candidate);
            }
            combinationSum(candidates, index + 1, target - candidate * i, prefix, res);
            for (int j = 0; j < i; j++) {
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}

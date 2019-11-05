package com.example.stack;

import java.util.Stack;

/**
 * 汉诺塔问题：
 * 规则：不能从左(右)直接到右(左)，而是必须经过中间；用递归和非递归两种方式实现
 * 打印最优移动过程和移动总步数
 */
public class HanoiProblem {

    public static void run(int height) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> midStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        leftStack.push(Integer.MAX_VALUE);
        midStack.push(Integer.MAX_VALUE);
        rightStack.push(Integer.MAX_VALUE);
        for (int i = 0; i < height; i++) {
            leftStack.push(height - i);
        }
        int count = 0;
        Step[] currentStep = {Step.NO};
        while (rightStack.size() < height) {
            count += move(leftStack, midStack, currentStep, Step.LM, Step.ML, "left", "mid");
            count += move(midStack, rightStack, currentStep, Step.MR, Step.RM, "mid", "right");
            count += move(midStack, leftStack, currentStep, Step.ML, Step.LM, "mid", "left");
            count += move(rightStack, midStack, currentStep, Step.RM, Step.MR, "right", "mid");
        }
        System.out.println(String.format("总共%d步", count));
    }

    private static int move(Stack<Integer> sourceStack, Stack<Integer> targetStack,  Step[] currentStep, Step targetStep, Step conflictStep, String from , String to) {
        if (sourceStack.peek() < targetStack.peek() && !currentStep[0].equals(conflictStep)) {
            targetStack.push(sourceStack.pop());
            currentStep[0] = targetStep;
            System.out.println(String.format("move %d from %s to %s", targetStack.peek(), from, to));
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        run(3);
    }

}


enum Step {
    NO, LM, ML, RM, MR
}


package com.example.stack;

import java.util.ArrayDeque;

public class TwoStacksQueue<T> {

    private ArrayDeque<T> addingStack = new ArrayDeque<>();
    private ArrayDeque<T> pollingStack = new ArrayDeque<>();

    public void add(T element) {
        addingStack.push(element);
    }

    public T poll() {
        if (pollingStack.isEmpty()) {
            moveStack();
        }
        return pollingStack.pop();
    }

    public T peek() {
        if (pollingStack.isEmpty()) {
            moveStack();
        }
        return pollingStack.peek();
    }

    private void moveStack() {
        if (pollingStack.isEmpty()) {
            while (!addingStack.isEmpty()) {
                pollingStack.push(addingStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }


}

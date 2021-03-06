package com.example.list;

import com.example.util.Math;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static<T> Node<T> createLinkedList(T[] arr) {
        return createLinkedList(arr, false);
    }

    public static <T> Node<T> createCircleList(T[] arr) {
        return createLinkedList(arr, true);
    }

    public static<T> Node<T> createLinkedList(T[] arr, boolean circle) {
        Node<T> head = null;
        Node<T> currentNode = null;
        for (int i = 0; i < arr.length; i++) {
            Node<T> node = new Node<>(arr[i]);
            if (currentNode == null) {
                currentNode = node;
                head = node;
            } else {
                currentNode.next = node;
                currentNode = node;
            }
        }
        if (circle && currentNode != null) {
            currentNode.setNext(head);
        }
        return head;
    }

    public static<T> void printLinkedList(Node<T> head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head + ",");
            head = head.getNext();
        }
        String result = stringBuilder.toString();
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        System.out.println(result);
    }

    public static<T> Node<T> concat(Node<T> head1, Node<T> head2) {
        if (head1 == null || head2 == null) {
            return head1;
        }
        Node<T> lastNode = head1;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = head2;
        return head1;
    }

    public static <T> Node<T> getTail(Node<T> node) {
        if (node == null) {
            return node;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> preNode = null;
        Node<T> curNode = head;
        Node<T> postNode;
        while (curNode != null) {
            postNode = curNode.getNext();
            curNode.setNext(preNode);
            preNode = curNode;
            curNode = postNode;
        }
        return preNode;
    }

    public static <T> Node<T> removeByRatio(Node<T> head, int a, int b) {
        if (a < b) {
            return head;
        }
        int greatestCommonDivisor = Math.greatestCommonDivisor(a, b);
        int x = a / greatestCommonDivisor;
        int y = b / greatestCommonDivisor;
//        int length = length(head);
//        int m = length / y;
//        int n = length % y;
//        Node<T> curNode = head;
//        int step = n > 0 ? m : m-1;
//        if (step <= x) {
//            head = head.getNext();
//        } else {
//            for (int i = 1; i < step * x; i++) {
//                curNode = curNode.getNext();
//            }
//            curNode.setNext(curNode.getNext().getNext());
//        }
        return head;
    }

    public static <T> int length(Node<T> head) {
        int count = 0;
        Node<T> cur = head;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }
        return count;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + (next == null? "null" : next.getValue()) +
                '}';
    }

    public static void main(String[] args) {
        Node<Integer> head = Node.createLinkedList(new Integer[] {1, 2, 3, 4});
        System.out.println(Node.length(head));
    }
}

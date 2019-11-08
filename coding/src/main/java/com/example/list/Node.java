package com.example.list;

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


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + (next == null? "null" : next.getValue()) +
                '}';
    }
}

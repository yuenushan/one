package com.example.list;

public class MyLinkedList {
    /** Initialize your data structure here. */
    private Node head;
    private int length;

    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1: node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        length++;
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        length++;
        Node node = head;
        Node newNode = new Node(val);
        if (node == null) {
            head = newNode;
            return;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        length++;
        Node node = getNode(index - 1);
        Node tmp = node.next;
        node.next = new Node(val);
        node.next.next = tmp;

    }

    private Node getNode(int index) {
        if (head == null) {
            return null;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            if (node == null) {
                return null;
            }
            node = node.next;
        }
        return node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
            length--;
            return;
        }
        Node node = getNode(index - 1);
        if (node == null || node.next == null) {
            return;
        }
        node.next = node.next.next;
        length--;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
    }
}

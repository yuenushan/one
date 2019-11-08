package com.example.list;

public class ReverseList {

    public static void main(String[] args) {
        Node<Integer> head = Node.createLinkedList(new Integer[] {1, 2, 3, 4});
        Node.printLinkedList(Node.reverse(head));

        BiNode<Integer> biHead = BiNode.createLinkedList(new Integer[] {1, 2, 3, 4});
        BiNode.printLinkedList(BiNode.reverse(biHead));
    }
}

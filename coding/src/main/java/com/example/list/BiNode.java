package com.example.list;

public class BiNode<T> extends Node<T>{

    private Node<T> last;

    public BiNode(T value) {
        super(value);
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public static<T> BiNode<T> createLinkedList(T[] arr) {
        BiNode<T> head = null;
        BiNode<T> currentNode = null;
        for (int i = 0; i < arr.length; i++) {
            BiNode<T> node = new BiNode<>(arr[i]);
            if (currentNode == null) {
                currentNode = node;
                head = node;
            } else {
                currentNode.setNext(node);
                node.setLast(currentNode);
                currentNode = node;
            }
        }
        return head;
    }

    @Override
    public String toString() {
        return "BiNode{" +
                "value=" + getValue() +
                ", next=" + (getNext() == null? "null" : getNext().getValue()) +
                ", last=" + (getLast() == null? "null" : getLast().getValue()) +
                '}';
    }

    public static void main(String[] args) {
        BiNode<Integer> head = createLinkedList(new Integer[]{1,2,3,4});
        BiNode.printLinkedList(head);
    }

}

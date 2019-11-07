package com.example.list;

public class DeleteLastKthNode {
    public static<T> Node<T> deleteLastKthNode(Node<T> head, int k) {
        if (k <= 0) {
            return head;
        }
        Node<T> curNode = head;
        while (curNode != null) {
            k--;
            curNode = curNode.getNext();
        }
        if (k == 0) {
            head = head.getNext();
        } else if ( k < 0) {
            curNode = head;
            while (++k < 0) {
                curNode = curNode.getNext();
            }
            curNode.setNext(curNode.getNext().getNext());
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = Node.createLinkedList(new Integer[] {1,2,3,4});
        head = deleteLastKthNode(head, 4);
        Node.printLinkedList(head);
    }

}

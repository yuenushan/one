package com.example.list;

/**
 * 打印两个有序链表的公共部分
 */
public class CommonList {
    public static void printCommonPart(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null || head2 == null) {
            return;
        }
        if (head1.getValue() < head2.getValue()) {
            printCommonPart(head1.getNext(), head2);
        } else if (head1.getValue() > head2.getValue()) {
            printCommonPart(head1, head2.getNext());
        } else {
            while (head1 != null) {
                System.out.println(head1.getValue());
                head1 = head1.getNext();
            }
        }
    }

    public static void main(String[] args) {
        Node<Integer> commonPart = Node.createLinkedList(new Integer[]{5, 6});
        Node<Integer> head1 = Node.createLinkedList(new Integer[]{1, 3});
        Node<Integer> head2 = Node.createLinkedList(new Integer[]{2, 4});
        Node.concat(head1, commonPart);
        Node.concat(head2, commonPart);
        Node.printLinkedList(head1);
        Node.printLinkedList(head2);
        printCommonPart(head1, head2);
    }
}

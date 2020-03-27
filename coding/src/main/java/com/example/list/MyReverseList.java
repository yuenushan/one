package com.example.list;

public class MyReverseList {

//    // 递归
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode second = head.next;
//        ListNode newHead = reverseList(second);
//        second.next = head;
//        head.next = null;
//        return newHead;
//    }

    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

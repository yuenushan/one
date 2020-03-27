package com.example.recursive;

import com.example.list.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode nextNextNode = head.next.next;
        head.next.next = head;
        ListNode listNode = swapPairs(nextNextNode);
        head.next = listNode;
        return nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = new SwapPairs().swapPairs(head);
        System.out.println(newHead);
    }
}


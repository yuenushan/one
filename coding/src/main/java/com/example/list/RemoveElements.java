package com.example.list;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            if (node.val == val) {
                if (pre != null) {
                    pre.next = node.next;
                } else {
                    head = node.next;
                    pre = null;
                }
            } else {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }
}

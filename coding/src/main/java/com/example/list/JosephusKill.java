package com.example.list;

public class JosephusKill {

    // TODO 时间复杂度为O(NM)，待优化
    public static <T> Node<T> survivor(Node<T> head, int m) {
        if (head == null || m <= 0) {
            return head;
        }
        Node<T> curNode = head;
        while (!curNode.getNext().equals(curNode)) {
            for (int i = 1; i < m - 1; i++) {
                curNode = curNode.getNext();
            }
            System.out.println("kill " + curNode.getNext());
            curNode.setNext(curNode.getNext().getNext());
            curNode = curNode.getNext();
        }
        return curNode;
    }

    public static void main(String[] args) {
        Node<Integer> head = Node.createCircleList(new Integer[]{1,2,3,4,5});
        System.out.println(survivor(head, 2));
    }
}

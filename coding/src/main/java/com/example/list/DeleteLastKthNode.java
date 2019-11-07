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
            if (head instanceof BiNode) {
                ((BiNode<T>) head).setLast(null);
            }
        } else if ( k < 0) {
            curNode = head;
            while (++k < 0) {
                curNode = curNode.getNext();
            }
            curNode.setNext(curNode.getNext().getNext());
            if (curNode instanceof BiNode) {
                ((BiNode<T>)curNode.getNext()).setLast(curNode);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = Node.createLinkedList(new Integer[] {1,2,3,4});
        head = deleteLastKthNode(head, 4);
        Node.printLinkedList(head);

        BiNode<Integer> head2 = BiNode.createLinkedList(new Integer[] {1,2,3,4});
        head2 = (BiNode<Integer>) deleteLastKthNode(head2, 4);
        BiNode.printLinkedList(head2);
    }

}

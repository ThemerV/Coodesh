package com.example;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    //Creates node and insert it at the end of the list
    public void insertAtEnd(int data) {

        Node temp = new Node(data);

        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public void removeMiddleNode() {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        //Creates a slow and fast node. The slow node moves 1 at a time while the fast moves 2 at a time. When it reaches the end, the first node will be at the middle element.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
    
        if (prev != null) {
            prev.next = slow.next;
            if (slow.next != null) {
                slow.next.prev = prev;
            } else {
                tail = prev;
            }
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }
        slow.prev = null;
        slow.next = null;
    }
}

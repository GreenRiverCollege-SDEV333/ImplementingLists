package edu.greenriver.sdev333;

import javax.swing.*;

public class Node {
    int data;
    Node next;
    Node prev;
    Node(int givenData) {
        this.data = givenData;
    }

    int countNodes(Node head) {
        // assume that head != null
        int count = 1;
        Node current = head;
        while(current.next != null) {
            current = current.next;
            count += 1;
        }
        return count;
    }
    public static void main(String[] args) {
        Node nodeA = new Node(6);
        Node nodeB = new Node(3);
        Node nodeC = new Node(4);
        Node nodeD = new Node(2);
        Node nodeE = new Node(1);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
    }
}

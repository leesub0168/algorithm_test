package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Doubly_LinkedListTest {

    @Test
    void addNode() {
        Doubly_LinkedList doublyLinkedList = new Doubly_LinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);

        System.out.println(doublyLinkedList.toString());
    }

    @Test
    void removeNode() {
        Doubly_LinkedList doublyLinkedList = new Doubly_LinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);

        doublyLinkedList.removeNode(4);

        System.out.println(doublyLinkedList.toString());
    }

    @Test
    void get_Kth_Node() {
        Doubly_LinkedList doublyLinkedList = new Doubly_LinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(7);

        int k = 3;
        DoubleNode doubleNode = doublyLinkedList.get(k);

        assertEquals(5, doubleNode.val);
    }

    @Test
    void get_first_node() {
        Doubly_LinkedList doublyLinkedList = new Doubly_LinkedList();
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(7);

        DoubleNode node = doublyLinkedList.getFirst();
        assertEquals(1, node.val);
    }
}
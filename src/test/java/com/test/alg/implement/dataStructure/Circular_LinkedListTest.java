package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Circular_LinkedListTest {
    @Test
    void addNode() {
        Circular_LinkedList circularLinkedList = new Circular_LinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.add(5);

        assertEquals(1, circularLinkedList.header.val);
        System.out.println(circularLinkedList.toString());
    }

    @Test
    void removeNode() {
        Circular_LinkedList circularLinkedList = new Circular_LinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.add(3);
        circularLinkedList.add(5);

        int n = 1;
        circularLinkedList.remove(n);

        System.out.println(circularLinkedList.toString());
    }

    @Test
    void get_Kth_node() {
        Circular_LinkedList circularLinkedList = new Circular_LinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.add(3);
        circularLinkedList.add(5);

        int k = 5;
        CircularNode node = circularLinkedList.get(k);

        assertEquals(5, node.val);
    }

    @Test
    void getLength() {
        Circular_LinkedList circularLinkedList = new Circular_LinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.add(3);
        circularLinkedList.add(5);

        int length = circularLinkedList.getLength();
        assertEquals(5,length);
    }
}
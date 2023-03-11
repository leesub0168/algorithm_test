package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Singly_LinkedListTest {

    @Test
    @DisplayName("연결리스트 생성")
    void create() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        System.out.println(singlyLinkedList.retrieve());
    }

    @Test
    @DisplayName("노드 추가")
    void addNode() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        System.out.println(singlyLinkedList.retrieve());
    }

    @Test
    @DisplayName("노드 삭제")
    void remove_node() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);

        singlyLinkedList.remove(1);

        System.out.println(singlyLinkedList.retrieve());
    }

    @Test
    @DisplayName("중복노드 삭제 (버퍼 O)")
    void remove_duplicate_use_buffer() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.removeDuplicate_use_buffer();

        System.out.println(singlyLinkedList.retrieve());
    }

    @Test
    @DisplayName("중복 노드 삭제 (버퍼 X)")
    void remove_duplicate_no_buffer() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.removeDuplicate_no_buffer();

        System.out.println(singlyLinkedList.retrieve());
    }

    @Test
    @DisplayName("n번째 요소 찾기")
    void get_n_node() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);

        int n = 4;
        Node node = singlyLinkedList.get(n);
        assertEquals(2, node.val);
    }

    @Test
    @DisplayName("뒤에서 k 번째 요소 찾기")
    void get_k_node_from_last() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);

        int k = 3;
        assertEquals(singlyLinkedList.getK_from_last(singlyLinkedList.getFirst(), k).val, 3);
    }

    @Test
    @DisplayName("뒤에서 k 번째 요소 찾기 (재귀)")
    void getK_from_last_recurse() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);

        int k = 3;
        Reference r = new Reference();
        Node found = singlyLinkedList.getK_from_last_recurse(singlyLinkedList.getFirst(), k, r);
        assertEquals(found.val, 3);
    }

    @Test
    @DisplayName("뒤에서 k 번째 요소 찾기 (포인터)")
    void getK_from_last_pointer() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);

        int k = 3;
        Node found = singlyLinkedList.getK_from_last_pointer(singlyLinkedList.getFirst(), k);
        assertEquals(found.val, 3);
    }

    @Test
    @DisplayName("리스트의 길이")
    void getLength() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);

        assertEquals(5, singlyLinkedList.getLength());
    }

    @Test
    @DisplayName("두 리스트의 교차점 찾기")
    void getIntersection() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(3);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);


        Singly_LinkedList singlyLinkedList2 = new Singly_LinkedList();
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(5);
        singlyLinkedList2.append(7);
        singlyLinkedList2.append(3);
        singlyLinkedList2.append(2);
        singlyLinkedList2.append(2);

        Node node =
                Singly_LinkedList.getIntersection(singlyLinkedList, singlyLinkedList2);
        assertNotNull(node);
    }

    @Test
    @DisplayName("두 리스트 병합")
    void mergeTwoList() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);


        Singly_LinkedList singlyLinkedList2 = new Singly_LinkedList();
        singlyLinkedList2.append(2);
        singlyLinkedList2.append(3);
        singlyLinkedList2.append(4);
        singlyLinkedList2.append(5);
        singlyLinkedList2.append(6);
        singlyLinkedList2.append(8);

        Singly_LinkedList result =
                Singly_LinkedList.mergeTwoList(singlyLinkedList, singlyLinkedList2);

        System.out.println(result.retrieve());
    }

    @Test
    @DisplayName("리스트 내 루프찾기")
    void findLoop() {
        Singly_LinkedList singlyLinkedList = new Singly_LinkedList();
        singlyLinkedList.append(1);
        singlyLinkedList.append(2);
        singlyLinkedList.append(3);
        singlyLinkedList.append(4);
        singlyLinkedList.append(5);
        singlyLinkedList.append(6);
        singlyLinkedList.append(7);
        singlyLinkedList.append(8);
        Node node4 = singlyLinkedList.get(3);
        Node node8 = singlyLinkedList.get(8);
        node8.next = node4;

        Node result = singlyLinkedList.findLoop();
        assertNotNull(result);
    }
}
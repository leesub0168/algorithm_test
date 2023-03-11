package com.test.alg.implement.dataStructure;

import java.util.HashSet;

class Node {
    int val;
    Node next;
}

class Reference {
    int count;
}

public class Singly_LinkedList {
    Node header;

    public Singly_LinkedList() {
        header = new Node();
    }

    public void append(int d) {
        Node end = new Node();
        end.val = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void remove(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.val == d) {
                n.next = n.next.next;
            }else {
                n = n.next;
            }
        }
    }

    public String retrieve() {
        StringBuilder sb = new StringBuilder();
        Node n = header.next;
        while (n.next != null) {
            sb.append(n.val).append(" -> ");
            n = n.next;
        }
        sb.append(n.val);
        return sb.toString();
    }

    public Node getFirst() {
        return header.next;
    }

    public Node get(int n) {
        Node node = header;
        int cnt = 0;
        while (node.next != null) {
            if (cnt == n) {
                break;
            }else {
                cnt++;
                node = node.next;
            }
        }
        return node;
    }

    public int getLength() {
        int length = 0;
        Node n = header;
        while (n.next != null) {
            length++;
            n = n.next;
        }
        return length;
    }

    public void removeDuplicate_no_buffer() {
        Node n = header;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (r.next.val == n.val) {
                    r.next = r.next.next;
                }else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    public void removeDuplicate_use_buffer() {
        HashSet<Integer> set = new HashSet<>();
        Node n = header;
        while (n.next != null) {
            if (set.contains(n.next.val)) {
                n.next = n.next.next;
            }else {
                set.add(n.next.val);
                n = n.next;
            }
        }
    }

    /** 시간복잡도 O(N) */
    public Node getK_from_last(Node first, int k) {
        Node n = first;
        int total = 1;
        while (n.next != null) {
            total++;
            n = n.next;
        }
        n = first;

        for (int i = 1; i < total - k + 1; i++) {
            n = n.next;
        }
        return n;
    }

    /** 시간복잡도 O(N) */
    public Node getK_from_last_recurse(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }
        Node found = getK_from_last_recurse(n.next, k, r);
        r.count++;

        if (r.count == k) {
            return n;
        }
        return found;
    }

    /**
     * 시간복잡도 O(N)
     */
    public Node getK_from_last_pointer(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /** 두 리스트의 교차점 찾기 */
    public static Node getIntersection(Singly_LinkedList l1, Singly_LinkedList l2) {
        int l1_length = l1.getLength();
        int l2_length = l2.getLength();

        Node l1_node = l1.getFirst();
        Node l2_node = l2.getFirst();


        if (l1_length > l2_length) {
            l1_node = l1.get(l1_length - l2_length);
        }else if(l2_length > l1_length) {
            l2_node = l2.get(l2_length - l1_length);
        }

        while (l1_node != null && l2_node != null) {
            if (l2_node.val == l1_node.val) {
                return l1_node;
            }
            l1_node = l1_node.next;
            l2_node = l2_node.next;
        }
        return null;
    }

    public static Singly_LinkedList mergeTwoList(Singly_LinkedList l1, Singly_LinkedList l2) {
        Singly_LinkedList result = new Singly_LinkedList();
        Node head = result.header;

        Node l1_node = l1.getFirst();
        Node l2_node = l2.getFirst();

        while (l1_node != null && l2_node != null) {
            if (l1_node.val > l2_node.val) {
                head.next = l2_node;
                l2_node = l2_node.next;
            } else {
                head.next = l1_node;
                l1_node = l1_node.next;
            }
            head = head.next;
        }

        if (l1_node != null) {
            head.next = l1_node;
        }else {
            head.next = l2_node;
        }

        return result;
    }

    public Node findLoop() {
        Node first = getFirst();
        Node second = getFirst();

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;

            if (first.val == second.val) {
                break;
            }
        }

        if (second == null || second.next == null) {
            return null;
        }

        first = getFirst();

        while (first.val != second.val) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

}

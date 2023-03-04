package com.test.alg;

import java.math.BigInteger;
import java.util.*;

public class LinkedListNode { // 단방향 연결리스트
    int val;
    LinkedListNode next;

    public LinkedListNode(int val) {
        this.val = val;
    }

    public void append(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int d) {
        LinkedListNode node = this;
        while(node.next != null) {
            if(node.next.val == d) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
    }
    public void retrieve() {
        LinkedListNode node = this;
        while (node.next != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println(node.val);
    }


    public static LinkedListNode mergeTwoLists(LinkedListNode list1, LinkedListNode list2) {
        LinkedListNode result = new LinkedListNode(0);
        LinkedListNode head = result;

        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 != null) {
            head.next = list1;
        }else {
            head.next = list2;
        }
        return result.next;
    }

    public static LinkedListNode deleteDuplicates(LinkedListNode head) {
        LinkedListNode result = head;
        while(result != null && result.next != null) {
            if(result.val == result.next.val) {
                result.next = result.next.next;
            }else {
                result = result.next;
            }
        }
        return head;
    }

    public int removeDuplicates(int[] nums) {
        int pointer = 1;

        if (nums.length < 2) return nums.length;

        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1]) {
                nums[pointer++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return pointer;
    }

    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int [digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() -1;
        int j = b.length() -1;
        int carry =0;

        while(i >=0 || j>=0){
            int sum = carry;

            if(i >=0) sum += a.charAt(i) - '0';
            if(j >=0) sum += b.charAt(j) - '0';

            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
        node.append(1);
        node.append(2);
        node.append(3);
        node.append(3);

        LinkedListNode node1 = new LinkedListNode(1);
        node1.append(3);
        node1.append(4);

        node.retrieve();
//        node.delete(3);
//        node.retrieve();
        deleteDuplicates(node).retrieve();

    }
}

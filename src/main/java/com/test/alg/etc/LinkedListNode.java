package com.test.alg.etc;

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
    public LinkedListNode get(int n) {
        int cnt = 0;
        LinkedListNode node = this;
        while(node.next != null) {
            if(cnt == n) break;
            else {
                cnt++;
                node = node.next;
            }
        }
        if(cnt < n) throw new ArrayIndexOutOfBoundsException();
        return node;
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

    public static int getListLength(LinkedListNode node) {
        int length = 0;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    public static LinkedListNode getIntersectionNode1(LinkedListNode headA, LinkedListNode headB) {

        LinkedListNode first=headA;
        LinkedListNode second=headB;

        while(first!=null && second!=null)
        {
            first=first.next;
            second=second.next;
        }

        LinkedListNode old=null;
        LinkedListNode curr1=null;
        LinkedListNode curr2=null;

        if(first==null)
        {
            curr1=headB;
            old=second;

            curr2=headA;
        }

        if(second==null)
        {
            curr1=headA;
            old=first;

            curr2=headB;
        }

        while(old!=null)
        {
            old=old.next;
            curr1=curr1.next;
        }

        while(curr1!=null && curr2!=null && curr1!=curr2)
        {
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return curr1;
    }

    public static LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
        int cnt1 = getListLength(headA);
        int cnt2 = getListLength(headB);

        if(cnt1 > cnt2) {
            headA = headA.get(cnt1 - cnt2);
        }else if(cnt1 < cnt2) {
            headB = headB.get(cnt2 - cnt1);
        }

        while (headA != null && headB != null) {
            System.out.println(headA);
            System.out.println(headB);
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(4);
        node.append(1);
        node.append(8);
        node.append(4);
        node.append(5);

        LinkedListNode node1 = new LinkedListNode(5);
        node1.append(6);
        node1.append(1);
        node1.append(8);
        node1.append(4);
        node1.append(5);

//        node.retrieve();
//        node.delete(3);
//        node.retrieve();
        System.out.println(getIntersectionNode(node, node1).val);


    }
}

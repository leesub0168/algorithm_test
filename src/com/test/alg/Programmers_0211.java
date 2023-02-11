package com.test.alg;

import java.util.*;

class Prog0211 {
    public int[] duplicate_number(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++) {
            if(stack.isEmpty()){
                stack.add(arr[i]);
            }else {
                int x = stack.peek();
                if(x != arr[i]) {
                    stack.add(arr[i]);
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();

    }
}
public class Programmers_0211 {
    public static void main (String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Prog0211 prog0211 = new Prog0211();
        System.out.println(Arrays.toString(prog0211.duplicate_number(arr)));
    }
}

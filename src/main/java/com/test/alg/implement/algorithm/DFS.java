package com.test.alg.implement.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DFS {
    public int[] dfs(List<Integer>[] lists, int start) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] marked = new boolean[lists.length+1];
        stack.add(start);

        while (!stack.isEmpty()) {
            int x = stack.pop();
            if(marked[x]) continue;
            result.add(x);
            Collections.sort(lists[x], Collections.reverseOrder());
            marked[x] = true;
            for (Integer nxt : lists[x]) {
                if(marked[nxt]) continue;
                stack.add(nxt);
            }

        }

        return result.stream().mapToInt(Integer -> Integer.intValue()).toArray();
    }
}

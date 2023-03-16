package com.test.alg.implement.algorithm;

import java.util.*;

public class BFS {

    public int[] bfs(List<Integer>[] lists, int start) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] marked = new boolean[lists.length + 1];
        queue.add(start);
        marked[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            result.add(x);
            Collections.sort(lists[x]);
            for (Integer nxt : lists[x]) {
                if(marked[nxt]) continue;
                queue.add(nxt);
                marked[nxt] = true;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

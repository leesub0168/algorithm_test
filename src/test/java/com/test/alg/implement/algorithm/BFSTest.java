package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void bfs_test() {
        int vertex = 4;
        int edge = 5;
        List<Integer>[] lists = new ArrayList[vertex+1];
        for (int i = 0; i < vertex+1; i++) {
            lists[i] = new ArrayList<>();
        }

        lists[1].add(2);
        lists[1].add(3);
        lists[1].add(4);
        lists[2].add(4);
        lists[3].add(4);
        int start = 1;

        BFS bfs = new BFS();
        int[] res = bfs.bfs(lists, start);

        System.out.println(Arrays.toString(res));
    }

    @Test
    void bfs_test2() {
        int vertex = 5;
        int edge = 5;
        List<Integer>[] lists = new ArrayList[vertex+1];
        for (int i = 0; i < vertex+1; i++) {
            lists[i] = new ArrayList<>();
        }

        lists[5].add(4);
        lists[4].add(5);
        lists[5].add(2);
        lists[2].add(5);
        lists[1].add(2);
        lists[2].add(1);
        lists[3].add(4);
        lists[4].add(3);
        lists[3].add(1);
        lists[1].add(3);

        BFS bfs = new BFS();
        int start = 1;
        int[] res = bfs.bfs(lists, start);

        System.out.println(Arrays.toString(res));
    }
}
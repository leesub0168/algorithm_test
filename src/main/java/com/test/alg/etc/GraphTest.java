package com.test.alg.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    public void array_directed_graph(BufferedReader br) throws IOException {
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[][] matrix = new int[v][v];

        for (int i=0;i<e;i++) {
            String[] srr = br.readLine().split(" ");
            int u = Integer.parseInt(srr[0]);
            int subV = Integer.parseInt(srr[1]);
            matrix[u-1][subV-1] = 1;
        }

        for (int i=0;i<v;i++) {
            for (int j=0;j<v;j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void array_undirected_graph(BufferedReader br) throws IOException {
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[][] matrix = new int[v][v];

        for (int i=0;i<e;i++) {
            String[] srr = br.readLine().split(" ");
            int u = Integer.parseInt(srr[0]);
            int subV = Integer.parseInt(srr[1]);
            matrix[u-1][subV-1] = 1;
            matrix[subV-1][u-1] = 1;
        }

        for (int i=0;i<v;i++) {
            for (int j=0;j<v;j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void list_directed_graph(BufferedReader br) throws IOException {
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] lists = new ArrayList[v+1];
        for (int i = 1; i < v + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0;i<e;i++) {
            String[] srr = br.readLine().split(" ");
            int u = Integer.parseInt(srr[0]);
            int subV = Integer.parseInt(srr[1]);

            lists[u].add(subV);
        }

        for (int i=1;i< v+1;i++) {
            System.out.printf(i + " : ");
            for (Integer y : lists[i]) {
                System.out.printf(y + " ");
            }
            System.out.println();
        }
    }

    public void list_undirected_graph(BufferedReader br) throws IOException {
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] lists = new ArrayList[v+1];
        for (int i = 1; i < v + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0;i<e;i++) {
            String[] srr = br.readLine().split(" ");
            int u = Integer.parseInt(srr[0]);
            int subV = Integer.parseInt(srr[1]);

            lists[u].add(subV);
            lists[subV].add(u);
        }

        for (int i=1;i< v+1;i++) {
            System.out.printf(i + " : ");
            for (Integer y : lists[i]) {
                System.out.printf(y + " ");
            }
            System.out.println();
        }
    }

    public void bfs(BufferedReader br) throws IOException {
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] lists = new ArrayList[v+1];
        for (int i = 1; i < v + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0;i<e;i++) {
            String[] srr = br.readLine().split(" ");
            int u = Integer.parseInt(srr[0]);
            int subV = Integer.parseInt(srr[1]);

            lists[u].add(subV);
            lists[subV].add(u);
        }

        boolean[] vis = new boolean[10];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        vis[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.peek();
            queue.poll();
            System.out.println(cur);

            for (Integer nxt : lists[cur]) {
                if (vis[nxt]) continue;
                queue.add(nxt);
                vis[nxt] = true;
            }
        }
    }

    /** 백준 11724번 연결 요소의 개수 */
    public void boj_11724(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        ArrayList<Integer>[] lists = new ArrayList[n+1];
        for (int i = 1; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0;i<m;i++) {
            String[] srr = br.readLine().split(" ");
            int u = Integer.parseInt(srr[0]);
            int subV = Integer.parseInt(srr[1]);

            lists[u].add(subV);
            lists[subV].add(u);
        }
        boolean[] vis = new boolean[n+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            cnt++;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            vis[i] = true;

            while (!queue.isEmpty()) {
                int cur = queue.remove();
                for (Integer nxt : lists[cur]) {
                    if (vis[nxt]) continue;
                    queue.add(nxt);
                    vis[nxt] = true;
                }
            }
        }
        System.out.println(cnt);
    }


    /** 백준 1260번 DFS와 BFS */
    StringBuilder sb_1260 = new StringBuilder();
    public void boj_1260(BufferedReader br) throws IOException {
        String[] srr = br.readLine().split(" ");
        int v = Integer.parseInt(srr[0]);
        int e = Integer.parseInt(srr[1]);
        int start = Integer.parseInt(srr[2]);

        ArrayList<Integer>[] lists = new ArrayList[v+1];
        for (int i = 1; i < v + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i=0;i<e;i++) {
            String[] arr = br.readLine().split(" ");
            int v1 = Integer.parseInt(arr[0]);
            int v2 = Integer.parseInt(arr[1]);

            lists[v1].add(v2);
            lists[v2].add(v1);
        }

        boj_1260_dfs(lists, start, v);
        sb_1260.append("\n");
        boj_1260_bfs(lists, start, v);
        System.out.println(sb_1260);
    }
    public void boj_1260_dfs(ArrayList<Integer>[] lists, int start, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[v+1];

        stack.push(start);
        while (!stack.isEmpty()) {
            int x = stack.peek();
            stack.pop();
            if(vis[x]) continue;
            vis[x] = true;
            sb_1260.append(x).append(" ");
            Collections.sort(lists[x], Collections.reverseOrder());
            for (Integer nxt : lists[x]) {
                if(vis[nxt]) continue;
                stack.push(nxt);
            }
        }
    }
    public void boj_1260_bfs(ArrayList<Integer>[] lists, int start, int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[v+1];

        queue.add(start);
        vis[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            sb_1260.append(x).append(" ");
            Collections.sort(lists[x]);
            for (Integer nxt : lists[x]) {
                if(vis[nxt]) continue;
                queue.add(nxt);
                vis[nxt] = true;
            }
        }
    }

}
public class GraphTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Graph graph = new Graph();
//        graph.boj_11724(br);
        graph.boj_1260(br);

    }
}

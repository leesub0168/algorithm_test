package com.test.alg;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class MazePoint {
    int x;
    int y;
    MazePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class TestBFS {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        graph = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<MazePoint> queue = new LinkedList<>();

        queue.add(new MazePoint(0, 0));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            MazePoint point = queue.remove();
            bw.write("(" + point.x + ", " + point.y + ") ->");
            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];
                if(xx >= 0 && yy >= 0 && xx < m && yy < n) {
                    if(graph[yy][xx] != 0 && !visited[yy][xx]) {
                        visited[yy][xx] = true;
                        graph[yy][xx] = graph[point.y][point.x] + 1;
                        queue.add(new MazePoint(xx, yy));
                    }
                }
            }
        }
        bw.write("\n");
        bw.write("\n");
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                bw.write(graph[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write("\n");
        bw.write("\n");
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                bw.write(visited[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(String.valueOf(graph[n][m]));
        bw.flush();
        bw.close();
    }
}

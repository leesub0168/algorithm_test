package com.test.alg;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Test0120 {
    public void painting_1924(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[][] arr = new int[502][502];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] vis = new boolean[502][502];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        ArrayDeque<AbstractMap.SimpleEntry<Integer,Integer>> deque = new ArrayDeque<>();

        deque.push(new AbstractMap.SimpleEntry<>(0,0));
        while (!deque.isEmpty()) {
            AbstractMap.SimpleEntry<Integer,Integer> s = deque.getFirst();
            deque.pop();

            for(int dir=0;dir<4;dir++) {
                int nx = s.getKey() + dx[dir];
                int ny = s.getValue() + dy[dir];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(vis[nx][ny] || arr[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                deque.push(new AbstractMap.SimpleEntry<>(nx,ny));
            }
        }


        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                bw.write(vis[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
public class Algorithm0120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0120 test0120 = new Test0120();
        test0120.painting_1924(br,bw);
    }
}

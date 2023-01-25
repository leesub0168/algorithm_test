package com.test.alg;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Test0120 {
    public void painting_1926(BufferedReader br, BufferedWriter bw) throws IOException {
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
        int mx = 0;
        int num = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(arr[i][j] == 0 || vis[i][j]) continue;
                num++;

                ArrayDeque<AbstractMap.SimpleEntry<Integer,Integer>> deque = new ArrayDeque<>();
                vis[i][j] = true;
                deque.push(new AbstractMap.SimpleEntry<>(i,j));
                int area = 0;
                while (!deque.isEmpty()) {
                    area++;
                    AbstractMap.SimpleEntry<Integer,Integer> s = deque.getFirst();
                    deque.pop();

                    for(int dir=0;dir<4;dir++) {
                        int nx = s.getKey() + dx[dir];
                        int ny = s.getValue() + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || arr[nx][ny] != 1) continue;
                        vis[nx][ny] = true;
                        deque.push(new AbstractMap.SimpleEntry<>(nx,ny));
                    }
                }

                if(mx < area) mx = area;
            }
        }

        bw.write(num + "\n");
        bw.write(mx + "\n");
        bw.flush();
        bw.close();
    }

    public void maze_search_2178(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        int[][] board = new int[102][102];
        int[][] dist = new int[102][102];
        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                dist[i][j] = -1;
            }
        }

        ArrayDeque<AbstractMap.SimpleEntry<Integer,Integer>> Q = new ArrayDeque<>();
        Q.push(new AbstractMap.SimpleEntry<>(0,0));
        dist[0][0] = 0;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!Q.isEmpty()) {
            AbstractMap.SimpleEntry<Integer,Integer> cur = Q.getFirst();
            Q.pop();
            bw.write("(" + cur.getKey() + ", " + cur.getValue() + ") ->");
            for(int dir=0;dir<4;dir++) {
                int nx = cur.getKey() + dx[dir];
                int ny = cur.getValue() + dy[dir];
                if(nx < 0 || nx > m || ny < 0 || ny > n) continue;
                if(dist[ny][nx] >= 0 || board[ny][nx] != 1) continue;
                dist[ny][nx] = dist[cur.getValue()][cur.getKey()] + 1;
                Q.push(new AbstractMap.SimpleEntry<>(nx,ny));
            }
        }
        bw.write((dist[n-1][m-1])+"");
        bw.flush();
        bw.close();
    }
}
public class Algorithm0120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0120 test0120 = new Test0120();
        test0120.maze_search_2178(br,bw);
    }
}



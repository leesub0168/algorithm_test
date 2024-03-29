package com.test.alg.etc;

import java.io.*;
import java.util.*;

public class BFSTest {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] board = new int[502][502];
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        board[0][4] = 1;
        board[1][0] = 1;
        board[1][4] = 1;
        board[2][0] = 1;
        board[2][1] = 1;
        board[2][2] = 1;
        board[2][4] = 1;
        board[3][0] = 1;
        board[3][1] = 1;
        board[3][4] = 1;
        board[4][1] = 1;

        boolean[][] vis = new boolean[502][502];
        int n = 7, m = 10;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};


//        vis[0][0] = true;
//
//        Q.push(new Pair(0,0));
//        while (!Q.isEmpty()) {
//            Pair cur = Q.getFirst();
//            Q.pop();
//            bw.write("(" + cur.getKey() + ", " + cur.getValue() + ") ->");
//
//            for (int dir = 0; dir < 4;dir++) {
//                int nx = cur.getKey() + dx[dir];
//                int ny = cur.getValue() + dy[dir];
//                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
//                if(vis[nx][ny] || board[nx][ny] != 1) continue;
//                vis[nx][ny] = true;
//                Q.push(new Pair(nx,ny));
//            }
//        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == 0 || vis[i][j]) continue;
                ArrayDeque<Pair> Q = new ArrayDeque<>();
                vis[i][j] = true;
                Q.push(new Pair(i,j));

                while (!Q.isEmpty()) {
                    Pair cur = Q.getFirst();
                    Q.pop();
                    bw.write("(" + cur.getKey() + ", " + cur.getValue() + ") ->");

                    for (int dir = 0; dir < 4;dir++) {
                        int nx = cur.getKey() + dx[dir];
                        int ny = cur.getValue() + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || board[nx][ny] != 1) continue;
                        vis[nx][ny] = true;
                        Q.push(new Pair(nx,ny));
                    }
                }
            }
        }
        bw.write("\n");
        bw.write("\n");

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

package com.test.alg;

import java.io.*;
import java.util.*;

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

        int[][] board = new int[n+1][m+1];
        boolean[][] vis = new boolean[n+1][m+1];

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        Queue<EntryPair> deque = new LinkedList<>();
        deque.add(new EntryPair(0,0));
        vis[0][0] = true;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while (!deque.isEmpty()) {
            EntryPair pair = deque.remove();
            for(int dir=0;dir<4;dir++) {
                int xx = pair.x + dx[dir];
                int yy = pair.y + dy[dir];

                if(xx >= 0 && yy >= 0 && xx < m && yy < n) {
                    if(board[yy][xx] != 0 && !vis[yy][xx]) {
                        vis[yy][xx] = true;
                        board[yy][xx] = board[pair.y][pair.x] + 1;
                        deque.add(new EntryPair(xx,yy));
                    }
                }
            }
        }

        bw.write(board[n-1][m-1]+"");
        bw.flush();
        bw.close();
    }
}
class EntryPair {
    int x;
    int y;

    public EntryPair(int x, int y)  {
        this.x = x;
        this.y = y;
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



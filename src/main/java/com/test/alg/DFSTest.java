package com.test.alg;


import java.io.BufferedReader;
import java.util.Stack;

class DFS {
    public void practice() {
        int[][] board = new int[502][502];
        boolean[][] vis = new boolean[502][502];
        int n = 7, m = 10;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Stack<EntryPair> stack = new Stack<>();
        stack.push(new EntryPair(0,0));
        vis[0][0] = true;

        while (!stack.isEmpty()) {
            EntryPair pair = stack.pop();
            System.out.println("("+pair.x + ", " + pair.y + ") -> ");
            for(int i=0;i<4;i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(vis[nx][ny]) continue;
//                if(vis[nx][ny] || board[nx][ny] != 1) continue;
                vis[nx][ny] = true;
                stack.push(new EntryPair(nx,ny));
            }
        }
    }
}

public class DFSTest {
    public static void main(String[] args) throws Exception {
        DFS dfs = new DFS();
        dfs.practice();
    }
}

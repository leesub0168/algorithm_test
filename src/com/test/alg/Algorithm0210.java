package com.test.alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Test0210 { // 시뮬레이션

    int[][] arr;
    public void cctv_15683(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[10][10];
        int[][] dist = new int[10][10];
        Queue<EntryPair> queue = new ArrayDeque<>();

        for(int i=0;i<n;i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

                if(arr[i][j] != 6 && arr[i][j] != 0) {
                    queue.add(new EntryPair(i, j));
                }else {
                    dist[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            EntryPair pair = queue.remove();

        }

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Algorithm0210 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Test0210 test0210 = new Test0210();
        test0210.cctv_15683(br);
    }
}

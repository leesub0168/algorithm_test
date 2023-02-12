package com.test.alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DP {
    public int make_one(BufferedReader br) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int[] dim = new int[x+2];

        for(int i=2;i<=x;i++) {
            dim[i] = dim[i-1]+1;
            if(i % 2 == 0) dim[i] = Math.min(dim[i], dim[i / 2] + 1);
            if(i % 3 == 0) dim[i] = Math.min(dim[i], dim[i / 3] + 1);
        }

        return dim[x];
    }

    public void plus_numbers_9095(BufferedReader br) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            int x = Integer.parseInt(br.readLine());
            int[] dim = new int[12];
            dim[1] = 1;
            dim[2] = 2;
            dim[3] = 4;

            for(int j=4;j<=x;j++) {
                dim[j] = dim[j - 1] + dim[j - 2] + dim[j - 3];
            }
            System.out.println(dim[x]);
        }
    }

}
public class DynamicProgramming {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DP dp = new DP();
        dp.plus_numbers_9095(br);
    }
}

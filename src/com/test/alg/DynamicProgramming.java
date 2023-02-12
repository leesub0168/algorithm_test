package com.test.alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DP {
    int x;
    int[] dim;
    public int make_one(BufferedReader br) throws IOException {
        x = Integer.parseInt(br.readLine());
        dim = new int[x+2];

        for(int i=2;i<=x;i++) {
            dim[i] = dim[i-1]+1;
            if(i % 2 == 0) dim[i] = Math.min(dim[i], dim[i / 2] + 1);
            if(i % 3 == 0) dim[i] = Math.min(dim[i], dim[i / 3] + 1);
        }

        return dim[x];
    }

}
public class DynamicProgramming {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        DP dp = new DP();
        System.out.println(dp.make_one(br));
    }
}

package com.test.alg;

public class TimeComplexity {
    public int func1(int arr[], int n) {
        int cnt = 0;
        for(int i=0;i<n;i++) {
            if(arr[i] % 5 == 0) cnt++;
        }
        return cnt;
    }
}

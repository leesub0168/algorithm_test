package com.test.alg.etc;

class Glass {
    public int solution(int N, int K) {
        if (N >= K) {
            return 1;
        }else {
            int val = K;
            int cnt = 0;
            for (int i = N; i > 0; i--) {
                if(val >= i) {
                    val -= i;
                    cnt++;
                }
            }
            if (val == 0) {
                return cnt;
            }else {
                return -1;
            }
        }
    }
}
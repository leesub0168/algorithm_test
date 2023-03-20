package com.test.alg.implement.math;

import java.util.*;

/** 약수 */
public class Divisor {

    public int[] divisorList(int x) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= x; i++) {
            if(x % i == 0) {
                list.add(i);
                if(i != (x / i)) {
                    list.add(x / i);
                }
            }
        }

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 최대공약수
     * - 유클리드 호제법
     *   두 수 A,B에 대해 A를 B로 나눈 나머지를 r이라고 하면 GCD(A,B) = GCD(B,r)이다.
     *   GCD(20,12) = GCD(12,8) = GCD(8,4) = GCD(4,0) = 4
     * */
    public int GCD(int num1, int num2) {
        if(num2 == 0) return num1;
        return GCD(num2, num1 % num2);
    }

    /**
     * 최소공배수
     * A * B = GCD(A,B) * LCM(A,B)
     * */
    public int LCM(int num1, int num2) {
        return num1 / GCD(num1, num2) * num2;
    }
}

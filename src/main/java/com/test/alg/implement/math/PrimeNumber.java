package com.test.alg.implement.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    /**
     * 시간복잡도 O(√n) , n이 10^12까진 처리가능
     * */
    public boolean isPrime(int n) {
        if(n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public int[] primeList(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (Integer x : list) {
                if(x * x > i) break;
                if(i % x == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /** 에라토스테네스의 체 */
    public int[] sieve_of_eratosthenes(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] state = new boolean[n + 1];
        Arrays.fill(state,true);
        state[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if(!state[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                state[j] = false;
            }
        }
        for (int i = 2; i <= n; i++) {
            if(state[i]) list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     *  시간복잡도 O(√n), n이 10^12까진 처리가능
     * */
    public int[] prime_factorization(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }
        if(n != 1) list.add(n);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

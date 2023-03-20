package com.test.alg.implement.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    @Test
    @DisplayName("소수판별")
    void decimal_test() {
        int x = 5;
        PrimeNumber primeNumber = new PrimeNumber();

        assertTrue(primeNumber.isPrime(x));
    }

    @Test
    @DisplayName("범위내의 소수 판별")
    void range_decimal_test() {
        int x = 5;
        PrimeNumber primeNumber = new PrimeNumber();
        int[] res = primeNumber.primeList(x);
        assertEquals(3, res.length);
    }

    @Test
    @DisplayName("범위내의 소수 판별 - 에라토스테네스의 체")
    void sieve_of_eratosthenes() {
        int x = 5;
        PrimeNumber primeNumber = new PrimeNumber();
        int[] res = primeNumber.sieve_of_eratosthenes(x);
        assertEquals(3, res.length);
    }

    @Test
    @DisplayName("소인수분해")
    void prime_factorization () {
        int x = 1100;
        PrimeNumber primeNumber = new PrimeNumber();
        int[] res = primeNumber.prime_factorization(x);
        System.out.println(Arrays.toString(res));
        assertEquals(5, res.length);
    }
}
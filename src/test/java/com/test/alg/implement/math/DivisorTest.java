package com.test.alg.implement.math;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DivisorTest {

    @Test
    @DisplayName("약수 구하기")
    void divisor() {
        int x = 18;
        Divisor divisor = new Divisor();
        int[] res = divisor.divisorList(x);

        assertEquals(6, res.length);
    }

    @Test
    @DisplayName("제곱수의 약수 구하기")
    void divisor_square() {
        int x = 16;
        Divisor divisor = new Divisor();
        int[] res = divisor.divisorList(x);

        assertEquals(5, res.length);
    }

    @Test
    @DisplayName("최대 공약수 구하기")
    void GCD_Greatest_Common_Divisor() {
        int num1 = 20;
        int num2 = 12;
        Divisor divisor = new Divisor();
        int res = divisor.GCD(num1, num2);

        assertEquals(4, res);
    }

    @Test
    @DisplayName("최소 공배수 구하기")
    void LCM_Least_Common_Multiple() {
        int num1 = 20;
        int num2 = 12;
        Divisor divisor = new Divisor();
        int res = divisor.LCM(num1, num2);

        assertEquals(60, res);
    }
}
package com.test.alg.etc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlassTest {

    @Test
    @DisplayName("K 값이 N까지 수의 합으로 구할 수 없는 경우")
    void test_glass_not_include() {
        int N = 5;
        int K = 153;

        Glass glass = new Glass();

        int res = glass.solution(N, K);

        assertEquals(-1, res);

    }

    @Test
    @DisplayName("K 값이 N까지 수의 합으로 구할 수 있는 경우")
    void test_glass_include() {
        int N = 5;
        int K = 10;

        Glass glass = new Glass();

        int res = glass.solution(N, K);

        assertEquals(3, res);

    }
}
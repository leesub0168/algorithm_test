package com.test.alg.implement.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChineseRemainderTheoremTest {

    @Test
    void how_many_student() {
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int res = chineseRemainderTheorem.how_many_students();

        assertEquals(27, res);
    }

    @Test
    void what_is_remainder() {
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int res = chineseRemainderTheorem.what_is_remainder();

        assertEquals(14, res);
    }

    @Test
    @DisplayName("백준 6064번 - 카잉달력")
    void cain_calendar() {
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int n = 13;
        int m = 11;
        int x = 5;
        int y = 6;

        int res = chineseRemainderTheorem.cain_calendar(n, m, x, y);
        assertEquals(83, res);
    }

    @Test
    @DisplayName("백준 12971번 - 숫자놀이")
    void number_playing() {
        int p1 = 20, p2 = 20, p3 = 20, x1 = 1, x2 = 2, x3 = 3;
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int res = chineseRemainderTheorem.tree_numbers(p1, p2, p3, x1, x2, x3);

        assertEquals(-1, res);
    }

}
package com.test.alg.implement.math;

/**
 *
 *  합동식
 *  x ≡ a (mod n) --> x를 n으로 나누면 a와 같다.
 *
 *  중국인의 나머지 정리
 *  x ≡ 1 (mod 3) <- 해석 : x를 3으로 나누면 나머지가 1이다.
 *  x ≡ 1 (mod 5) <- 해석 : x를 5으로 나누면 나머지가 1이다.
 *  따라서, x ≡ 1 (mod 15)가 성립한다.
 *
 * */
public class ChineseRemainderTheorem {

    /**
     * x ≡ 2 (mod 3)이고 x ≡ 4 (mod 5)일 때 x ≡ a (mod 15)가 있다고 가정하다. a의 값은 무엇인가?
     * ans : 14
     */
    public int what_is_remainder() {
        for (int i = 5; i < 15; i += 3) {
            if (i % 5 == 4) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 6명씩 조를 짰을때 3명이 남았다.
     * 5명씩 조를 짰을때 2명이 남았다.
     * 학생은 30명 미만이다.
     *
     * 해당 반의 학생은 몇명인가?
     * */
    public int how_many_students() {
        for (int i = 3; i < 30; i+=6) {
            if(i % 5 == 2) return i;
        }
        return -1;
    }

    /**
     * 카잉 달력
     */

    public int GCD(int num1, int num2) {
        if(num2 == 0) return num1;
        return GCD(num2, num1 % num2);
    }

    public int LCM(int num1, int num2) {
        return num1 / GCD(num1, num2) * num2;
    }

// 10 12 3 9
    public int cain_calendar(int n, int m, int x, int y) {
        if(x == n) x = 0;
        if(y == m) y = 0;
        int last = LCM(n, m);
        for (int i = 1; i <= last; i++) {
            if(i % m == y && i % n == x) return i;
        }
        return -1;
    }
}

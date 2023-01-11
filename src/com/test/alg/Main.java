package com.test.alg;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

class Some {
    int num = 1;
}

public class Main {
    public void solution(int num) {
        int max = 0;
        for(int i=0;i<=num;i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                max += i;
            }
        }
        System.out.println(max);
    }

    public int solution2(int[] arr, int num) {

        for(int i=0;i<num;i++) {
            int arrVal = arr[i];
            for(int j=0;j<num;j++) {
                if(j != i && arrVal + arr[j] == 100) return 1;
            }
        }
        return 0;
    }

    public int solution3(int num) {

        for(int i=1;i*i<=num;i++) {
            if(i*i == num) return 1;
        }
        return 0;
    }

    public int solution4(int num) {
        int max = 1;
        while (2 * max <= num) max *= 2;
        return max;
    }

    public void intergerOverflow() {
        double x = 0.1+0.1+0.1;
        double y = 0.3;
        if(x==y) {
            System.out.println("yes");
        }
        if(Math.abs(x-y) < 1e-12) {
            System.out.println("yes2");
        }
        /** Result --> yes2 **/
    }

    public void test(int a) {
        a = 5;
    }
    public void plus100(Some some) {
        some.num += 100;
    }
    public void vectorSet(Vector<Integer> vec) {
        vec.set(1,7);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        if((num % 4 == 00 && num % 100 != 0) || num % 400 == 0) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }


//        Main test = new Main();
//        test.solution(num);
//        System.out.println(test.solution4(97615282));

//        int x = 0;
//        test.test(x);
//        System.out.println(x);


    }
}

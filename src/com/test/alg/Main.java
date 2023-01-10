package com.test.alg;

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

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int num = scanner.nextInt();

        Main test = new Main();
//        test.solution(num);
        System.out.println(test.solution4(97615282));

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
}

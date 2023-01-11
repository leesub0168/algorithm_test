package com.test.alg;

import java.util.*;

public class Algorithm0111 {

    // 백준 10871번
   public void numberCompare(Scanner sc) {
        int num = sc.nextInt();
        int defaultNum = sc.nextInt();
        for(int i=0;i<num;i++) {
            int x = sc.nextInt();
            if(x < defaultNum) {
                System.out.print(x + " ");
            }
        }
    }

    // 백준 1000번
    public void numberPlus(Scanner sc) {
        System.out.println(sc.nextInt() + sc.nextInt());
    }

    // 백준 10171번
    public void helloWorld() {
        System.out.println("Hello World!");
    }

    // 백준 10171번
    public void cat() {
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }

    // 백준 10869번
    public void calculate(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
    }

    // 백준 9498번
    public void score(Scanner sc) {
        int x = sc.nextInt();

        if(x >= 90) {
            System.out.print("A");
            return;
        }
        if(x >= 80) {
            System.out.print("B");
            return;
        }
        if(x >= 70) {
            System.out.print("C");
            return;
        }
        if(x >= 60) {
            System.out.print("D");
            return;
        }
        System.out.print("F");
    }

    // 백준 2752번
    public void sort(Scanner sc) {
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();

        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }

    // 백준 2753번
    public void leapYear(Scanner sc) {
        int num = sc.nextInt();
        if((num % 4 == 00 && num % 100 != 0) || num % 400 == 0) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    //백준 2480번
    public void dice(Scanner sc) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int[] arr = {x,y,z};
        Arrays.sort(arr);

        if(x == y && y == z) {
            System.out.println(10000 + (x * 1000));
            return;
        }
        if(x == y || x == z) {
            System.out.println(1000 + (x * 100));
            return;
        }
        if(y == z) {
            System.out.println(1000 + (y * 100));
            return;
        }

        System.out.println(arr[2] * 100);
    }
    public void dice2(Scanner sc) {
        int[] arr = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
        Arrays.sort(arr);

        if(arr[0] == arr[2]) {
            System.out.println(10000 + (arr[0] * 1000));
            return;
        }
        if(arr[0] == arr[1] || arr[1] == arr[2]) {
            System.out.println(1000 + (arr[1] * 100));
            return;
        }

        System.out.println(arr[2] * 100);
    }

    //백준 2490번
    public void playingYut(Scanner sc) {
        String t = "";
        while (sc.hasNext()) {
            t = sc.nextLine().replaceAll(" ","");

            if(t.length() == 4) {
                if(t.replaceAll("0","").length() == 4) {
                    System.out.println("E");
                }else if(t.replaceAll("0","").length() == 3) {
                    System.out.println("A");
                }else if(t.replaceAll("0","").length() == 2) {
                    System.out.println("B");
                }else if(t.replaceAll("0","").length() == 1) {
                    System.out.println("C");
                }else if(t.replaceAll("0","").length() == 0) {
                    System.out.println("D");
                }
            }

        }
    }
    public void playingYut2(Scanner sc) {
        int res = 0, input = 0;
        String result = "DCBAE";
        for(int i=0;i<3;i++) {
            res = 0;
            for(int j=0;j<4;j++) {
                res += sc.nextInt();
            }
            System.out.println(result.charAt(res));
        }
    }

    // 백준 2576번
    public void oddNumber(Scanner sc) {
        int sum = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<7;i++) {
            int num = sc.nextInt();
            if(num % 2 != 0) {
                sum += num;
                if(min > num) min = num;
            }
        }
        if(sum > 0) {
            System.out.println(sum);
            System.out.println(min);
        }else {
            System.out.println(-1);
        }
    }
    // 백준 2587번
    public void representNum(Scanner sc) {
        int sum = 0;
        int[] arr = new int[5];
        for(int i=0;i<5;i++) {
            int num = sc.nextInt();
            sum += num;
            arr[i] = num;
        }
        Arrays.sort(arr);
        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }

    // 백준 2309번
    public void findDwarf(Scanner sc) {
        int[] arr = new int[9];
        int[] arr2 = new int[7];
        for(int i=0;i<9;i++) {
            arr[i] = sc.nextInt();
        }

        int idx = 0, total = 0;
        for(int i=0;i<9;i++) {
            for(int j=i+1;j<9;j++) {
                idx = 0;
                total = 0;
                for(int x=0;x<9;x++) {
                    if(x != i && x != j) {
                        arr2[idx] = arr[x];
                        idx++;
                    }
                }

                for(int y=0;y<7;y++) {
                    total += arr2[y];
                }
                if(total == 100) break;

            }
            if(total == 100) break;
        }

        Arrays.sort(arr2);

        for(int i=0;i<7;i++) {
            System.out.println(arr2[i]);
        }
    }

    // 백준 10093번 100점
    public void numbers(Scanner sc) {
       long num1 = sc.nextLong();
       long num2 = sc.nextLong();
       long num3;
       List<Long> arrayList = new ArrayList<>();

       if(num1 > num2){
           num3 = num2;
           num2 = num1;
           num1 = num3;
       }

       for(long i=num1+1;i<num2;i++) {
           arrayList.add(i);
       }

       Long[] arr = arrayList.toArray(new Long[arrayList.size()]);
       Arrays.sort(arr);
       System.out.println(arr.length);
       for(int i=0;i<arr.length;i++) {
           System.out.print(arr[i] + " ");
       }
    }
    // 30점
    public void numbersInt(Scanner sc) {
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3;

        if(num1 > num2){
            num3 = num2;
            num2 = num1;
            num1 = num3;
        }

        if(num1 == num2) {
            num3 = 0;
        }else {
            num3 = num2 - num1 -1;
        }
        int[] arr = new int[num3];

        int idx = 0;
        for(int i=num1+1;i<num2;i++) {
            arr[idx] = i;
            idx++;
        }

        Arrays.sort(arr);
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 백준 1267번
    public void cellPhone(Scanner sc) {
        int callCount = sc.nextInt();
        int[] arr = new int[callCount];
        for(int i=0;i<callCount;i++) {
            arr[i] = sc.nextInt();
        }

        int priceY = 0;
        int priceM = 0;

        for(int i=0;i<callCount;i++) {
            int y = (int) Math.ceil(arr[i] / 30.0);
            int m = (int) Math.ceil(arr[i] / 60.0);

            if(arr[i] % 30 == 0) y++;
            if(arr[i] % 60 == 0) m++;

            priceY += (y * 10);
            priceM += (m * 15);
        }

        if(priceY == priceM) {
            System.out.print("Y M " + priceM);
            return;
        }
        if(priceY < priceM) {
            System.out.print("Y " + priceY);
            return;
        }
        if(priceM < priceY) {
            System.out.print("M " + priceM);
        }

    }
    // 1267번 정답버전
    public void cellPhone2(Scanner sc) {
        int callCount = sc.nextInt();
        int[] arr = new int[callCount];

        for(int i=0;i<callCount;i++) {
            arr[i] = sc.nextInt();
        }
        int priceY = 0, priceM = 0;

        for(int i=0;i<callCount;i++) {
            priceY += ((arr[i]/30) + 1) * 10;
            priceM += ((arr[i]/60) + 1) * 15;
        }
        if(priceY == priceM) {
            System.out.print("Y M " + priceM);
        }else if(priceY < priceM) {
            System.out.print("Y " + priceY);
        }else {
            System.out.print("M " + priceM);
        }
    }

    // 백준 10804번
    public void cardReverse(Scanner sc) {
       int[] arr = new int[20];
       for(int i=0;i<20;i++) {
           arr[i] = i+1;
       }
       for(int x=0;x<10;x++) {
           int str = sc.nextInt();
           int end = sc.nextInt();
           int count = (int) Math.ceil((end-str)/2.0);
           for(int i=0;i<count;i++) {
               int tmpEnd = arr[end-i - 1];
               arr[end-i -1] = arr[str+i - 1];
               arr[str+i -1] = tmpEnd;
           }
       }
        for(int i=0;i<20;i++) {
            System.out.print(arr[i] + " ");
        }
    }
    // 10804번 swap사용 버전
    public void cardReverseSwap(Scanner sc) {
       ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1;i<=20;i++) {
            arrayList.add(i);
        }
        for(int x=1;x<=10;x++) {
            int str = sc.nextInt(), end = sc.nextInt();
            for(int i=0;i<(end-str+1)/2;i++) {
                Collections.swap(arrayList, str+i-1, end-i-1);
            }
        }

        for(Integer x : arrayList) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Algorithm0111 alg = new Algorithm0111();
        alg.cardReverseSwap(sc);

    }
}

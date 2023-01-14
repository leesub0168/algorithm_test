package com.test.alg;

import java.util.*;
import java.io.*;

class ArrayTest {
    int[] arr = new int[10];
    int len;

    void insert(int idx, int num, int[] arr) {
        int tmp = 0;
        for(int i=len;i>idx;i--) {
            arr[i] = arr[i-1];
        }
        arr[idx] = num;
        len++;
    }
    void erase(int idx, int[] arr) {
        len--;
        arr[idx] = 0;
        for(int i=idx;i<len;i++) {
            arr[i] = arr[i+1];
        }
    }
    void printArr(int[] arr) {
        for(int i=0;i<len;i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println("\n");
    }
    void insert_test() {
        System.out.println("****** insert_test *********");
        arr[0] = 10; arr[1] = 20; arr[2] = 30;
        len = 3;
        insert(3,40,arr);
        printArr(arr);
        insert(1,50,arr);
        printArr(arr);
        insert(0,15,arr);
        printArr(arr);
    }
    void erase_test() {
        System.out.println("****** erase_test *********");
        arr[0] = 10; arr[1] = 50; arr[2] = 40;
        arr[3] = 30; arr[4] = 70; arr[5] = 20;
        len = 6;
        erase(4,arr);
        printArr(arr);
        erase(1,arr);
        printArr(arr);
        erase(3,arr);
        printArr(arr);

    }
}

class Test {
    // 백준 15552번
    public void numberPlusFast(BufferedReader br, BufferedWriter bw) throws IOException {
        int count = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<count;i++) {
            String txt = br.readLine();
            String[] txtArr = txt.split(" ");
            int num1 = Integer.parseInt(txtArr[0]);
            int num2 = Integer.parseInt(txtArr[1]);
            sb.append((num1 + num2) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    // StringTokenizer 사용버전. 메모리 소모량이 더 적고 빠르다.
    public void numberPlusFastStringToken(BufferedReader br, BufferedWriter bw) throws IOException {
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<count;i++) {
            st = new StringTokenizer(br.readLine());
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2438번
    public void printStar1(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=1;i<=count;i++) {
            for(int j=0;j<i;j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2439번
    public void printStar2(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++) {
            int j=0;
            for(;j<count-i-1;j++) {
                bw.write(" ");
            }
            for(;j<count;j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2440번
    public void printStar3(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++) {
            for(int j=0;j<count - i;j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2441번
    public void printStar4(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++) {
            int j=0;
            for(;j<i;j++) {
                bw.write(" ");
            }
            for(;j<count ;j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2442번
    public void printStar5(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++) {
            int j=0;
            for(;j<count-i-1;j++) {
                bw.write(" ");
            }
            for(;j<count+i;j++) {
                bw.write("*");
            }

            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    // 풀이버전
    public void printStar5_2(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=1;i<=count;i++) {
            for(int j=1;j<=count-i;j++) {
                bw.write(" ");
            }
            for(int j=1;j<=2 * i -1;j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    // 백준 2442번 repeat 사용 버전 (java11부터 가능)
    public void printStar5_repeat(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++) {
            bw.write(" ".repeat(count - (i+1)));
            bw.write("*".repeat(i * 2 +1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2443번
    public void printStar6(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<=count;i++) {
            for(int j=0;j<i;j++) {
                bw.write(" ");
            }
            for(int j=1;j<=(2 * (count-i) -1);j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    // 백준 2443번 repeat 사용 버전 (java11부터 가능)
    public void printStar6_repeat(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++) {
            bw.write(" ".repeat(i));
            bw.write("*".repeat(2 * (count - i) -1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 2444번
    public void printStar7(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=1;i<=count;i++) {
            for(int j=1;j<=count-i;j++) {
                bw.write(" ");
            }
            for(int j=1;j<=2 * i -1;j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for(int i=1;i<=count;i++) {
            for(int j=0;j<i;j++) {
                bw.write(" ");
            }
            for(int j=1;j<=(2 * (count-i) -1);j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    // 백준 2444번 repeat 사용 버전 (java11부터 가능)
    public void printStar7_repeat(BufferedReader br, BufferedWriter bw) throws Exception {
        int count = Integer.parseInt(br.readLine());
        for(int i=1;i<=count;i++) {
            bw.write(" ".repeat(count-i));
            bw.write("*".repeat(2 * (i) -1));
            bw.write("\n");
        }
        for(int i=1;i<count;i++) {
            bw.write(" ".repeat(i));
            bw.write("*".repeat(2 * (count - i) -1));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 10808번
    public void alphabetCount(BufferedReader br, BufferedWriter bw) throws IOException {
        String s = br.readLine();
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i : arr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
    // 백준 10808번 풀이버전
    public void alphabetCount2(BufferedReader br, BufferedWriter bw) throws IOException {
        String s = br.readLine();
        for(char a='a';a<='z';a++) {
            int cnt = 0;
            for(int i=0;i<s.length();i++) {
                if(a == s.charAt(i)) cnt++;
            }
            bw.write(cnt + " ");
        }
        bw.flush();
        bw.close();
    }

    public int func2(int[] arr, int n) { // int[] arr = {1,23,53,77,60}; int n = 5;
        int[] arr2 = new int[n+1];
        for(int i=0;i<n;i++) {
            arr2[i] = arr[i];
        }
        for(int i=0;i<n;i++) {
            if (arr2[i] + arr2[i+1] == 100) return 1;
        }
        return 0;
    }
    public int func2_answer(int[] arr, int n) {
        int[] occur = new int[101];
        for(int i=0;i<n;i++) {
            if(occur[100-arr[i]] == 1) return 1;
            occur[arr[i]] = 1;
        }
        return 0;
    }

    // 백준 2577번
    public void numberCount(BufferedReader br, BufferedWriter bw) throws IOException{
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a*b*c;
        int[] arr = new int[10];

        while (sum > 0) {
            arr[sum%10]++;
            sum/=10;
        }
        for(int i=0;i<10;i++) {
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    // 백준 1475번
    public void roomNumber(BufferedReader br, BufferedWriter bw) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (a > 0) {
            arr[a%10]++;
            a/=10;
        }
        int max = 0;
        for(int i=0;i<10;i++) {
            if(max < arr[i])  {
                max = arr[i];
                if(i == 6 || i == 9) {
                    max = (arr[6] + arr[9]+1) / 2;
                }
            }
        }
        bw.write(max+"\n");

        bw.flush();
        bw.close();
    }
    public void roomNumber_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (a > 0) {
            arr[a%10]++;
            a/=10;
        }
        int max = 0;
        for(int i=0;i<10;i++) {
            if(i == 6 || i == 9)continue;
            if(max < arr[i])  max = arr[i];
        }
        max = Math.max(max, (arr[6] + arr[9] +1)/2);
        bw.write(max+"\n");

        bw.flush();
        bw.close();
    }
}

public class Algorithm0112 {
    public static void main(String[] args) throws Exception{
//        Test test = new Test();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int x = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];
        int[] occur = new int[2000001];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(s);
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++) {
            if(x-arr[i]>0 && occur[x-arr[i]] == 1) sum++;
            occur[arr[i]] = 1;
        }
        bw.write(sum+"");

        bw.flush();
        bw.close();
    }
}
package com.test.alg;

import java.io.*;
import java.util.StringTokenizer;

class Test0116 {

    // 백준 10807번
    public void numberCount_10807(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int v = Integer.parseInt(br.readLine());

        int cnt = 0;
        StringTokenizer st = new StringTokenizer(s);
        for(int i=0;i<n;i++) {
            int x = Integer.parseInt(st.nextToken());
            if(v == x) cnt++;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
    public void numberCount_10807_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int v = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(s);
        int[] arr = new int[201];

        while (n > 0) {
            n--;
            int t = Integer.parseInt(st.nextToken());
            arr[t+100]++;
        }
        bw.write(arr[v+100] + "");
        bw.flush();
        bw.close();
    }

    // 백준 13300번
    public void roomMatching_13300(BufferedReader br, BufferedWriter bw) throws IOException {
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[2][7];
        for(int i=0;i<n;i++) {
            String tmp = br.readLine();
            st = new StringTokenizer(tmp);
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }
        int cnt = 0;
        for(int i=0;i<2;i++) {
            for(int j=1;j<7;j++) {
                cnt += arr[i][j] / k;
                if(arr[i][j] % k != 0) cnt++;
            }
        }
        bw.write(cnt +"");
        bw.flush();
        bw.close();
    }

    // 백준 11328번
    public void strfry_11328(BufferedReader br, BufferedWriter bw) throws Exception {
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            int[] arr = new int[26];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            for(int j=0;j<s1.length();j++) {
                arr[s1.charAt(j)-'a']++;
            }
            for(int j=0;j<s2.length();j++) {
                arr[s2.charAt(j)-'a']--;
            }
            boolean flag = true;
            for(int x:arr) {
                if(x != 0) flag = false;
            }
            if(flag) {
                bw.write("Possible\n");
            }else {
                bw.write("Impossible\n");
            }
        }
        bw.flush();
        bw.close();
    }
    // 이렇게 풀어도 통과는 되지만 메모리 소모량이 좀 높음
    public void strfry_11328_01(BufferedReader br, BufferedWriter bw) throws Exception {

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            int[] arr = new int[1001];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String s1 = st.nextToken();
            String s2 = st.nextToken();

            for(int j=0;j<s1.length();j++) {
                arr[s1.charAt(j)]++;
            }
            for(int j=0;j<s2.length();j++) {
                arr[s2.charAt(j)]--;
            }
            boolean flag = true;
            for(int x : arr) {
                if(x != 0) flag = false;
            }
            if(flag) {
                bw.write("Possible\n");
            }else {
                bw.write("Impossible\n");
            }
        }
    }

    public void anagram(BufferedReader br, BufferedWriter bw) throws IOException {
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] arr = new int[26];

        for(int i=0;i<s1.length();i++) {
            arr[s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<s2.length();i++) {
            arr[s2.charAt(i) - 'a']--;
        }
        int cnt = 0;
        for(int i : arr) {
            if(i != 0) cnt += Math.abs(i);
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
    public void anagram_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        int[][] arr = new int[2][26];

        String s1 = br.readLine();
        String s2 = br.readLine();

        for(int i=0;i<s1.length();i++) {
            arr[0][s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<s2.length();i++) {
            arr[1][s2.charAt(i) - 'a']++;
        }

        int cnt = 0;
        for(int i=0;i<26;i++) {
            cnt += Math.abs(arr[0][i] - arr[1][i]);
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();

    }
}
public class Algorithm0116 {
    public static void main(String[] args) throws Exception{
        Test0116 test0116 = new Test0116();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        test0116.anagram_answer(br,bw);
    }
}

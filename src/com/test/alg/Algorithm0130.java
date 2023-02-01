package com.test.alg;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

class Test0130 { // 재귀
    public void multiply_1629(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        bw.write(pow(a,b,c)+"");
        bw.flush();
        bw.close();
    }
    public long pow(long a, long b, long c) {
        if(b == 1) return a % c;
        long val = pow(a, b/2, c);
        val = val * val % c;
        if(b%2 == 0) return val;
        return val * a % c;
    }

    public void hanoi_tower_11729(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        bw.write(((int)Math.pow(2,n) -1)+"\n");

        move(1,3, n, bw);

        bw.flush();
        bw.close();
    }
    public void move(int a, int b, int n, BufferedWriter bw) throws IOException{
        if(n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        move(a, 6-a-b, n-1, bw);
        bw.write(a + " " + b + "\n");
        move(6-a-b, b, n-1, bw);
    }

    public void z_1074(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(func(r,c,n)+"");
        bw.flush();
        bw.close();
    }
    public int func(int r, int c, int n) {
        if(n == 0) return 0;
        int half = (int)Math.pow(2,n-1);
        if(r < half && c < half) return func(r,c,n-1);
        if(r < half && c >= half) return half*half + func(r,c-half,n-1);
        if(r >= half && c < half) return 2*half*half + func(r-half,c,n-1);
        return 3 * half * half + func(r-half, c-half, n-1);
    }

    int cnt1;
    public void recursive_17478(BufferedReader br, BufferedWriter bw) throws IOException {
        cnt1 = Integer.parseInt(br.readLine());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        recurs(0, bw);
        bw.flush();
        bw.close();
    }
    public void recurs(int n, BufferedWriter bw) throws IOException {
        _bar("\"재귀함수가 뭔가요?\"\n", n,bw);
        if(n == cnt1) {
            _bar("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n", n,bw);
        }else {
            _bar("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",n,bw);
            _bar("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",n,bw);
            _bar("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",n,bw);
            recurs(n+1,bw);
        }
        _bar("라고 답변하였지.\n",n,bw);
    }
    public void _bar(String str, int stk, BufferedWriter bw) throws IOException{
        for(int i=0;i<stk;i++) {
            bw.write("____");
        }
        bw.write(str);
    }


    int[][] arr = new int[2200][2200];
    int[] res = new int[3];
    public void paper_count_1780(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
//        arr = new int[n][n];
        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<n;j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        recurs1(0,0,n);
        for(int i=0;i<3;i++) {
            bw.write(res[i]+"\n");
        }
        bw.flush();
        bw.close();

    }
    public void recurs1(int x, int y, int z) {
        if(check(x,y,z)) {
            res[arr[x][y] +1] += 1;
            return;
        }
        int n = z/3;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                recurs1(x+i*n, y+j*n,n);
            }
        }
    }
    public boolean check(int x, int y, int n) {
        for(int i=x;i<x+n;i++) {
            for(int j=y;j<y+n;j++) {
                if(arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }


    public int[] solution(String today, String[] terms, String[] privacies) {
        int today_num = Integer.parseInt(today.replaceAll("\\.",""));
        int[] answer = new int[privacies.length];
        int[] terms_int = new int[100];
        for(int i=0;i<terms.length;i++) {
            terms_int[terms[i].charAt(0) - 'A'] = Integer.parseInt(terms[i].split(" ")[1]);
        }
        int idx = 0;
        for(int i=0;i<privacies.length;i++) {
            String s = privacies[i];
            char c = s.charAt(s.length()-1);

            int year = Integer.parseInt(s.substring(0,4));
            int month = Integer.parseInt(s.substring(5,7));
            int day = Integer.parseInt(s.substring(8,10));

            int t = terms_int[c-'A'];

            year = year + ((t) / 12);
            month = month + (t % 12);
            if(month > 12) {
                year = year + ((month) / 12);
                month = (month) % 12;
            }

            if(s.substring(8,10).equals("01")) {
                day = 28;
                if(month > 1) {
                    month--;
                }else {
                    month = 12;
                    year--;
                }
            }else {
                day--;
            }

            int num = Integer.parseInt(year + "" + String.format("%02d", month) + "" + String.format("%02d", day));

            if(today_num > num) {
                answer[idx++] = i+1;
            }

        }

        int[] newAns = new int[idx];
        for(int i=0;i<idx;i++) {
            newAns[i] = answer[i];
        }

        return newAns;
    }



    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
    public int[] solution_refact(String today, String[] terms, String[] privacies) {
        int today_num = getDate(today);
        List<Integer> list = new ArrayList<>();
        int[] terms_int = new int[100];

        for(int i=0;i<terms.length;i++) {
            terms_int[terms[i].charAt(0) - 'A'] = Integer.parseInt(terms[i].split(" ")[1]);
        }

        for(int i=0;i<privacies.length;i++) {
            String[] privacy = privacies[i].split(" ");
            if(today_num >= (getDate(privacy[0]) + terms_int[privacy[1].charAt(0) - 'A'] * 28)) {
                list.add(i+1);
            }
        }

        return list.stream().mapToInt(integer -> integer).toArray();
    }

    public void hall_of_fame_programmers(int k, int[] score) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<score.length;i++) {
            priorityQueue.add(score[i]);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            System.out.println(priorityQueue.peek());
        }
    }
}

public class Algorithm0130 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0130 test0130 = new Test0130();
//        test0130.paper_count_1780(br,bw);


        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int k = 3;



    }
}

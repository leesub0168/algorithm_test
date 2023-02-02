package com.test.alg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Prog0201 {
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
//        int[] score = {10, 100, 20, 150, 1, 100, 200};
//        int k = 3;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<score.length;i++) {
            priorityQueue.add(score[i]);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            System.out.println(priorityQueue.peek());
        }
    }

    public int weapon(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number+2];

        for(int i=1;i<=number;i++) {
            for(int j=1;j<=number/i;j++) {
                arr[i*j]++;
            }
        }
        for(int i=1;i<= number;i++) {
            if(arr[i] > limit) {
                answer += power;
            }else {
                answer += arr[i];
            }
        }
        return answer;
    }

    public int apple_sales(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i=score.length-m;i>= 0;i -= m) {
            answer += (score[i] * m);
        }
        return answer;
    }
}
public class Programmers_0201 {

    public static void main(String[] args) throws Exception {

        Prog0201 prog0201 = new Prog0201();
        int k = 3;
        int m = 4;
        int[] sc = {1, 2, 3, 1, 2, 3, 1};


    }
}

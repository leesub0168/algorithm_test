package com.test.alg;

import java.io.*;
import java.util.*;

class Test0119 {

    public void deque_10866(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while (n > 0) {
            n--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("front")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.getFirst()+"\n");
            }else if(s.equals("back")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.getLast()+"\n");
            }else if(s.equals("size")) {
                bw.write(deque.size()+"\n");
            }else if(s.equals("empty")) {
                if(deque.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }else if(s.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }else if(s.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }else if(s.equals("pop_front")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.removeFirst()+"\n");
            }else if(s.equals("pop_back")) {
                if(deque.isEmpty()) bw.write("-1\n");
                else bw.write(deque.removeLast()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public void rotation_queue_1021_linked(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            list.add(i);
        }
        int cnt = 0;
        while(k > 0) {
            k--;
            int x = Integer.parseInt(st.nextToken());
            int idx = list.indexOf(x);
            while (list.getFirst() != x) {
                if(idx < list.size() - idx) {
                    list.addLast(list.getFirst());
                    list.removeFirst();
                }else  {
                    list.addFirst(list.getLast());
                    list.removeLast();
                }
                cnt++;
            }
            list.removeFirst();
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
    public void rotation_queue_1021_deque(BufferedReader br, BufferedWriter bw) throws IOException {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            deque.add(i);
        }
        int cnt = 0;
        while(k > 0) {
            k--;
            int x = Integer.parseInt(st.nextToken());
            int idx = -1;
            Object[] arr = deque.toArray();
            for(int i =0;i<arr.length;i++) {
                if((int) arr[i] == x) idx = i;
            }
            while (deque.getFirst() != x) {
                if(idx < deque.size() - idx) {
                    deque.addLast(deque.getFirst());
                    deque.removeFirst();
                }else  {
                    deque.addFirst(deque.getLast());
                    deque.removeLast();
                }
                cnt++;
            }
            deque.removeFirst();
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    public void ac_5430(BufferedReader br, BufferedWriter bw) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            if(n > 0) {
                StringTokenizer st = new StringTokenizer(arrStr.substring(1,arrStr.length()-1),",");
                for(int i=0;i<n;i++) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }
            boolean flag = false;
            boolean reverse = false;
            for (int i=0;i<s.length();i++) {
                if(s.charAt(i) == 'R') {
                    reverse = !reverse;
                }else {
                    if(deque.isEmpty()) {
                        flag = true;
                        break;
                    }else  {
                        if(reverse) deque.removeLast();
                        else deque.removeFirst();
                    }
                }
            }
            if(!flag) {
                bw.write("[");
                StringBuffer sb = new StringBuffer();
                Iterator<Integer> iterator = (reverse)? deque.descendingIterator():deque.iterator();
                while(iterator.hasNext()) {
                    sb.append(iterator.next() + ",");
                }
                if(sb.length() > 0) bw.write(sb.substring(0, sb.length() -1));
                bw.write("]\n");
            }else {
                bw.write("error\n");
            }

        }
        bw.flush();
        bw.close();
    }

    public void ac_5430_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            t--;
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int rev = 0;
            String query = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            boolean isWrong = false;

            if(n > 0) {
                StringTokenizer st = new StringTokenizer(tmp.substring(1,tmp.length()-1),",");
                for(int i=0;i<n;i++) {
                    deque.add(Integer.parseInt(st.nextToken()));
                }
            }
            for (int i=0;i<query.length();i++) {
                if(query.charAt(i) == 'R') {
                    rev = 1 - rev;
                }else {
                    if(deque.isEmpty()) {
                        isWrong = true;
                        break;
                    }else  {
                        if(rev == 0) deque.removeFirst();
                        else deque.removeLast();
                    }
                }
            }
            if(isWrong)  {
                bw.write("error\n");
            }else {
                bw.write("[");
                StringBuffer sb = new StringBuffer();
                Iterator<Integer> iterator = (rev == 1)? deque.descendingIterator():deque.iterator();
                while(iterator.hasNext()) {
                    sb.append(iterator.next() + ",");
                }
                if(sb.length() > 0) bw.write(sb.substring(0, sb.length() -1));
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public void min_value_11003(BufferedReader br, BufferedWriter bw) throws IOException {

    }
}

public class Algorithm0119 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0119 test0119 = new Test0119();
        test0119.ac_5430_answer(br,bw);
    }
}

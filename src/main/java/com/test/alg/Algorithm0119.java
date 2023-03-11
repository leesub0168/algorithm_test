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

    /**
     *
     * */
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

    /**
     *
     * */
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

    /**
     *
     * */
    public void min_value_11003(BufferedReader br, BufferedWriter bw) throws IOException {

    }

    public void balanced_world_4949(BufferedReader br, BufferedWriter bw) throws IOException {
        boolean flag = true;
        while (flag) {
            String s = br.readLine();
            if(s.length() == 1 && s.equals(".")) {
                flag = false;
                break;
            }
            boolean check = false;
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if(c == '[' || c == '(') {
                    stack.push(c);
                }else if(c == ']') {
                    if(stack.isEmpty()) {
                        check = true;
                        break;
                    }else {
                        if(stack.peek() == '[') stack.pop();
                        else check = true;
                    }
                }else if(c == ')') {
                    if(stack.isEmpty()) {
                        check = true;
                        break;
                    }else {
                        if(stack.peek() == '(') stack.pop();
                        else check = true;
                    }
                }
            }
            if(check) {
                bw.write("no\n");
            }else if(stack.isEmpty()) {
                bw.write("yes\n");
            }else {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public void goodWords(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n > 0) {
            n--;
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if(stack.isEmpty()) {
                    stack.push(c);
                }else if(stack.peek() == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) cnt++;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }

    public void bracket_9012(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            n--;
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean result = true;
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                if(c == '(') stack.push(c);
                else if(c == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        result = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            if(!result || !stack.isEmpty()) bw.write("NO\n");
            else bw.write("YES\n");
        }
        bw.flush();
        bw.close();
    }

    public void iron_rod_10799(BufferedReader br, BufferedWriter bw) throws IOException {
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        char mark = 'a';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else if(mark == '(' && c == ')' && !stack.isEmpty()) {
                stack.pop();
                cnt += stack.size();
            }else if(c == ')' && stack.peek() == '(') {
                cnt++;
                stack.pop();
            }
            mark = c;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }

    /**
     *
    * */
    public void bracket_value_2504(BufferedReader br, BufferedWriter bw) throws IOException {
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int num = 1;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
                num *= 2;
                stack.push(c);
            }else if(c == '[') {
                num *= 3;
                stack.push(c);
            }else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }
                if(s.charAt(i-1) == '(') sum += num;
                stack.pop();
                num /= 2;
            }else {
                if(stack.empty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                }
                if(s.charAt(i-1) == '[') sum += num;
                stack.pop();
                num /= 3;
            }
        }
        if(!stack.isEmpty()) sum = 0;
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}

public class Algorithm0119 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0119 test0119 = new Test0119();
        test0119.bracket_value_2504(br,bw);
    }
}

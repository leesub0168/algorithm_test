package com.test.alg;

import java.io.*;
import java.security.KeyPair;
import java.util.*;

class Pair {
    Integer key;
    Integer value;

    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
}
class Test0117 {

    /**
     * 연결리스트
     * */

    public void editor_1406(BufferedReader br, BufferedWriter bw) throws IOException {
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        LinkedList<Character> linkedList = new LinkedList<>();

        for(int i=0;i<s.length();i++) {
            linkedList.add(s.charAt(i));
        }
        int cursor = linkedList.size();
        for(int i=0;i<q;i++) {
            String tmp = br.readLine();
            StringTokenizer st = new StringTokenizer(tmp);
            char op = st.nextToken().charAt(0);

            if(op == 'P') {
                char add = st.nextToken().charAt(0);
                linkedList.add(cursor,add);
                cursor++;
            }else if(op == 'L') {
                if(cursor > 0) cursor--;
            }else if(op == 'D') {
                if(cursor < linkedList.size()) cursor++;
            }else {
                if(cursor > 0) {
                    linkedList.remove(cursor-1);
                    cursor--;
                }
            }
        }

        for(char c : linkedList) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }
    public void editor_1406_iterator(BufferedReader br, BufferedWriter bw) throws IOException {
//        String s = br.readLine();
        char[] s = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        LinkedList<Character> linkedList = new LinkedList<>();

        for(int i=0;i<s.length;i++) {
            linkedList.add(s[i]);
        }
        ListIterator<Character> iterator = (ListIterator<Character>) linkedList.iterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        for(int i=0;i<q;i++) {
            String tmp = br.readLine();
            char op = tmp.charAt(0);

            if(op == 'P') {
                char add = tmp.charAt(2);
                iterator.add(add);
            }else if(op == 'L') {
                if(iterator.hasPrevious()) iterator.previous();
            }else if(op == 'D') {
                if(iterator.hasNext()) iterator.next();
            }else {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            }
        }

        for(char c : linkedList) {
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }

    public void keyLogger_5397(BufferedReader br, BufferedWriter bw) throws IOException {
        int tc = Integer.parseInt(br.readLine());
        while(tc > 0) {
            LinkedList<Character> list = new LinkedList<>();
            char[] c = br.readLine().toCharArray();
            ListIterator<Character> iterator = (ListIterator<Character>) list.iterator();
            for(int i=0;i<c.length;i++) {
                switch (c[i]) {
                    case '<':
                        if (iterator.hasPrevious()) iterator.previous();
                        break;
                    case '>':
                        if(iterator.hasNext()) iterator.next();
                        break;
                    case '-':
                        if(iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default:
                        iterator.add(c[i]);
                        break;
                }
            }
            for(char tmp : list) {
                bw.write(tmp);
            }
            bw.write("\n");
            tc--;
        }
        bw.flush();
        bw.close();
    }

    public void josephus_1158(BufferedReader br, BufferedWriter bw) throws IOException {
        int[] pre = new int[5001];
        int[] next = new int[5001];
        int len = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Vector<Integer> v = new Vector<>();

        for(int i=1;i<=n;++i) {
            pre[i] = (i == 1) ? n:i-1;
            next[i] = (i == n) ? 1:i+1;
            ++len;
        }
        int i =1;
        for(int cur = 1;len != 0;cur = next[cur]) {
            if(i == k) {
                pre[next[cur]] = pre[cur];
                next[pre[cur]] = next[cur];
                v.add(cur);
                i=1;
                --len;
            }else {
                ++i;
            }
        }

        bw.write("<");
        for(int j=0;j<v.size();j++) {
            bw.write(v.get(j)+"");
            if(j < v.size()-1) bw.write(", ");
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
    public void josephus_1158_linked(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++) {
            list.add(i);
        }
        int idx = k-1;

        bw.write("<");
        while (list.size() > 0) {
            if(list.size() == 1) {
                bw.write(list.remove(idx)+">");
            }else {
                bw.write(list.remove(idx)+", ");
            }
            if(list.isEmpty()) {
                break;
            }
            idx += (k-1);
            while (idx >= list.size()) {
                idx -= list.size();
            }

        }
        bw.flush();
        bw.close();
    }


    /**
     * 스택
     * */

    public void stack_test() {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.size());
        if(s.empty()) {
            System.out.println("s is Empty");
        }else {
            System.out.println("s is not empty");
        }
        s.pop();
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.pop();
        if(s.empty()) System.out.println("s is Empty");
        System.out.println(s.peek());
    }

    public void stack_10828(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.isEmpty()) {
                        bw.write("-1\n");
                    }else {
                        bw.write(stack.pop()+"\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size()+"\n");
                    break;
                case "empty":
                    if(stack.isEmpty()) {
                        bw.write("1\n");
                    }else {
                        bw.write("0\n");
                    }
                    break;
                default:
                    if(stack.isEmpty()) {
                        bw.write("-1\n");
                    }else {
                        bw.write(stack.peek()+"\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    public void zero_10773(BufferedReader br, BufferedWriter bw) throws IOException {
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (k > 0) {
            k--;
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(!stack.isEmpty()) stack.pop();
            }else {
                stack.push(n);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum +"");
        bw.flush();
        bw.close();
    }

    public void stack_sequence_1874(BufferedReader br, BufferedWriter bw) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;

        StringBuffer sb = new StringBuffer();
        while (n>0) {
            n--;
            int t = Integer.parseInt(br.readLine());
            while (cnt <= t) {
                stack.push(cnt++);
                sb.append("+\n");
            }
            if(stack.peek() != t) {
                sb = new StringBuffer("NO\n");
                break;
            }
            stack.pop();
            sb.append("-\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public void tower_2493(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Pair> tower = new Stack<>();
        tower.push(new Pair(100000001,0));
        for(int i=1;i<=n;i++) {
            int heg = Integer.parseInt(st.nextToken());
            while (tower.peek().getKey() < heg) {
                tower.pop();
            }
            bw.write(tower.peek().getValue() + " ");
            tower.push(new Pair(heg,i));
        }

        bw.flush();
        bw.close();
    }
    public void tower_2493_simpleEntry(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<AbstractMap.SimpleEntry<Integer,Integer>> tower = new Stack<>();
        tower.push(new AbstractMap.SimpleEntry<>(100000001,0));
        for(int i=1;i<=n;i++) {
                int heg = Integer.parseInt(st.nextToken());
                while (tower.peek().getKey() < heg) {
                        tower.pop();
                    }
                bw.write(tower.peek().getValue() + " ");
                tower.push(new AbstractMap.SimpleEntry<>(heg,i));
            }

        bw.flush();
        bw.close();
    }
    public void tower_2493_arr(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        for(int i=0;i<n;i++) {
            int k = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if(stack.peek()[0] < k) {
                    stack.pop();
                }else {
                    bw.write(stack.peek()[1]+" ");
                    break;
                }
            }
            if(stack.isEmpty()) bw.write("0 ");
            stack.push(new int[]{k,i+1});
        }
        bw.flush();
        bw.close();
    }


    public void queue_10845_arr(BufferedReader br, BufferedWriter bw) throws IOException {
        int[] dat = new int[100001];
        Arrays.fill(dat,-1);
        int head = 0, tail = 0;
        int n = Integer.parseInt(br.readLine());

        while(n > 0) {
            n--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String m = st.nextToken();
            if(m.equals("push")) {
                dat[tail++] = Integer.parseInt(st.nextToken());
            }else if(m.equals("front")) {
                if(tail-head == 0) {
                    bw.write("-1\n");
                }else {
                    bw.write(dat[head]+"\n");
                }
            }else if(m.equals("back")) {
                if(tail-head == 0) {
                    bw.write("-1\n");
                }else {
                    bw.write(dat[tail-1]+"\n");
                }
            }else if(m.equals("size")) {
                bw.write((tail-head) + "\n");
            }else if(m.equals("empty")) {
                if(tail-head == 0) {
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }else { // pop
                if(tail-head == 0) {
                    bw.write("-1\n");
                }else {
                    bw.write(dat[head] + "\n");
                    head++;
                }
            }
        }
        bw.flush();
        bw.close();
    }
    public void queue_10845(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        int memo = -1;

        while(n > 0) {
            n--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String m = st.nextToken();
            if(m.equals("push")) {
                memo = Integer.parseInt(st.nextToken());
                queue.offer(memo);
            }else if(m.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                }else {
                    bw.write(queue.peek()+"\n");
                }
            }else if(m.equals("back")) {
                if(queue.isEmpty()) {
                    bw.write("-1\n");
                }else {
                    bw.write(memo + "\n");
                }
            }else if(m.equals("size")) {
                bw.write(queue.size()+"\n");
            }else if(m.equals("empty")) {
                if(queue.isEmpty()) {
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }else { // pop
                if(queue.isEmpty()) {
                    bw.write("-1\n");
                }else {
                    bw.write(queue.poll()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    public void queueCard_2164(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++) {
            q.offer(i);
        }
        while (!q.isEmpty()) {
            if(q.size() == 1) {
                bw.write(q.peek()+"\n");break;
            }else {
                q.poll();
                int x = q.poll();
                q.offer(x);
            }
        }

        bw.flush();
        bw.close();
    }
    public void queueCard_2164_answer(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1;i<=n;i++) {
            q.offer(i);
        }
        while (q.size() > 1) {
            q.poll();
            int x = q.poll();
            q.offer(x);
        }
        bw.write(q.peek()+"\n");
        bw.flush();
        bw.close();
    }
}
public class Algorithm0117 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0117 test0117 = new Test0117();
        test0117.queueCard_2164(br,bw);
    }
}

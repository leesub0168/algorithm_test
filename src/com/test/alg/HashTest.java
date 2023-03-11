package com.test.alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Hash_Chaining {
    final int M = 1000003;
    final int a = 1000;
    final int MX = 500005;

    int[] head = new int[M];
    int[] pre = new int[MX];
    int[] nxt = new int[MX];
    String[] key = new String[MX];
    int[] val = new int[MX];
    int unused = 0;

    private int my_hash(String s) {
        int h = 0;
        for(char c : s.toCharArray()) {
            h = (h * a + c) % M;
        }
        return h;
    }

    public int find(String k) {
        int h = my_hash(k);
        int idx = head[h];
        while (idx != -1) {
            if(key[idx] == k) return idx;
            idx = nxt[idx];
        }
        return -1;
    }

    public void insert(String k, int v) {
        int idx = find(k);
        if(idx >= 0) {
            val[idx] = v;
            return;
        }
        int h = my_hash(k);
        key[unused] = k;
        val[unused] = v;
        if(head[h] != -1) {
            nxt[unused] = head[h];
            pre[head[h]] = unused;
        }
        head[h] = unused;
        unused++;
    }

    public void erase(String k) {
        int idx = find(k);
        if(idx == -1) return;
        if(pre[idx] != -1) nxt[pre[idx]] = nxt[idx];
        if(nxt[idx] != -1) pre[nxt[idx]] = pre[idx];
        int h = my_hash(k);
        if(head[h] != -1) head[h] = nxt[idx];
    }

    public void test() {
        insert("orange", 724); // ("orange", 724)
        insert("melon", 20); // ("orange", 724), ("melon", 20)
        assert(val[find("melon")] == 20);
        insert("banana", 52); // ("orange", 724), ("melon", 20), ("banana", 52)
        insert("cherry", 27); // ("orange", 724), ("melon", 20), ("banana", 52), ("cherry", 27)
        insert("orange", 100); // ("orange", 100), ("melon", 20), ("banana", 52), ("cherry", 27)
        assert(val[find("banana")] == 52);
        assert(val[find("orange")] == 100);
        erase("wrong_fruit"); // ("orange", 100), ("melon", 20), ("banana", 52), ("cherry", 27)
        erase("orange"); // ("melon", 20), ("banana", 52), ("cherry", 27)
        assert(find("orange") == -1);
        erase("orange"); // ("melon", 20), ("banana", 52), ("cherry", 27)
        insert("orange", 15); // ("melon", 20), ("banana", 52), ("cherry", 27), ("orange", 15)
        assert(val[find("orange")] == 15);
        insert("apple", 36); // ("melon", 20), ("banana", 52), ("cherry", 27), ("orange", 15), ("apple", 36)
        insert("lemon", 6); // ("melon", 20), ("banana", 52), ("cherry", 27), ("orange", 15), ("apple", 36), ("lemon", 6)
        insert("orange", 701);  // ("melon", 20), ("banana", 52), ("cherry", 27), ("orange", 701), ("apple", 36), ("lemon", 6)
        assert(val[find("cherry")] == 27);
        erase("xxxxxxx");
        assert(find("xxxxxxx") == -1);
        assert(val[find("apple")] == 36);
        assert(val[find("melon")] == 20);
        assert(val[find("banana")] == 52);
        assert(val[find("cherry")] == 27);
        assert(val[find("orange")] == 701);
        assert(val[find("lemon")] == 6);
        System.out.println("good!");
    }

    public void main() {
        Arrays.fill(head, -1);
        Arrays.fill(pre, -1);
        Arrays.fill(nxt, -1);
        test();
    }
}

public class HashTest {
    /** 백준 13414번 수강신청 */
    public static void boj_13414(BufferedReader br) throws IOException {
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<m;i++) {
            String s = br.readLine();
            map.put(s, i);
        }

        String[] arr = new String[m];
        for (String key : map.keySet()) {
            int idx = map.get(key);
            arr[idx] = key;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            if(n <= 0) break;
            if(arr[i] != null) {
                sb.append(arr[i]).append("\n");
                n--;
            }
        }
        System.out.println(sb);
    }

    /** 백준 17219번 비밀번호 찾기 */
    public static void boj_17219(BufferedReader br) throws IOException {
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);

        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            String[] s = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<m;i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    /** 백준 9375번 패션왕 신해빈 */
    public static void boj_9375(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            int answer = 1;
            int m = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j=0;j<m;j++) {
                String s = br.readLine().split(" ")[1];
                int x = 0;
                if(map.containsKey(s)) {
                    x = map.get(s);
                }
                x++;
                map.put(s, x);
            }
            for (String s : map.keySet()) {
                answer *= (map.get(s) + 1);
            }
            sb.append(answer-1).append("\n");
        }
        System.out.println(sb);
    }


    /** 백준 16165 걸그룹 마스터 준석이 */
    public static void boj_16165(BufferedReader br) throws IOException {
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);
        Map<String, String> nameMap = new HashMap<>();
        Map<String, String[]> groupMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            String group = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String[] members = new String[count];
            for (int j = 0; j < count; j++) {
                String s = br.readLine();
                members[j] = s;
                nameMap.put(s, group);
            }
            Arrays.sort(members);

            groupMap.put(group, members);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if(type == 1) {
                sb.append(nameMap.get(name)).append("\n");
            }else {
                for (String s : groupMap.get(name)) {
                    sb.append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
//        Hash_Chaining hash_chaining = new Hash_Chaining();
//        hash_chaining.main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boj_16165(br);


    }
}

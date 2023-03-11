package com.test.alg.etc;

import java.io.*;
import java.util.*;

class Baek_sort {

    public void sort_25305(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list.get(k-1));
    }

    public void sort_2751(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<n;i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append("\n");
        }
        System.out.println(sb);
    }

    public void sort_2751_other_answer(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean arr[] = new boolean[2000001];
        for(int i=0;i<n;i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]) {
                sb.append(i - 1000000).append("\n");
            }
        }
        System.out.println(sb);
    }

    public void sort_10989(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    public void sort_10989_other_answer(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i=0;i<n;i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            while(arr[i] > 0) {
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        System.out.println(sb);
    }

    public void sort_2108(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int[] arr = new int[n];
        int[] count = new int[40001];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            count[arr[i] + 4000]++;
            total += arr[i];
        }
        OptionalInt mx = Arrays.stream(count).max();
        Arrays.sort(arr);
        Double num = Math.ceil(Math.abs(total)/(double)n);
        if(total/n > 0) System.out.println(total/n);
        else System.out.println(num.intValue() * -1);
        System.out.println(arr[n/2]);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<count.length;i++) {
            if(count[i] == mx.getAsInt()) {
                list.add(i-4000);
            }
        }
        if(list.size() >= 2) System.out.println(list.get(1));
        else System.out.println(list.get(0));
        System.out.println(arr[arr.length-1] - arr[0]);
    }

    public void sort_1427(BufferedReader br) throws IOException {
        String[] arr = br.readLine().split("");
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(list,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
public class BaekJoon_sort {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Baek_sort baekSort = new Baek_sort();
        baekSort.sort_1427(br);
    }
}

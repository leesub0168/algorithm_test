package com.test.alg;

import java.util.*;
import java.util.stream.Collectors;

class Prog0211 {
    public int[] duplicate_number(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++) {
            if(stack.isEmpty()){
                stack.add(arr[i]);
            }else {
                int x = stack.peek();
                if(x != arr[i]) {
                    stack.add(arr[i]);
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public int composite_num(int n) {
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n/i;j++) {
                arr[i*j]++;
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++) {
            if(arr[i] >= 3) answer++;
        }
        return answer;
    }

    public int max_multiply(int[] numbers) {
        Arrays.sort(numbers);

        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }

    public int factorial(int n) {
        int answer = 0;
        for(int i=1;i<=10;i++) {
            int a = factorial_func(i);
            if(a <= n) {
                answer = i;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public int factorial_func(int n) {
        if(n == 1) return 1;
        else return n * factorial_func(n-1);
    }

    public int[] string_sort(String my_string) {
        List<Integer> list = new ArrayList<>();
        char[] arr = my_string.toCharArray();
        for(int i=0;i<my_string.length();i++) {
            if(Character.isDigit(arr[i])) list.add(Character.getNumericValue(arr[i]));
        }
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int string_number_sum(String my_string) {
        char[] c = my_string.replaceAll("[a-z|A-Z]","").toCharArray();
        int answer = 0;
        for(int i=0;i<c.length;i++) {
            answer += Character.getNumericValue(c[i]);
        }
        return answer;
    }

    public int[] prime_factorization(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=2;i<=n;i++) {
            if(n % i == 0) {
                if(isPrime(i)) list.add(i);
            }
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n % i == 0) return false;
        }
        return true;
    }


    //        int[] progresses = {40, 93, 30, 55, 60, 65};
    //        int[] speeds = {60, 1, 30, 5 , 10, 7};
    public int[] function_develop(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<progresses.length;i++) {
            int left = 100 - progresses[i];
            int day = (left % speeds[i] == 0)?left / speeds[i]:(left / speeds[i])+1;
            list.add(day);
        }
        int mx = 1;
        int nums = list.get(0);
        for(int i=1;i<list.size();i++) {
            if(nums >= list.get(i)) {
                mx++;
            }else if(nums < list.get(i)) {
                list2.add(mx);
                nums = list.get(i);
                mx = 1;
            }
            if(i == list.size()-1) {
                list2.add(mx);
            }
        }
        return list2.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] function_develop_other(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100];
        int day = -1;
        for(int i=0;i<progresses.length;i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfEnd[day]++;
        }
        return Arrays.stream(dayOfEnd).filter(i -> i != 0).toArray();
    }

    public boolean bracket(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == '('){
                stack.push(arr[i]);
            }else if(arr[i] == ')') {
                if(stack.isEmpty()) return false;
                if(stack.peek() == '(') stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public int printer(int[] priorities, int location) {
        int answer = 0;
        int target = priorities[location];
        int[] arr = new int[1000];
        int max = Arrays.stream(priorities).max().getAsInt();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++) {
            queue.add(priorities[i]);
            arr[i+'A'] = priorities[i];
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            if(x == max) {
                cnt++;
                if(target == queue.remove()) return cnt;

                max = queue.stream().mapToInt(Integer::intValue).max().getAsInt();
            }else {
                queue.add(x);
            }
        }

        return cnt;
    }

    public int bridge_truck(int bridge_length, int weight, int[] truck_weights) {
        int time = bridge_length;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());

        queue.add(list.remove(0));
        int left = weight - queue.peek();
        while (!queue.isEmpty()) {
            queue.remove();
            if(list.size() >= 1) {
                queue.add(list.remove(0));
                time += bridge_length;
            }
        }
        return time;
    }

    public int close_number(int[] array, int n) {
//        int[] array = {12, 14, 14,15,16,17};
//        int n = 13;
        int answer = 0;
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if(Math.abs(n - array[0]) > Math.abs(n - array[i])) {
                array[0] = array[i];
            }
        }
        answer = array[0];
        return answer;
    }

    public int game_369(int order) {
        String s = String.valueOf(order);
        int answer = s.length();
        s = s.replaceAll("3","").replaceAll("6","").replaceAll("9","");

        return answer - s.length();
    }

    public String decryption(String cipher, int code) {
        String[] arr = cipher.split("");
        StringBuilder sb = new StringBuilder();
        for(int i=code;i<=arr.length;i+=code) {
            sb.append(arr[i-1]);
        }
        return sb.toString();
    }

    public String lower_upper(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] arr = my_string.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(Character.isUpperCase(arr[i])) {
                sb.append(Character.toLowerCase(arr[i]));
            }else {
                sb.append(Character.toUpperCase(arr[i]));
            }
        }
        return sb.toString();
//        return my_string.chars().mapToObj(c -> String.valueOf((Character.isUpperCase(c)) ? Character.toLowerCase(c) : Character.toUpperCase(c))).collect(Collectors.joining());
//        return Arrays.stream(my_string.split("")).map(s -> (s == s.toLowerCase()) ? s.toUpperCase() : s.toLowerCase()).collect(Collectors.joining());
    }

    public long hate_english(String numbers) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder sb = new StringBuilder(numbers);
        for(int i=0;i<str.length;i++) {
            numbers = numbers.replaceAll(str[i],String.valueOf(i));
        }
        return Long.valueOf(numbers);
    }

    public String change_index(String my_string, int num1, int num2) {
        char[] chars = my_string.toCharArray();
        char c = chars[num1];
        chars[num1] = chars[num2];
        chars[num2] = c;

//        return String.valueOf(chars);
        return new String(chars);
    }

    public String change_index_swap(String my_string, int num1, int num2) {
        List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());
        Collections.swap(list,num1,num2);
        return String.join("", list);
    }

    public String once_string(String s) {
        int[] arr = new int[30];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 1) sb.append(Character.toChars(i+'a'));
        }
        return sb.toString();
    }

    public int[] divisor(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(n % i == 0) list.add(i);
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = list.get(i);
        }

        return arr;
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
public class Programmers_0211 {
    public static void main (String[] args) {
//        int[] arr = {7,4,5,6};
//        int[] arr = {10};
        int[] arr = {10,10,10,10,10,10,10,10,10,10};
        Prog0211 prog0211 = new Prog0211();

        System.out.println(prog0211.bridge_truck(100,100,arr));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String s = "people";
        StringBuilder sb = new StringBuilder();
        String[] sarr = s.split("");
        for(int i=0;i<sarr.length;i++) {
            if (sb.indexOf(sarr[i]) < 0) sb.append(sarr[i]);
        }
        System.out.println(sb);
        System.out.println(s.chars().mapToObj(Character::toString).distinct().collect(Collectors.joining()));

        System.out.println(System.currentTimeMillis());
        System.out.println(Arrays.toString(prog0211.divisor(24)));
        System.out.println(System.currentTimeMillis());

    }
}

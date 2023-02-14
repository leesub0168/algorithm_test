package com.test.alg;

import java.util.*;

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

}
public class Programmers_0211 {
    public static void main (String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Prog0211 prog0211 = new Prog0211();

        System.out.println(prog0211.bracket("(()("));

    }
}

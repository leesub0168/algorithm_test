package com.test.alg;

import java.util.*;
import java.util.stream.Collectors;

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

    public int solution(int[] array) {
        int[] arr = new int [1005];

        int mx = 0;
        for(int i=0;i<array.length;i++) {
            arr[array[i]]++;
            mx = Math.max(mx, arr[array[i]]);
        }

        int cnt = 0;
        for(int i=0;i<arr.length;i++) {
            if(mx == arr[i]) {
                cnt++;
            }
        }


        return (cnt > 1)?-1:mx;
    }
    public int target_number(int[] numbers, int target) {
        int answer = 0;
        int[] board = new int[1002];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        board[0] = numbers[0];

        while(!queue.isEmpty()) {
            int x = queue.remove();
            int[] dx = {x+1,x-1};
            for(int i=0;i<2;i++) {
                int nx = dx[i];
                if(nx < 0 || nx >= board.length) continue;
                if(board[nx] != 0) continue;
                board[nx] = board[x]+numbers[nx];
                queue.add(nx);
            }
        }

        return answer;
    }

    public String kakao_mbti(String[] survey, int[] choices) {
        int[] mbti = new int[26];
        int[] score = {3,2,1,0,1,2,3};
        String[] mbti_type = {"RT","CF","JM","AN"};
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<choices.length;i++) {
            int sel = choices[i];

            if(sel < 4) {
                mbti[survey[i].charAt(0) - 'A'] += score[sel-1];
            }else if(sel > 4) {
                mbti[survey[i].charAt(1) - 'A'] += score[sel-1];
            }
        }
        for(int i=0;i<4;i++) {
            char c1 = mbti_type[i].charAt(0);
            char c2 = mbti_type[i].charAt(1);
            if((mbti[c1 - 'A'] > mbti[c2 - 'A'] ) || (mbti[c1 - 'A'] == mbti[c2 - 'A'])) {
                sb.append(c1);
            }else if(mbti[c1 - 'A'] < mbti[c2 - 'A']) {
                sb.append(c2);
            }
        }

        return sb.toString();
    }

    public int[] kakao_report(String[] id_list, String[] report, int k) {
        int[] score = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> scoreMap = new HashMap<>();


        for(int i=0;i<report.length;i++) {
            String[] s = report[i].split(" ");
            String reporter = s[0];
            String target = s[1];

            HashSet<String> set = (map.containsKey(reporter))?map.get(reporter):new HashSet<>();
            if(!set.contains(target)) {
                set.add(target);
                map.put(reporter, set);

                if(scoreMap.containsKey(target)) {
                    scoreMap.put(target, scoreMap.get(target)+1);
                }else {
                    scoreMap.put(target, 1);
                }
            }
        }

        for (int i=0;i<id_list.length;i++) {
            String key = id_list[i];

            if(map.containsKey(key)) {
                for(String s : map.get(key)) {
                    if(scoreMap.get(s) >= k) {
                        score[i]++;
                    }
                }
            }
        }

        return score;
    }

    public int[] kakao_report_other(String[] id_list, String[] report, int k) {
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }

    public int[] array_reverse(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i=0;i<num_list.length;i++) {
            answer[i] = num_list[num_list.length-1-i];
        }

        return answer;
    }
    public int[] array_reverse_stream(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());

        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int three_reverse(int n) { // 3진법 뒤집기
        StringBuilder s = new StringBuilder();

        while (n > 0) {
            s.append(n % 3);
            n = n / 3;
        }
        return Integer.parseInt(s.toString(),3);
    }

    public Integer[] plus_two_number(int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<numbers.length;i++) {
            for(int j=0;j<numbers.length;j++) {
                if(i != j) set.add(numbers[i]+numbers[j]);
            }
        }
        return set.toArray(new Integer[0]);
    }

}
public class Programmers_0201 {

    public static void main(String[] args) throws Exception {

        Prog0201 prog0201 = new Prog0201();

        int n = 125;
        StringBuilder s = new StringBuilder();

        int answer = 0;
        while (n > 0) {
            s.append(n % 3);
            n = n / 3;
        }
//        s.reverse();
        System.out.println(Integer.parseInt(s.toString(),3));


    }
}

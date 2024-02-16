import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            map.put("(", 0);
            map.put("+", 1);
            map.put("*", 2);
            map.put(")", 3);

            String[] array = br.readLine().split("");
            Deque<String> stack = new ArrayDeque<>();
            List<String> result = new ArrayList<>();

            // 계산식
            for (String s : array) {
                if (!map.keySet().contains(s)) {
                    result.add(s);
                } else {
                    if (s.equals("(")) {
                        stack.offer(s);
                    } else if (s.equals("+")) {
                        while (map.get(stack.peekLast()) > map.get(s)) {
                            result.add(stack.pollLast());
                        }
                        stack.offer(s);
                    } else if (s.equals("*")) {
                        stack.offer(s);
                    } else {
                        while (!stack.peekLast().equals("(")) {
                            result.add(stack.pollLast());
                        }
                        stack.pollLast();
                    }
                }
            }
            Deque<Integer> answer = new ArrayDeque<>();
            // 후위 표현식 계산
            for (String s : result) {
                if (!map.keySet().contains(s)) {
                    answer.offer(Integer.parseInt(s));
                } else {
                    int first = answer.pollLast();
                    int second = answer.pollLast();
                    if (s.equals("*")) {
                        answer.offer(first * second);
                    } else {
                        answer.offer(first + second);
                    }
                }
            }
            System.out.println("#" + t + " " + answer.pollLast());
        }
    }

}

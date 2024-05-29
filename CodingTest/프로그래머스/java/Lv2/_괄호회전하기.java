package 프로그래머스.java.Lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class _괄호회전하기 {
    static HashMap<String, String> map;

    public int solution(String s) {
        map = new HashMap<>();
        map.put("]", "[");
        map.put(")", "(");
        map.put("}", "{");

        int answer = 0;

        if (s.length() == 1) {
            return 0;
        }

        String[] array_s = s.split("");

        // 회전
        // 0번째
        for (int i = 1; i <= s.length(); i++) {
            array_s = rotate(array_s);
            if (check(array_s)) {
                answer++;
            }

        }

        return answer;
    }

    public static boolean check(String[] s) {
        Deque<String> stack = new ArrayDeque<>();

        for (String v : s) {
            if (map.containsKey(v)) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peekLast().equals(map.get(v))) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pollLast();
                } else {
                    return false;
                }
            } else {
                stack.offer(v);
            }
        }
        return stack.isEmpty();
    }

    public static String[] rotate(String[] s) {
        String zero = s[0];

        for (int i = 0; i < s.length - 1; i++) {
            s[i] = s[i + 1];
        }
        s[s.length - 1] = zero;
        return s;
    }
}

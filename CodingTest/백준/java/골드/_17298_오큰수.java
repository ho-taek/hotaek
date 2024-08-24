package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17298_오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            map.put(i, val);
        }

        for (Integer i : map.keySet()) {
            if (stack.isEmpty()) {
                stack.offer(i);
                continue;
            }
            int up = map.get(i);
            while (true) {

                int value = map.get(stack.peekLast());
                if (value < up) {
                    arr[stack.peekLast()] = map.get(i);
                    stack.pollLast();
                } else {
                    stack.offer(i);
                    break;
                }
                if (stack.isEmpty()) {
                    stack.offer(i);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                sb.append(-1).append(" ");
            } else {
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}

package 백준.java.실버;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _1874_스택수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 현재 들어가는 숫자
        int start = 1;

        // arr index
        int index = 0;
        boolean flag = true;
        while (true) {
            if (index == n) {
                break;
            }
            // 마지막일때
            if (stack.isEmpty()) {
                stack.offer(start);
                start++;
                sb.append("+").append("\n");
                continue;
            }

            if (arr[index] == stack.peekLast()) {
                stack.pollLast();
                index++;
                sb.append("-").append("\n");
                continue;
            }

            if (arr[index] < stack.peekLast()) {
                flag = false;
                break;
            }

            if (arr[index] > stack.peekLast()) {
                stack.offer(start);
                start++;
                sb.append("+").append("\n");
            }
        }
        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }

    }
}

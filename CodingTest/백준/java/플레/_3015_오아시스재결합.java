package 백준.java.플레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _3015_오아시스재결합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Deque<int[]> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            // 작은 것들 넣을 경우
            while (!stack.isEmpty() && stack.peekLast()[0] < array[i]) {
                answer += stack.pollLast()[1];
            }

            if (stack.isEmpty()) {
                stack.offerLast(new int[] { array[i], 1 });
            } else {
                if (stack.peekLast()[0] > array[i]) {
                    answer++;
                    stack.offerLast(new int[] { array[i], 1 });
                } else if (stack.peekLast()[0] == array[i]) {
                    answer += stack.peekLast()[1];
                    if (stack.size() > 1) {
                        answer++;
                    }
                    stack.peekLast()[1]++;
                }

            }
        }
        System.out.println(answer);

    }
}

package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _17298_오큰수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] answer = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < n; i++) {
            int up = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.offer(i);
                continue;
            }

            while (true) {
                int value = stack.peekLast();
                if (value < up) {
                    arr[stack.peekLast()] = up;
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

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                bw.write("-1");
            } else {
                bw.write(arr[i] + " ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

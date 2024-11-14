package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _1516_게임개발 {
    static int[] answer;
    static int[] input;
    static List<List<Integer>> li;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        answer = new int[n + 1];
        int[] build = new int[n + 1];
        input = new int[n + 1];
        li = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            li.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            build[i] = score;
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == -1) {
                    break;
                }

                input[i]++;
                li.get(tmp).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            answer[i] = build[i];
            if (input[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int i : li.get(q)) {
                answer[i] = Math.max(answer[i], build[i] + answer[q]);
                if (--input[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

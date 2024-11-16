package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _2637_장난감조립 {

    static List<List<Integer>> nextGo;
    static int[] input;
    static int[][] store;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 완제품
        int m = Integer.parseInt(br.readLine());

        input = new int[n + 1];
        nextGo = new ArrayList<>();
        store = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            nextGo.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            input[a] += c;
            for (int j = 0; j < c; j++) {
                nextGo.get(b).add(a);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {

            if (input[i] == 0) {
                store[i][i]++;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int next : nextGo.get(q)) {
                // 값 다 더해주기
                for (int i = 1; i <= n; i++) {
                    store[next][i] += store[q][i];
                }
                input[next]--;
                if (input[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (store[n][i] != 0) {
                bw.write(i + " " + store[n][i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

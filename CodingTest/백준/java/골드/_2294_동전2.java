package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _2294_동전2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int MAX = 100001;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, MAX);
        PriorityQueue<Integer> coin = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            coin.offer(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < n; i++) {
            int x = coin.poll();
            for (int j = 1; j <= k; j++) {
                if (j < x)
                    continue;
                if (j % x == 0) {
                    dp[j] = Math.min(dp[j], j / x);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - x] + 1);
                }
            }
        }
        if (dp[k] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}

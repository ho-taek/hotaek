package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2293_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                if (j < m) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - m];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[n][k]);
    }
}

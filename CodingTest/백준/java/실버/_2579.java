package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2579 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3];
        List<Integer> li = new ArrayList<>();

        // dp 그래프
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= n; i++) {
            // 1번 인덱스
            if (i == 1) {
                dp[1][1] = dp[1][0];
            }
            // 2번 인덱스
            if (i == 2) {
                dp[2][1] = dp[1][0] + dp[2][0];
                dp[2][2] = dp[2][0];
            }
            if (i >= 3) {
                dp[i][1] = dp[i - 1][2] + dp[i][0];
                dp[i][2] = Math.max(dp[i - 2][1], dp[i - 2][2]) + dp[i][0];
            }
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));

    }
}

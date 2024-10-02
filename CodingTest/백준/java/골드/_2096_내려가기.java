package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2096_내려가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][][] dp = new int[n][3][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(st.nextToken());
            dp[0][i][0] = value;
            dp[0][i][1] = value;
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[i][0][0] = Math.max(dp[i - 1][0][0] + a, dp[i - 1][1][0] + a);
            dp[i][1][0] = Math.max(dp[i][0][0], dp[i - 1][2][0] + b);
            dp[i][2][0] = Math.max(dp[i - 1][1][0] + c, dp[i - 1][2][0] + c);

            dp[i][0][1] = Math.min(dp[i - 1][0][1] + a, dp[i - 1][1][1] + a);
            dp[i][1][1] = Math.min(dp[i][0][1], dp[i - 1][2][1] + b);
            dp[i][2][1] = Math.min(dp[i - 1][1][1] + c, dp[i - 1][2][1] + c);
        }

        int max = Math.max(dp[n - 1][0][0], Math.max(dp[n - 1][1][0], dp[n - 1][2][0]));
        int min = Math.min(dp[n - 1][0][1], Math.min(dp[n - 1][1][1], dp[n - 1][2][1]));

        System.out.println(max + " " + min);
    }

}

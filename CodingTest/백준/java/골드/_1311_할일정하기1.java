package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1311_할일정하기1 {

    static int n;
    static int[][] w;
    static int[][] dp;
    static final int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        w = new int[n][n];

        dp = new int[n][(1 << n)];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dp(0, 0));
    }

    static int dp(int now, int flag) {
        if (now == n)
            return 0;
        if (dp[now][flag] != 0)
            return dp[now][flag];

        int result = INF;
        for (int i = 0; i < n; i++) {
            if ((flag & (1 << i)) == 0)
                result = Math.min(result, w[now][i] + dp(now + 1, flag | (1 << i)));
        }
        dp[now][flag] = result;
        return dp[now][flag];
    }

}

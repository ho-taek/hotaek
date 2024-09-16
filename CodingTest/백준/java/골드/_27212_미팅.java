package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _27212_미팅 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] w = new int[c + 1][c + 1];

        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arrA = new int[n + 1];
        int[] arrB = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= m; j++) {
            arrB[j] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + w[arrA[i]][arrB[j]], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        System.out.println(dp[n][m]);
    }
}

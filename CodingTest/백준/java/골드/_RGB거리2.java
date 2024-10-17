package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _RGB거리2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        int[][] dp = new int[n][n];

        int max = 1000001;

        int answer = max;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // RED -> 0, GREEN -> 1, BLUE -> 2
        for (int k = 0; k < 3; k++) {

            for (int i = 0; i < 3; i++) {
                if (k == i) {
                    dp[0][i] = graph[0][i];
                } else {
                    dp[0][i] = max;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + graph[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + graph[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + graph[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (k != i) {
                    answer = Math.min(answer, dp[n - 1][i]);
                }

            }
        }
        System.out.println(answer);

    }
}

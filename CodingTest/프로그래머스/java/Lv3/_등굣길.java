package 프로그래머스.java.Lv3;

import java.util.*;

public class _등굣길 {
    public int solution(int m, int n, int[][] puddles) {

        boolean[][] visited = new boolean[m + 1][n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < puddles.length; i++) { // visited 갱신
            int[] tmp = puddles[i];
            visited[tmp[0]][tmp[1]] = true;
        }
        int div = 1000000007;

        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j])
                    continue;

                if (i == 1 && j == 1)
                    continue;

                dp[i][j] += dp[i][j - 1] + dp[i - 1][j];
                dp[i][j] = dp[i][j] % div;
            }
        }

        return dp[m][n];
    }
}

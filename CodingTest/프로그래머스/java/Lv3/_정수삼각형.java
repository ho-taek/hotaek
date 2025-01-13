package 프로그래머스.java.Lv3;

import java.util.*;

public class _정수삼각형 {

    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;

        int xSize = triangle.length;

        int[][] dp = new int[xSize][xSize];

        dp[0][0] = triangle[0][0];

        for (int i = 0; i < xSize - 1; i++) { // x각
            int ySize = triangle[i].length;

            for (int j = 0; j < ySize; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
            }
        }

        for (int i = 0; i < triangle[xSize - 1].length; i++) {
            answer = Math.max(answer, dp[xSize - 1][i]);
        }

        return answer;
    }
}

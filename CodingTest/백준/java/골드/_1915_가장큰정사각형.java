package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1915_가장큰정사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        int answer = 0;
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0)
                    continue;
                flag = true;
                board[i][j] = Math.min(board[i - 1][j], Math.min(board[i - 1][j - 1], board[i][j - 1])) + 1;

                answer = Math.max(answer, board[i][j]);

            }
        }
        if (flag && answer == 0) {
            answer = 1;
        }

        System.out.println(answer * answer);
    }
}

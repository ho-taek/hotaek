package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10971_외판원순회2 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 11000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1 << n) - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 1));
    }

    public static int dfs(int city, int visited) {
        if (visited == (1 << n) - 1) {
            if (map[city][0] == 0) {
                return INF;
            }

            return map[city][0];
        }

        if (dp[city][visited] != -1) {
            return dp[city][visited];
        }

        dp[city][visited] = INF;

        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && map[city][i] != 0) {
                dp[city][visited] = Math.min(dp[city][visited], dfs(i, visited | (1 << i)) + map[city][i]);
            }
        }

        return dp[city][visited];
    }
}

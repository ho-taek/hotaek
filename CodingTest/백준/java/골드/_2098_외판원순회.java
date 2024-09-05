package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2098_외판원순회 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static final int INF = 11000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1 << n) - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1));
    }

    private static int dfs(int city, int visited) {
        if (visited == (1 << n) - 1) {
            if (map[city][0] == 0) {
                return INF;
            }
            return map[city][0]; // 완료되었으니까. 순환 싸이클 돌았을 때 시작 도시
        }

        if (dp[city][visited] != INF) { // 이미 방문한 곳일 경우
            return dp[city][visited];
        }

        for (int i = 0; i < n; i++) { // 현재 도시부터 각 도시로 이동한 경우의 DFS
            if ((visited & (1 << i)) == 0 && map[city][i] == 1) {
                dp[city][visited] = Math.min(dp[city][visited], dfs(i, visited | (1 << i)) + map[city][i]);
            }

        }
        return dp[city][visited];
    }
}

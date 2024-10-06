package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17090_미로탈출하기 {
    static int n, m;
    static char[][] graph;
    static int[][] state; // 0: 방문안한, 1: 방문중, 2: 방문했던
    static boolean[][] dp;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        dp = new boolean[n][m];
        state = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (state[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j])
                    answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        state[x][y] = 1; // 방문 중

        int dir = directionToIndex(graph[x][y]);
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            dp[x][y] = true;
        } else {
            if (state[nx][ny] == 0) {
                dfs(nx, ny);
                dp[x][y] = dp[nx][ny];
            } else if (state[nx][ny] == 2) {
                dp[x][y] = dp[nx][ny];
            }
        }

        state[x][y] = 2; // 방문 완료
    }

    public static int directionToIndex(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
            default:
                return -1;
        }
    }
}

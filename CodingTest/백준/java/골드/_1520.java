package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1520 {
    static int[][] graph;
    static int n;
    static int m;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] dp;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stg.nextToken());
            }
        }
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = dfs(new Node(0, 0));

        System.out.println(result);
    }

    public static int dfs(Node start) {
        System.out.println(start.x + " " + start.y);
        for (int a = 0; a < n; a++) {
            System.out.println(Arrays.toString(dp[a]));
        }
        System.out.println();

        if (start.x == n - 1 && start.y == m - 1) {
            return 1;
        }

        if (dp[start.x][start.y] > -1) {
            return dp[start.x][start.y];
        }

        dp[start.x][start.y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;

            if (graph[nx][ny] < graph[start.x][start.y]) {
                dp[start.x][start.y] += dfs(new Node(nx, ny));
            }

        }

        return dp[start.x][start.y];
    }
}

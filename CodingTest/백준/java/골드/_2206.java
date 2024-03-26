package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2206 {

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int[][] graph;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 기본 세팅
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        result = Integer.MAX_VALUE;
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] array = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(array[j]);
            }
        }

        // true 일때 벽 뚫은거, false 일 때 아직 안 뚫은거
        dfs(new Node(0, 0), false, 1);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    public static void dfs(Node start, boolean flag, int count) {
        if (start.x == n - 1 && start.y == m - 1) {
            if (result > count) {
                result = count;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = start.x + dx[i];
            int ny = start.y + dy[i];

            if (check(nx, ny) && !visited[nx][ny]) {
                if (graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    dfs(new Node(nx, ny), flag, count + 1);
                    visited[nx][ny] = false;
                } else if (graph[nx][ny] == 1 && !flag) {
                    visited[nx][ny] = true;
                    dfs(new Node(nx, ny), true, count + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static boolean check(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }

}

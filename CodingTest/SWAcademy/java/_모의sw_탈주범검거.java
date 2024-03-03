package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _모의sw_탈주범검거 {
    static int n;
    static int m;
    static int sr;
    static int sc;
    static int time;
    static int[][] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());

            // 그래프 그리기
            graph = new int[n][m];
            visited = new int[n][m];
            visited[sr][sc] = 1;
            for (int i = 0; i < n; i++) {
                StringTokenizer stg = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph[i][j] = Integer.parseInt(stg.nextToken());
                }
            }
            // for (int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(graph[i]));
            // }
            dfs(sr, sc, 1);
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] > 0) {
                        result++;
                    }
                }
            }

            // for (int i = 0; i < n; i++) {
            // System.out.println(Arrays.toString(visited[i]));
            // }

            System.out.println("#" + t + " " + result);

        }

    }

    public static void dfs(int x, int y, int count) {
        if (count == time) {

            return;
        }

        int pipe = graph[x][y];
        if (pipe == 1) {
            if (check(x, y, 1, count)) {
                visited[x - 1][y] = count;
                dfs(x - 1, y, count + 1);
            }
            if (check(x, y, 2, count)) {
                visited[x][y + 1] = count;
                dfs(x, y + 1, count + 1);
            }
            if (check(x, y, 3, count)) {
                visited[x + 1][y] = count;
                dfs(x + 1, y, count + 1);
            }
            if (check(x, y, 4, count)) {
                visited[x][y - 1] = count;
                dfs(x, y - 1, count + 1);
            }
        } else if (pipe == 2) {
            if (check(x, y, 1, count)) {
                visited[x - 1][y] = count;
                dfs(x - 1, y, count + 1);
            }
            if (check(x, y, 3, count)) {
                visited[x + 1][y] = count;
                dfs(x + 1, y, count + 1);
            }
        } else if (pipe == 3) {
            if (check(x, y, 2, count)) {
                visited[x][y + 1] = count;
                dfs(x, y + 1, count + 1);
            }
            if (check(x, y, 4, count)) {
                visited[x][y - 1] = count;
                dfs(x, y - 1, count + 1);
            }
        } else if (pipe == 4) {
            if (check(x, y, 1, count)) {
                visited[x - 1][y] = count;
                dfs(x - 1, y, count + 1);
            }
            if (check(x, y, 2, count)) {
                visited[x][y + 1] = count;
                dfs(x, y + 1, count + 1);
            }
        } else if (pipe == 5) {
            if (check(x, y, 2, count)) {
                visited[x][y + 1] = count;
                dfs(x, y + 1, count + 1);
            }
            if (check(x, y, 3, count)) {
                visited[x + 1][y] = count;
                dfs(x + 1, y, count + 1);
            }
        } else if (pipe == 6) {
            if (check(x, y, 3, count)) {
                visited[x + 1][y] = count;
                dfs(x + 1, y, count + 1);
            }
            if (check(x, y, 4, count)) {
                visited[x][y - 1] = count;
                dfs(x, y - 1, count + 1);
            }
        } else {
            if (check(x, y, 1, count)) {
                visited[x - 1][y] = count;
                dfs(x - 1, y, count + 1);
            }
            if (check(x, y, 4, count)) {
                visited[x][y - 1] = count;
                dfs(x, y - 1, count + 1);
            }
        }
    }

    // 1 -> 상, 2 -> 우, 3 -> 하, 4 -> 좌
    public static boolean check(int x, int y, int f, int count) {
        if (f == 1) {
            x = x - 1;
            return graphCheck(x, y) && checkPipe(x, y, f) && graph[x][y] != 0
                    && (visited[x][y] > count || visited[x][y] == 0);
        } else if (f == 2) {
            y = y + 1;
            return graphCheck(x, y) && checkPipe(x, y, f) && graph[x][y] != 0
                    && (visited[x][y] > count || visited[x][y] == 0);
        } else if (f == 3) {
            x = x + 1;
            return graphCheck(x, y) && checkPipe(x, y, f) && graph[x][y] != 0
                    && (visited[x][y] > count || visited[x][y] == 0);
        } else {
            y = y - 1;
            return graphCheck(x, y) && checkPipe(x, y, f) && graph[x][y] != 0
                    && (visited[x][y] > count || visited[x][y] == 0);
        }
    }

    public static boolean graphCheck(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean checkPipe(int x, int y, int flag) {
        if (flag == 1) {
            return graph[x][y] == 1 || graph[x][y] == 2 || graph[x][y] == 5 || graph[x][y] == 6;
        } else if (flag == 2) {
            return graph[x][y] == 1 || graph[x][y] == 3 || graph[x][y] == 6 || graph[x][y] == 7;
        } else if (flag == 3) {
            return graph[x][y] == 1 || graph[x][y] == 2 || graph[x][y] == 4 || graph[x][y] == 7;
        } else {
            return graph[x][y] == 1 || graph[x][y] == 3 || graph[x][y] == 4 || graph[x][y] == 5;
        }

    }
}

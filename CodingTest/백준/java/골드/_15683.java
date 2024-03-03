package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15683 {
    static int[][] graph;
    static List<Store> store;
    static int n;
    static int m;
    static int[][] tmp;
    static int min;

    static class Store {
        int x, y, tvNum;

        public Store(int x, int y, int tvNum) {
            this.x = x;
            this.y = y;
            this.tvNum = tvNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 및 cctv 정보 넣기
        graph = new int[n][m];
        store = new ArrayList<>();
        tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(stg.nextToken());
                graph[i][j] = value;
                if (value != 0 && value != 6) {
                    store.add(new Store(i, j, value));
                }
            }
        }

        min = Integer.MAX_VALUE;

        dfs(0, graph, store);

        System.out.println(min);
    }

    public static void dfs(int count, int[][] graph, List<Store> store) {
        if (count == store.size()) {
            int calc = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 0) {
                        calc++;
                    }
                }
            }
            if (calc < min) {
                min = calc;
            }
            return;
        }
        int x = store.get(count).x;
        int y = store.get(count).y;
        int num = store.get(count).tvNum;

        if (num == 1) {

            tmp = copy(graph);
            top(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            right(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            bottom(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            left(tmp, x, y);
            dfs(count + 1, tmp, store);

        } else if (num == 2) {
            tmp = copy(graph);
            left(tmp, x, y);
            right(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            top(tmp, x, y);
            bottom(tmp, x, y);
            dfs(count + 1, tmp, store);

        } else if (num == 3) {
            tmp = copy(graph);
            top(tmp, x, y);
            right(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            right(tmp, x, y);
            bottom(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            bottom(tmp, x, y);
            left(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            left(tmp, x, y);
            top(tmp, x, y);
            dfs(count + 1, tmp, store);

        } else if (num == 4) {
            tmp = copy(graph);
            left(tmp, x, y);
            top(tmp, x, y);
            right(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            top(tmp, x, y);
            right(tmp, x, y);
            bottom(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            right(tmp, x, y);
            bottom(tmp, x, y);
            left(tmp, x, y);
            dfs(count + 1, tmp, store);

            tmp = copy(graph);
            bottom(tmp, x, y);
            left(tmp, x, y);
            top(tmp, x, y);
            dfs(count + 1, tmp, store);
        } else {
            tmp = copy(graph);
            top(tmp, x, y);
            right(tmp, x, y);
            bottom(tmp, x, y);
            left(tmp, x, y);
            dfs(count + 1, tmp, store);

        }

    }

    public static int[][] copy(int[][] graph) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = graph[i][j];
                result[i][j] = value;
            }
        }
        return result;
    }

    public static void left(int[][] graph, int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (graph[x][i] == 6)
                return;
            if (graph[x][i] != 0)
                continue;
            graph[x][i] = -1;
        }
    }

    public static void right(int[][] graph, int x, int y) {
        for (int i = y + 1; i < m; i++) {
            if (graph[x][i] == 6)
                return;
            if (graph[x][i] != 0)
                continue;
            graph[x][i] = -1;
        }
    }

    public static void top(int[][] graph, int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (graph[i][y] == 6)
                return;
            if (graph[i][y] != 0)
                continue;
            graph[i][y] = -1;
        }
    }

    public static void bottom(int[][] graph, int x, int y) {
        for (int i = x + 1; i < n; i++) {
            if (graph[i][y] == 6)
                return;
            if (graph[i][y] != 0)
                continue;
            graph[i][y] = -1;
        }
    }
}

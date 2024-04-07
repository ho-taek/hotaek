package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1520 {
    static int result;

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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        result = 0;
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stg.nextToken());
            }
        }

        bfs(new Node(0, 0), n, m, graph);
        System.out.println(result);
    }

    public static void bfs(Node start, int n, int m, int[][] graph) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (graph[q.x][q.y] > graph[nx][ny]) {
                    if (nx == (n - 1) && ny == (m - 1)) {
                        result++;
                    }
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }
}

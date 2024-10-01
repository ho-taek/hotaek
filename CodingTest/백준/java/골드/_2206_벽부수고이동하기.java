package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2206_벽부수고이동하기 {

    public static class Node {
        int x;
        int y;
        int count;
        boolean destroyed;

        public Node(int x, int y, int count, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.destroyed = destroyed;
        }
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static int[][] graph;
    static boolean[][][] visited;
    static int n;
    static int m;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs(new Node(0, 0, 1, false));

    }

    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y][0] = true;

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            if (q.x == (n - 1) && q.y == (m - 1)) {
                System.out.println(q.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                int nextCount = q.count + 1;

                if (graph[nx][ny] == 0) {
                    if (!q.destroyed && !visited[nx][ny][0]) {
                        queue.offer(new Node(nx, ny, nextCount, false));
                        visited[nx][ny][0] = true;
                    } else if (q.destroyed && !visited[nx][ny][1]) {
                        queue.offer(new Node(nx, ny, nextCount, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if (!q.destroyed) {
                        queue.offer(new Node(nx, ny, nextCount, true));
                        visited[nx][ny][1] = true;
                    }

                }

            }

        }
        System.out.println(-1);
    }
}

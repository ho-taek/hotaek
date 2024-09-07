package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _27211_도넛행성 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;

    public static class Node {
        int x;
        int y;

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

        map = new int[n][m];
        visited = new boolean[n][m];

        List<Node> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) {
                    li.add(new Node(i, j));
                }
                map[i][j] = value;
            }
        }

        int answer = 0;
        for (Node node : li) {
            if (visited[node.x][node.y])
                continue;
            bfs(node);
            answer++;
        }

        System.out.println(answer);
    }

    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if (nx < 0) {
                    nx = n - 1;
                }
                if (nx >= n) {
                    nx = 0;
                }
                if (ny < 0) {
                    ny = m - 1;
                }
                if (ny >= m) {
                    ny = 0;
                }
                if (visited[nx][ny] || map[nx][ny] != 0)
                    continue;

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny));
            }
        }
    }
}

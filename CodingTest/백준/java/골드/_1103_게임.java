package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1103 {
    static int[][] graph;
    static int[] dx;
    static int[] dy;

    static int n;
    static int m;
    static int result;

    public static class Node {
        int x, y, time, value;

        public Node(int x, int y, int time, int value) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] stg = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (stg[j].equals("H")) {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = Integer.parseInt(stg[j]);
                }
            }

        }

        result = 0;
        bfs(new Node(0, 0, 1, graph[0][0]));
        System.out.println(result);
    }

    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node q = queue.poll();
            if (result < q.time) {
                result = q.time;
            }
            dx = makeDist(true, q.value);
            dy = makeDist(false, q.value);
            for (int i = 0; i < 4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (q.value == graph[nx][ny]) {

                    result = -1;
                    break;
                }

                if (graph[nx][ny] != -1) {
                    queue.offer(new Node(nx, ny, q.time + 1, graph[nx][ny]));
                }
            }
        }
    }

    public static int[] makeDist(boolean flag, int value) {
        if (flag) {
            return new int[] { 0, 0, -value, value };
        } else {
            return new int[] { -value, value, 0, 0 };
        }
    }
}

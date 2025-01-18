package 백준.java.골드;

import java.util.*;

import 알고리즘.dfs;

import java.io.*;

public class _16197_두동전 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] graph;
    static int n;
    static int m;
    static boolean flag;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        // 빈칸 -> 0, 벽 -> 1, 동전 -> 2
        List<Node> start = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 그래프 초기화
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (s[j].equals(".")) {
                    graph[i][j] = 0;
                } else if (s[j].equals("#")) {
                    graph[i][j] = 1;
                } else {
                    start.add(new Node(i, j));
                    graph[i][j] = 2;
                }
            }
        }
        Node a = start.get(0);
        Node b = start.get(1);
        dfs(a, b, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void dfs(Node a, Node b, int count) {

        if (count > 10) {
            return;
        }

        if (check(a) && check(b)) {
            return;
        }

        if (check(a) || check(b)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < 4; i++) {

            int ax = a.x + dx[i];
            int ay = a.y + dy[i];
            int bx = b.x + dx[i];
            int by = b.y + dy[i];

            if (isWall(ax, ay)) {
                ax = a.x;
                ay = a.y;
            }
            if (isWall(bx, by)) {
                bx = b.x;
                by = b.y;
            }
            Node nextA = new Node(ax, ay);
            Node nextB = new Node(bx, by);

            dfs(nextA, nextB, count + 1);

        }

    }

    public static boolean check(Node node) {
        return node.x < 0 || node.x >= n || node.y < 0 || node.y >= m;
    }

    static boolean isWall(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && graph[x][y] == 1;
    }
}

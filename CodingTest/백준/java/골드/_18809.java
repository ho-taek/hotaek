package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _18809 {
    static int[][] graph;
    static List<int[]> can;
    static char[] seed;
    static int[] index;
    static int n;
    static int m;
    static int g;
    static int r;
    static boolean[] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][][] check;
    static int setFlower = Integer.MIN_VALUE;

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
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        seed = new char[g + r];
        index = new int[g + r];
        visited = new boolean[g + r];
        int gIndex = g;
        int rIndex = r;
        // g와 r 합친 것 & index 조합 구해줄 것
        for (int i = 0; i < g + r; i++) {
            index[i] = i;
            if (gIndex > 0) {
                seed[i] = 'G';
                gIndex--;
                continue;
            }
            if (rIndex > 0) {
                seed[i] = 'R';
                rIndex--;
                continue;
            }
        }

        // 그래프와 배양할 수 있는 땅 값 넣기
        graph = new int[n][m];
        can = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(stg.nextToken());
                graph[i][j] = value;
                if (value == 2) {
                    can.add(new int[] { i, j });
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        perm(result, 0);
        System.out.println(setFlower);
    }

    public static void perm(List<Integer> result, int start) {
        if (result.size() == (g + r)) {
            flower(result);
            return;
        }

        for (int i = 0; i < (g + r); i++) {
            if (!visited[i]) {
                result.add(i);
                visited[i] = true;
                perm(result, start + 1);
                result.remove(result.size() - 1);
                visited[i] = false;
            }

        }

    }

    public static void flower(List<Integer> result) {
        check = new int[n][m][2];

        for (int i = 0; i < result.size(); i++) {
            boolean flag = (seed[i] == 'G') ? true : false;
            int x = can.get(result.get(i))[0];
            int y = can.get(result.get(i))[1];
            bfs(new Node(x, y), flag, check);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (graph[i][j] != 0 && (check[i][j][0] == check[i][j][1])) {
                    answer++;
                }
            }
        }
        setFlower = (answer > setFlower) ? answer : setFlower;
    }

    // flag : true -> G, false -> R
    public static void bfs(Node start, boolean flag, int[][][] check) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        if (flag) {
            check[start.x][start.y][0] = 1;
        } else {
            check[start.x][start.y][1] = 1;
        }

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (flag) {
                        if (check[nx][ny][0] == 0 && graph[nx][ny] != 0) {
                            check[nx][ny][0] = check[q.x][q.y][0] + 1;
                            queue.offer(new Node(nx, ny));
                        }
                    } else {
                        if (check[nx][ny][1] == 0 && graph[nx][ny] != 0) {
                            check[nx][ny][1] = check[q.x][q.y][1] + 1;
                            queue.offer(new Node(nx, ny));
                        }
                    }
                }
            }

        }

    }

}

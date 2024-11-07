package 백준.java.플레;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _11438_LCA2 {

    static int[][] parent;
    static List<List<Integer>> v;
    static boolean[] check;
    static LinkedList<Integer> queue;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1][17];
        check = new boolean[n + 1];
        depth = new int[n + 1];
        v = new ArrayList<>();
        queue = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            v.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            v.get(a).add(b);
            v.get(b).add(a);
        }

        bfs(1);

        // Sparse Table
        for (int j = 1; (1 << j) < n; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] != 0) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                }
            }
        }

        int count = Integer.parseInt(br.readLine());

        for (int c = 0; c < count; c++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(lca(x, y) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x) {
        check[x] = true;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int j : v.get(current)) {
                if (!check[j]) {
                    check[j] = true;
                    parent[j][0] = current;
                    depth[j] = depth[current] + 1;
                    queue.offer(j);
                }
            }
        }
    }

    static int lca(int x, int y) {
        if (depth[x] < depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }

        for (int i = 16; i >= 0; i--) {
            if (depth[x] - (1 << i) >= depth[y]) {
                x = parent[x][i];
            }
        }

        if (x == y)
            return x;

        for (int i = 16; i >= 0; i--) {
            if (parent[x][i] != parent[y][i]) {
                x = parent[x][i];
                y = parent[y][i];
            }
        }

        return parent[x][0];
    }
}

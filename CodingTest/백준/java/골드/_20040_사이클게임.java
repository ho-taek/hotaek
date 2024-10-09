package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _20040_사이클게임 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {
                System.out.println(i);
                return;
            }

            union(x, y);
        }

        System.out.println(answer);

    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}

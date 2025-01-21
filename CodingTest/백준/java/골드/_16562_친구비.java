package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _16562_친구비 {

    static int[] price;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        price = new int[n + 1];
        parent = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) { // 가격
            price[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) { // 관계
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int tmp = 0;

        Set<Integer> check = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            int root = find(parent[i]);
            if (!check.contains(root)) {
                tmp += price[root];
                check.add(root);
            }
        }
        if (tmp > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(tmp);
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (price[x] > price[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}

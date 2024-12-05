package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2042_구간합구하기2 {
    static long[] a;
    static long[] tree;

    public static void init(int node, int start, int end) {

        if (start == end) {
            tree[node] = a[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void update(int node, int start, int end, int index, long value) {
        if (start > index || end < index) {
            return;
        }

        if (start == end) {
            tree[node] = value;
            return;
        }
        int mid = (start + end) / 2;

        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1, end, index, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return 0;
        }

        if (start >= left && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        a = new long[n + 1];
        tree = new long[4 * n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }
        init(1, 1, n);

        m += k;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            if (type == 1) {
                update(1, 1, n, x, y);
            } else {
                System.out.println(query(1, 1, n, x, (int) y));
            }
        }

    }
}

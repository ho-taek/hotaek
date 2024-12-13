package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _12837_가계부 {
    static long[] arr;
    static long[] tree;

    public static void update(int node, int start, int end, int index, long value) {

        if (start > index || end < index) {
            return;
        }

        if (start == end) {
            tree[node] += value;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[4 * n + 1];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 1, n, p, x);
            } else {
                bw.write(query(1, 1, n, p, (int) x) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _14438_수열과쿼리17 {
    static long a[];
    static long d[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        a = new long[n + 1];
        d = new long[4 * n + 1];

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, 1, n, b, c);
            } else {
                bw.write(query(1, 1, n, b, c) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void init(int node, int start, int end) {

        if (start == end) {
            d[node] = a[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        d[node] = Math.min(d[node * 2], d[node * 2 + 1]);
    }

    public static void update(int node, int start, int end, int i, long value) {

        if (start > i || end < i) {
            return;
        }

        if (start == end) {
            d[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, i, value);
        update(node * 2 + 1, mid + 1, end, i, value);
        d[node] = Math.min(d[node * 2], d[node * 2 + 1]);
    }

    public static long query(int node, int start, int end, int left, long right) {

        if (start > right || end < left) {
            return Long.MAX_VALUE;
        }

        if (start >= left && end <= right) {
            return d[node];
        }

        int mid = (start + end) / 2;
        return Math.min(query(node * 2, start, mid, left, right), query(node * 2 + 1, mid + 1, end, left, right));

    }
}

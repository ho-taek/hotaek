package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _11505_구간곱구하기 {
    static long[] a;
    static long[] d;
    static long div = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new long[n + 1];
        d = new long[4 * n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, n);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (type == 1) {
                update(1, 1, n, x, Long.parseLong(st.nextToken()));
            } else {
                bw.write(query(1, 1, n, x, Integer.parseInt(st.nextToken())) % div + "\n");
            }
        }
        bw.flush();
        bw.close();

    }

    public static void init(int node, int start, int end) {
        if (start == end) {
            d[node] = a[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        d[node] = d[node * 2] * d[node * 2 + 1] % div;
    }

    public static long query(int node, int start, int end, int i, int j) {
        if (end < i || start > j)
            return 1;

        if (i <= start && j >= end)
            return d[node] % div;

        int mid = (start + end) / 2;

        return query(node * 2, start, mid, i, j) * query(node * 2 + 1, mid + 1, end, i, j) % div;
    }

    public static void update(int node, int start, int end, int i, long value) {
        if (i > end || i < start)
            return;

        if (start == end) {
            d[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        update(node * 2, start, mid, i, value);
        update(node * 2 + 1, mid + 1, end, i, value);

        d[node] = d[node * 2] * d[node * 2 + 1] % div;
    }
}

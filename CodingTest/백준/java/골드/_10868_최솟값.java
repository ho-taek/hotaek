package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _10868_최솟값 {
    static long[] arr;
    static long[] tree;

    public static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    public static long query(int node, int start, int end, int left, int right) {

        if (start > right || end < left) {
            return Long.MAX_VALUE;
        }

        if (start >= left && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(query(node * 2, start, mid, left, right), query(node * 2 + 1, mid + 1, end, left, right));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[4 * n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(query(1, 1, n, a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

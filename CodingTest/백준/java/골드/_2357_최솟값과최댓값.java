package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _2357_최솟값과최댓값 {
    static long[] arr;
    static long[] smallTree;
    static long[] largeTree;

    public static void init(int node, int start, int end) {

        if (start == end) {
            smallTree[node] = arr[start];
            largeTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        smallTree[node] = Math.min(smallTree[node * 2], smallTree[node * 2 + 1]);
        largeTree[node] = Math.max(largeTree[node * 2], largeTree[node * 2 + 1]);
    }

    // flag -> true : 최소, false : 최대
    public static long query(int node, int start, int end, int left, int right, boolean flag) {
        if (start > right || end < left) {
            if (flag) {
                return Long.MAX_VALUE;
            } else {
                return Long.MIN_VALUE;
            }
        }

        if (start >= left && end <= right) {
            if (flag) {
                return smallTree[node];
            } else {
                return largeTree[node];
            }
        }
        int mid = (start + end) / 2;
        if (flag) {
            return Math.min(query(node * 2, start, mid, left, right, flag),
                    query(node * 2 + 1, mid + 1, end, left, right, flag));
        } else {
            return Math.max(query(node * 2, start, mid, left, right, flag),
                    query(node * 2 + 1, mid + 1, end, left, right, flag));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        smallTree = new long[4 * n + 1];
        largeTree = new long[4 * n + 1];

        for (int i = 1; i <= n; i++) {
            long val = Long.parseLong(br.readLine());
            arr[i] = val;
        }

        init(1, 1, n);

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(query(1, 1, n, x, y, true) + " " + query(1, 1, n, x, y, false) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

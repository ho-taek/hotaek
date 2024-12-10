package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14428_수열과쿼리16 {
    static long[] arr;
    static long[][] tree;

    public static void init(int node, int start, int end) {
        if (start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = start;
            return;
        }

        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);

        long left = tree[node * 2][0];
        long right = tree[node * 2 + 1][0];

        if (left < right) {
            tree[node][0] = tree[node * 2][0];
            tree[node][1] = tree[node * 2][1];
        } else if (right < left) {
            tree[node][0] = tree[node * 2 + 1][0];
            tree[node][1] = tree[node * 2 + 1][1];
        } else {
            if (tree[node * 2 + 1][1] < tree[node * 2][1]) {
                tree[node][0] = tree[node * 2 + 1][0];
                tree[node][1] = tree[node * 2 + 1][1];
            } else {
                tree[node][0] = tree[node * 2][0];
                tree[node][1] = tree[node * 2][1];
            }
        }
    }

    public static void update(int node, int start, int end, int index, int value) {

        if (start > index || end < index) {
            return;
        }

        if (start == end) {
            tree[node][0] = value;
            tree[node][1] = index;
            return;
        }

        int mid = (start + end) / 2;
        update(node * 2, start, mid, index, value);
        update(node * 2 + 1, mid + 1, end, index, value);

        long left = tree[node * 2][0];
        long right = tree[node * 2 + 1][0];

        if (left < right) {
            tree[node][0] = tree[node * 2][0];
            tree[node][1] = tree[node * 2][1];
        } else if (right < left) {
            tree[node][0] = tree[node * 2 + 1][0];
            tree[node][1] = tree[node * 2 + 1][1];
        } else {
            if (tree[node * 2 + 1][1] < tree[node * 2][1]) {
                tree[node][0] = tree[node * 2 + 1][0];
                tree[node][1] = tree[node * 2 + 1][1];
            } else {
                tree[node][0] = tree[node * 2][0];
                tree[node][1] = tree[node * 2][1];
            }
        }
    }

    public static long[] query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return new long[] { Long.MAX_VALUE, Long.MAX_VALUE };
        }

        if (start >= left && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        long[] leftValue = query(node * 2, start, mid, left, right);
        long[] rightValue = query(node * 2 + 1, mid + 1, end, left, right);
        if (leftValue[0] < rightValue[0]) {
            return leftValue;
        } else if (leftValue[0] > rightValue[0]) {
            return rightValue;
        } else {
            if (leftValue[1] > rightValue[1]) {
                return rightValue;
            } else {
                return leftValue;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new long[n + 1];
        tree = new long[4 * n + 1][2];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, n);

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 1, n, b, c);
            } else {
                bw.write(query(1, 1, n, b, c)[1] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

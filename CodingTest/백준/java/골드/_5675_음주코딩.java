package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _5675_음주코딩 {
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
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    public static void update(int node, int start, int end, int index, int value) {

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
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }

    public static long query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return 1;
        }

        if (start >= left && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new long[n + 1];
            tree = new long[4 * n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > 0) {
                    arr[i] = 1;
                } else if (value == 0) {
                    arr[i] = 0;
                } else {
                    arr[i] = -1;
                }
            }

            init(1, 1, n);

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (s.equals("C")) {
                    if (c == 0) {
                        update(1, 1, n, b, 0);
                    } else if (c > 0) {
                        update(1, 1, n, b, 1);
                    } else {
                        update(1, 1, n, b, -1);
                    }

                } else {
                    long tmp = query(1, 1, n, b, c);
                    if (tmp == 0) {
                        bw.write("0");
                    } else if (tmp > 0) {
                        bw.write("+");
                    } else {
                        bw.write("-");
                    }
                }
            }
            bw.write("\n");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();

    }
}

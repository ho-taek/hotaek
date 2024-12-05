package 알고리즘;

import java.io.*;
import java.util.*;

public class _세그먼트트리 {
    static long[] a; // -> 배열
    static long[] d; // -> 세그트리

    // node -> 노드 번호

    // 세그먼트 트리 초기 세팅
    public static void init(int node, int start, int end) {
        if (start == end) {
            d[node] = a[start];
            return;
        }
        int mid = (start + end) / 2;
        init(node * 2, start, mid);
        init(node * 2 + 1, mid + 1, end);
        d[node] = d[node * 2] + d[node * 2 + 1];
    }

    public static void update(int node, int start, int end, int i, long val) {
        if (start > i || end < i)
            return; // 범위를 벗어날 때
        if (start == end) {
            d[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, i, val);
        update(node * 2 + 1, mid + 1, end, i, val);
        d[node] = d[node * 2] + d[node * 2 + 1];
    }

    // i부터 j까지의 구간합구하기
    public static long query(int node, int start, int end, int i, int j) {

        if (start > j || end < i)
            return 0;
        if (start >= i && end <= j)
            return d[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, i, j) + query(node * 2 + 1, mid + 1, end, i, j);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

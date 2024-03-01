package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17471 {
    static int[][] graph;
    static boolean[] visited;
    static int[] score;
    static int[] node;
    static int result;
    static List<int[]> middle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n값
        int n = Integer.parseInt(br.readLine());

        // 노드
        node = new int[n];

        // score -> 인구수
        score = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            node[i] = (i + 1);
        }

        // graph
        graph = new int[n][];
        for (int i = 0; i < n; i++) {
            StringTokenizer sta = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(sta.nextToken());
            int[] side = new int[m];
            for (int j = 0; j < m; j++) {
                side[j] = Integer.parseInt(sta.nextToken());
            }
            graph[i] = side;
        }

        result = Integer.MAX_VALUE;

        // 조합 구해서 a,b 구하기
        for (int i = 1; i < (n / 2 + 1); i++) {
            visited = new boolean[n];
            comb(n, i, 0);
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    public static void comb(int n, int r, int start) {
        // a,b 구하기
        if (r == 0) {
            middle = new ArrayList<>();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    a.add(node[i]);
                } else {
                    b.add(node[i]);
                }
            }
            // 여기서 bfs로 확인하는 거 구해야 함
            if (!a.isEmpty() && !b.isEmpty() && bfs(b, n) && bfs(a, n)) {
                int tmp = Math.abs(count(a) - count(b));
                if (result > tmp) {
                    result = tmp;
                }
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(n, r - 1, start + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean bfs(List<Integer> list, int n) {
        boolean[] visited = new boolean[n];
        boolean flag = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(list.get(0));
        visited[list.get(0) - 1] = true;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int l : graph[q - 1]) {
                if (!visited[l - 1] && list.contains(l)) {
                    queue.offer(l);
                    visited[l - 1] = true;
                }
            }
        }
        for (Integer s : list) {
            if (!visited[s - 1]) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static int count(List<Integer> list) {
        int count = 0;
        for (int i : list) {
            count += score[i - 1];
        }
        return count;
    }
}

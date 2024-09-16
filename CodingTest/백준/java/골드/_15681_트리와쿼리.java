package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _15681_트리와쿼리 {

    static int[] answer;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        answer = new int[n + 1];
        Arrays.fill(answer, 1);

        dfs(r, -1);

        for (int i = 0; i < q; i++) {
            int idx = Integer.parseInt(br.readLine());
            System.out.println(answer[idx]);
        }

    }

    static void dfs(int idx, int pas) {
        for (int n : graph.get(idx)) {
            if (pas != n) {
                dfs(n, idx);
            }
        }

        if (pas != -1) {
            answer[pas] += answer[idx];
        }

    }
}

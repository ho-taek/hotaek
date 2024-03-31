package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

public class _1674 {

    static List<List<Edge>> graph;

    static class Edge implements Comparable<Edge> {
        int w, weight;

        public Edge(int w, int weight) {
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return this.w + " " + this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < (n + 1); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(stg.nextToken());
            int t = Integer.parseInt(stg.nextToken());
            int w = Integer.parseInt(stg.nextToken());

            graph.get(f).add(new Edge(t, w));
            graph.get(t).add(new Edge(f, w));
        }

        prim(1, n);
    }

    public static void prim(int start, int n) {
        boolean[] visit = new boolean[n + 1];
        int maxDist = Integer.MIN_VALUE;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            System.out.println(edge);
            int v = edge.w;
            int cost = edge.weight;

            if (visit[v])
                continue;

            visit[v] = true;
            total += cost;
            if (cost > maxDist) {
                maxDist = cost;
            }

            for (Edge e : graph.get(v)) {
                if (!visit[e.w]) {
                    pq.offer(e);
                }
            }
        }

        System.out.println(total - maxDist);
    }
}

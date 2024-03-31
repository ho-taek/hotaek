package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13418 {
    static class Edge {
        int w, cost;
        boolean type;

        public Edge(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }
    }

    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < (n + 1); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < (m + 1); i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stg.nextToken());
            int to = Integer.parseInt(stg.nextToken());
            int cost = Integer.parseInt(stg.nextToken());

            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        PriorityQueue<Edge> pqMax = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        PriorityQueue<Edge> pqMin = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cost, o1.cost));

        int hard = prim(0, n, pqMax);
        int easy = prim(0, n, pqMin);
        System.out.println((int) (Math.pow(hard, 2) - Math.pow(easy, 2)));
    }

    public static int prim(int start, int n, PriorityQueue<Edge> pq) {
        boolean[] visited = new boolean[n + 1];

        pq.offer(new Edge(start, 0));

        int count = 0;
        while (!pq.isEmpty()) {
            Edge edgeE = pq.poll();
            int w = edgeE.w;
            int cost = edgeE.cost;

            if (visited[w])
                continue;

            visited[w] = true;
            if (edgeE.cost == 1) {
                count++;
            }

            for (Edge e : graph.get(w)) {
                if (!visited[e.w]) {
                    pq.offer(e);
                }
            }
        }

        return n - count;
    }

}

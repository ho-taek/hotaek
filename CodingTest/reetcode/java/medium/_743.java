package reetcode.java.medium;

import java.util.*;

class Solution {
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();

        for (int i = 0; i < (n + 1); i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] array : times) {
            graph.get(array[0]).add(new Node(array[1], array[2]));
        }

        dijkstra(k, dist, check);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == INF) {
                return -1;
            }
            if (dist[i] > result) {
                result = dist[i];
            }
        }
        return result;
    }

    public static void dijkstra(int start, int[] dist, boolean[] check) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node q = pq.poll();

            if (check[q.index])
                continue;
            check[q.index] = true;

            for (Node gr : graph.get(q.index)) {
                if (dist[gr.index] > dist[q.index] + gr.cost) {
                    dist[gr.index] = dist[q.index] + gr.cost;

                    pq.offer(new Node(gr.index, dist[gr.index]));
                }
            }
        }
    }
}
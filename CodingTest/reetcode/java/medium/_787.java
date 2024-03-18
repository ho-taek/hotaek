package reetcode.java.medium;

import java.util.*;

public class _787 {
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int index, cost, count;

        public Node(int index, int cost, int count) {
            this.index = index;
            this.cost = cost;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 시작점 -> src, 도착점 -> dst, 경유지 개수 -> k
        graph = new ArrayList<>();

        // 그래프 생성
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] array : flights) {
            graph.get(array[0]).add(new Node(array[1], array[2], -1));
        }
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        boolean[] check = new boolean[n];

        Arrays.fill(dist, INF);
        dijkstra(src, dist, check, k);

        return dist[dst];
    }

    public static void dijkstra(int start, int[] dist, boolean[] check, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node q = pq.poll();
            if (check[q.index])
                continue;
            check[q.index] = true;

            for (Node next : graph.get(q.index)) {
                int checkCount = q.count + 1;
                if (checkCount <= k && dist[next.index] > dist[q.index] + next.cost) {
                    dist[next.index] = dist[q.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index], checkCount));
                }
            }
        }
    }
}

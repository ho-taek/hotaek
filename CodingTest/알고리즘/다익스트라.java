package 알고리즘;

import java.util.*;

public class 다익스트라 {
    class Node implements Comparable<Node> {
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

    public static void Dijkstra(int n, int start) {

        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if (check[nowVertex])
                continue;
            check[nowVertex] = true;

            for (Node next : graph[nowVertex]) {
                if (dist[next.index] > dist[nowVertex] + next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }

            for (int i : dist) {
                if (i == INF)
                    System.out.print(0 + " ");
                else
                    System.out.print(i + " ");
            }
        }
    }
}

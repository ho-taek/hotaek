package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17835 {

    static List<List<Node>> graph;
    static int[] result;
    static int INF = Integer.MAX_VALUE;
    static List<Integer> city;

    static class Node implements Comparable<Node> {
        int dist, cost;

        public Node(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer stg = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stg.nextToken());
            int to = Integer.parseInt(stg.nextToken());
            int cost = Integer.parseInt(stg.nextToken());
            graph.get(to).add(new Node(from, cost));
        }

        city = new ArrayList<>();

        StringTokenizer sta = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            city.add(Integer.parseInt(sta.nextToken()));
        }

        result = new int[n + 1];
        Arrays.fill(result, INF);

        for (int i = 0; i < k; i++) {
            dijkstra(city.get(i), n);
        }
        int resultCity = 0;
        int resultDist = 0;
        for (int i = 1; i <= n; i++) {
            if (resultDist < result[i]) {
                resultDist = result[i];
                resultCity = i;
            }
        }

        System.out.println(resultCity + "\n" + resultDist);
    }

    public static void dijkstra(int start, int n) {

        boolean[] check = new boolean[n + 1];

        int[] dist = new int[n + 1];

        Arrays.fill(dist, INF);

        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().dist;

            if (check[nowVertex])
                continue;
            check[nowVertex] = true;

            for (Node next : graph.get(nowVertex)) {
                if (dist[next.dist] > dist[nowVertex] + next.cost) {
                    dist[next.dist] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.dist, dist[next.dist]));
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            if (result[i] > dist[i]) {
                result[i] = dist[i];
            }
        }
    }
}

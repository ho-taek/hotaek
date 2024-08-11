package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10282_해킹 {

    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] visited;

    public static class Node implements Comparable<Node> {
        int computer;
        int cost;

        public Node(int computer, int cost) {
            this.computer = computer;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= a; i++) {
                graph.add(new ArrayList<Node>());
            }

            for (int i = 0; i < b; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(y).add(new Node(x, cost));

            }

            visited = new boolean[a + 1];
            dist = new int[a + 1];

            int INF = Integer.MAX_VALUE;

            Arrays.fill(dist, INF);

            dijkstra(new Node(s, 0));
            int[] answer = new int[2];

            for (int i = 1; i <= a; i++) {
                if (dist[i] != INF) {
                    answer[0]++;
                    if (dist[i] > answer[1]) {
                        answer[1] = dist[i];
                    }
                }

            }
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public static void dijkstra(Node start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(start);

        dist[start.computer] = 0;

        while (!pq.isEmpty()) {
            Node nowVertex = pq.poll();

            if (visited[nowVertex.computer])
                continue;
            visited[nowVertex.computer] = true;

            for (Node now : graph.get(nowVertex.computer)) {
                if (dist[now.computer] > dist[nowVertex.computer] + now.cost) {
                    dist[now.computer] = dist[nowVertex.computer] + now.cost;

                    pq.offer(new Node(now.computer, dist[now.computer]));
                }
            }
        }
    }

}

package 프로그래머스.java.Lv2;

import java.util.*;

class Solution {

    public static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int N, int[][] road, int K) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Node>> li = new ArrayList();

        for (int i = 0; i <= N; i++) {
            li.add(new ArrayList());
        }

        for (int i = 0; i < road.length; i++) { // Node 리스트 데이터 넣기
            int x = road[i][0];
            int y = road[i][1];
            int cost = road[i][2];

            li.get(x).add(new Node(y, cost));
            li.get(y).add(new Node(x, cost));
        }
        // 다익스트라
        dist[1] = 0;

        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            for (Node node : li.get(q.vertex)) {
                int v = node.vertex;
                int newDist = node.cost + dist[q.vertex];

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    queue.offer(new Node(v, newDist));
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) { // K보다 작은 것
            if (dist[i] <= K) {
                answer += 1;
            }
        }

        return answer;
    }
}

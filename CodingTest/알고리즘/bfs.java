package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    static boolean[] visited = new boolean[7]; // 0번 인덱스는 제외
    static int[][] graph = { {}, { 2, 4 }, { 1, 3 }, { 2 }, { 1, 5, 6 }, { 4, 6 }, { 4, 5 } };

    public static void main(String[] args) {

        bfs(1);
    }

    public static void bfs(int startIndex) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startIndex);
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            int nodeIndex = queue.poll();
            System.out.print(nodeIndex + " ");

            for (int node : graph[nodeIndex]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(node);
                }
            }

        }

    }
}

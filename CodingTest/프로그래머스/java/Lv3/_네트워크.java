package 프로그래머스.java.Lv3;

import java.util.LinkedList;
import java.util.Queue;

public class _네트워크 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    public static void bfs(int[][] computers, int startIndex) {
        Queue<Integer> queue = new LinkedList<>();

        visited[startIndex] = true;
        queue.offer(startIndex);

        while (!queue.isEmpty()) {
            int q = queue.poll();

            for (int node = 0; node < computers[q].length; node++) {
                if (visited[node] || computers[q][node] != 1)
                    continue;

                visited[node] = true;
                queue.offer(node);

            }
        }
    }
}

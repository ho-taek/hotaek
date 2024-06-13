package 알고리즘;

import java.util.ArrayDeque;
import java.util.Deque;

public class dfs {

    static boolean[] visited = new boolean[7]; // 0번 인덱스는 제외
    static int[][] graph = { {}, { 2, 4 }, { 1, 3 }, { 2 }, { 1, 5, 6 }, { 4, 6 }, { 4, 5 } };

    public static void main(String[] args) {
        dfs(1);
        System.out.println();
        dfsStack(1);
    }

    public static void dfs(int index) {
        visited[index] = true;

        System.out.print(index + " ");

        for (int node : graph[index]) {
            if (!visited[node]) {
                dfs(node);
            }
        }

    }

    public static void dfsStack(int startIndex) {
        visited = new boolean[7];

        Deque<Integer> stack = new ArrayDeque<>();

        stack.offer(startIndex);
        visited[startIndex] = true;

        while (!stack.isEmpty()) {

            int nodeIndex = stack.pollLast();

            System.out.print(nodeIndex + " ");

            for (int node : graph[nodeIndex]) {
                if (!visited[node]) {
                    visited[node] = true;
                    stack.offer(node);
                }
            }
        }

    }

}

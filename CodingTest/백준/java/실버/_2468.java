package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2468 {

  static boolean[][] visited;

  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] graph = new int[n][n];
    int max = Integer.MIN_VALUE;

    // 그래프 만들기
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int value = Integer.parseInt(st.nextToken());
        graph[i][j] = value;
        if (value > max) {
          max = value;
        }
      }
    }
    int maxValue = 0;

    for (int i = 0; i <= max; i++) {
      int answer = 0;
      visited = new boolean[n][n];
      for (int a = 0; a < n; a++) {
        for (int b = 0; b < n; b++) {
          if (graph[a][b] > i && !visited[a][b]) {
            bfs(new Node(a, b), n, i, graph, visited);
            answer++;
          }
        }
      }
      maxValue = (answer > maxValue) ? answer : maxValue;
    }
    System.out.println(maxValue);
  }

  public static void bfs(Node node, int m, int check, int[][] graph, boolean[][] visited) {
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };
    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    visited[node.x][node.y] = true;
    while (!queue.isEmpty()) {
      Node q = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];
        if (nx >= 0 && nx < m && ny >= 0 && ny < m) {
          if (graph[nx][ny] > check && !visited[nx][ny]) {
            queue.offer(new Node(nx, ny));
            visited[nx][ny] = true;
          }
        }
      }
    }

    return;
  }

}

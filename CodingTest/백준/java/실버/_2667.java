package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2667 {
  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[][] graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    graph = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] array = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(array[j]);
      }
    }

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 1) {
          result.add(bfs(new Node(i, j), n));
        }
      }
    }
    Collections.sort(result);
    System.out.println(result.size());
    for (int i : result) {
      System.out.println(i);
    }

  }

  public static int bfs(Node node, int m) {

    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    int check = 1;
    while (!queue.isEmpty()) {
      Node q = queue.poll();
      graph[q.x][q.y] = 0;

      for (int i = 0; i < 4; i++) {
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];
        if (nx >= 0 && nx < m && ny < m && ny >= 0) {
          if (graph[nx][ny] == 1) {
            queue.offer(new Node(nx, ny));
            graph[nx][ny] = 0;
            check++;
          }
        }
      }
    }
    return check;
  }
}

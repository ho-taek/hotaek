import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class _등산로조성 {

  static int[][] graph;
  static boolean[][] visited;
  static int max;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { -1, 1, 0, 0 };
  static int k;
  static int n;

  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 1; t <= T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      graph = new int[n][n];
      visited = new boolean[n][n];

      int check = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        StringTokenizer sta = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          graph[i][j] = Integer.parseInt(sta.nextToken());
          if (graph[i][j] > check) {
            check = graph[i][j];
          }
        }
      }
      List<Node> li = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (graph[i][j] == check) {
            li.add(new Node(i, j));
          }
        }
      }

      int result = 0;
      for (Node node : li) {
        max = 0;
        visited[node.x][node.y] = true;
        dfs(1, new Node(node.x, node.y), true);
        if (result < max) {
          result = max;
        }
      }

      System.out.println("#" + t + " " + result);
    }
  }

  public static void dfs(int depth, Node node, boolean flag) {
    if (max < depth) {
      max = depth;
    }
    for (int i = 0; i < 4; i++) {
      int nx = node.x + dx[i];
      int ny = node.y + dy[i];

      if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {

        if (graph[nx][ny] < graph[node.x][node.y]) {
          visited[nx][ny] = true;
          dfs(depth + 1, new Node(nx, ny), flag);

        } else {
          if (flag && ((graph[nx][ny] - k) < graph[node.x][node.y])) {
            visited[nx][ny] = true;
            int tmp = graph[nx][ny];
            graph[nx][ny] = (graph[node.x][node.y] - 1);
            dfs(depth + 1, new Node(nx, ny), false);
            graph[nx][ny] = tmp;
          }
        }

        visited[nx][ny] = false;
      }
    }

  }
}
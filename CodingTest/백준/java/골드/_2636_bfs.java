package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2636_bfs {

  static int lastCount;
  static int time;
  static boolean[][] visited;
  static int[][] graph;

  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];

    for (int i = 0; i < n; i++) {
      StringTokenizer sta = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(sta.nextToken());
      }
    }

    visited = new boolean[n][m];

    boolean flag = true;
    while (flag) {
      time++;
      lastCount = getCount(n, m);
      for (int i = 0; i < n; i++) {
        Arrays.fill(visited[i], false);
      }
      bfs(new Node(0, 0), n, m);

      if (getCount(n, m) == 0) {
        flag = false;
      }
    }

    System.out.println(time);
    System.out.println(lastCount);
  }

  public static void bfs(Node start, int n, int m) {

    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited[start.x][start.y] = true;

    while (!queue.isEmpty()) {
      Node q = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (!visited[nx][ny] && graph[nx][ny] == 1) {
            visited[nx][ny] = true;
            graph[nx][ny] = 2;
          }

          if (!visited[nx][ny] && graph[nx][ny] == 0) {
            visited[nx][ny] = true;
            queue.offer(new Node(nx, ny));
          }
        }
      }
    }
    remove(n, m);
  }

  public static void remove(int n, int m) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j] == 2) {
          graph[i][j] = 0;
        }
      }
    }
  }

  public static int getCount(int n, int m) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j] == 1) {
          count++;
        }
      }
    }
    return count;
  }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class _정사각형방 {

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
      int n = Integer.parseInt(br.readLine());
      int[][] graph = new int[n][n];
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          graph[i][j] = Integer.parseInt(st.nextToken());

        }
      }
      int check = -1;
      int index = Integer.MAX_VALUE;
      for (int a = 0; a < n; a++) {
        for (int b = 0; b < n; b++) {
          boolean[][] visited = new boolean[n][n];
          int tmp = bfs(graph, visited, new Node(a, b), n);
          if (check < tmp) {
            check = tmp;
            index = graph[a][b];
          } else if (check == tmp) {
            if (index > graph[a][b]) {
              index = graph[a][b];
            }
          }
        }
      }
      System.out.println("#" + t + " " + index + " " + check);

    }

  }

  public static int bfs(int[][] graph, boolean[][] visited, Node start, int size) {

    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited[start.x][start.y] = true;
    int result = 1;

    while (!queue.isEmpty()) {
      Node q = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];
        if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
          if (!visited[nx][ny] && ((graph[nx][ny] == (graph[q.x][q.y] + 1)))) {
            queue.offer(new Node(nx, ny));
            visited[nx][ny] = true;
            result += 1;
          }
        }
      }
    }

    return result;

  }
}

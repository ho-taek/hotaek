import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _미로1 {

  static Node start;

  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int t = 1; t <= 10; t++) {
      int n = Integer.parseInt(br.readLine());
      int[][] graph = new int[16][16];
      for (int i = 0; i < 16; i++) {
        String[] tmp = br.readLine().split("");
        for (int j = 0; j < 16; j++) {
          graph[i][j] = Integer.parseInt(tmp[j]);
          if (graph[i][j] == 2) {
            start = new Node(i, j);
          }
        }
      }
      System.out.println("#" + n + " " + (bfs(16, start, graph) ? '1' : '0'));
    }

  }

  static boolean bfs(int size, Node start, int[][] graph) {

    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };
    boolean flag = false;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    graph[start.x][start.y] = 1;

    while (!queue.isEmpty()) {
      Node q = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];

        if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
          if (graph[nx][ny] == 0) {
            queue.offer(new Node(nx, ny));
            graph[nx][ny] = 1;
          } else if (graph[nx][ny] == 3) {
            flag = true;
          }
        }
      }
    }

    return flag;
  }
}

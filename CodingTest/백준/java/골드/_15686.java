package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {
  static int[][] graph;
  static List<Node> chicken;
  static Node[] node;
  static List<Node> house;
  static int result;

  static class Node {
    int x, y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public String toString() {
      return "x " + x + " y " + y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n + 1][n + 1];
    chicken = new ArrayList<>();
    house = new ArrayList<>();
    for (int i = 1; i < (n + 1); i++) {
      StringTokenizer sta = new StringTokenizer(br.readLine());
      for (int j = 1; j < (n + 1); j++) {
        int value = Integer.parseInt(sta.nextToken());
        graph[i][j] = value;
        if (value == 2) {
          chicken.add(new Node(i, j));
        }
        if (value == 1) {
          house.add(new Node(i, j));
        }
      }
    }
    boolean[] visited = new boolean[chicken.size()];
    node = new Node[m];
    result = Integer.MAX_VALUE;
    comb(visited, 0, chicken.size(), m);

    System.out.println(result);
  }

  public static void comb(boolean[] visited, int start, int n, int r) {
    if (r == 0) {
      int yo = 0;
      for (Node nd : house) {
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
          if (visited[i]) {
            Node ch = chicken.get(i);
            int calc = Math.abs(nd.x - ch.x) + Math.abs(nd.y - ch.y);
            if (tmp > calc) {
              tmp = calc;
            }
          }
        }
        yo += tmp;
      }
      if (result > yo) {
        result = yo;
      }

      return;
    }

    for (int i = start; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        comb(visited, i + 1, n, r - 1);
        visited[i] = false;
      }
    }
  }
}

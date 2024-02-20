import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class _중위순회 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= 10; t++) {
      int n = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();

      String[][] tree = new String[n + 1][4];
      for (int i = 1; i < n + 1; i++) {
        tree[i] = br.readLine().split(" ");
      }
      System.out.println("#" + t + " " + inorder(tree, tree[1][0], sb));
    }

  }

  public static StringBuilder inorder(String[][] graph, String node, StringBuilder sb) {
    int index = Integer.parseInt(node);
    if (graph[index].length == 2) {
      return sb.append(graph[index][1]);
    }

    if (graph[index].length >= 3) {
      inorder(graph, graph[index][2], sb);
    }
    sb.append(graph[index][1]);
    if (graph[index].length == 4) {
      inorder(graph, graph[index][3], sb);
    }
    return sb;
  }
}

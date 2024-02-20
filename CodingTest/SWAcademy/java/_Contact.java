import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _Contact {
  static int[] visited;
  static List<List<Integer>> result;
  static int max = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= 10; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      List<List<Integer>> graph = new ArrayList<>();
      List<List<Integer>> reverse = new ArrayList<>();

      StringTokenizer sta = new StringTokenizer(br.readLine());
      for (int i = 0; i <= 100; i++) {
        graph.add(new ArrayList<>());
        reverse.add(new ArrayList<>());
      }

      for (int i = 0; i < (n / 2); i++) {
        int a = Integer.parseInt(sta.nextToken());
        int b = Integer.parseInt(sta.nextToken());
        graph.get(a).add(b);
        reverse.get(b).add(a);
      }

      visited = new int[101];
      result = new ArrayList<>();

      for (int i = 0; i <= 100; i++) {
        result.add(new ArrayList<>());
      }

      Queue<Integer> queue = new LinkedList<>();
      int max = 0;
      queue.offer(m);
      visited[m] = 1;
      while (!queue.isEmpty()) {
        int q = queue.poll();

        for (int i : graph.get(q)) {
          if (visited[i] == 0) {
            queue.offer(i);
            for (int j : reverse.get(i)) {
              if (j == q) {
                if (max < visited[q] + 1) {
                  max = visited[q] + 1;
                }
                visited[i] = visited[q] + 1;
                result.get(visited[i]).add(i);
              }
            }
          }
        }
      }
      int answer = 0;
      for (int s : result.get(max)) {
        if (answer < s) {
          answer = s;
        }
      }

      System.out.println("#" + t + " " + answer);

    }
  }

}

// 2 7 11 6 6 2 2 15 15 4 4 2 4 10 7 1 1 7 1 8 1 17 3 22
// 1 17 3 22 1 8 1 7 7 1 2 7 2 15 15 4 6 2 11 6 4 10 4 2
// 1 17 1 17 1 17 3 22 1 8 1 7 7 1 2 7 2 15 15 4 6 2 11 6 4 10 11 6 4 2
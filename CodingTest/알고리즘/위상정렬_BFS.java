package 알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 위상정렬_BFS {
  static int[] indegree;

  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int t = 1; t <= 10; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      // 결과
      List<Integer> result = new ArrayList<>();

      // 그래프 표현
      List<List<Integer>> graph = new ArrayList<>();
      for (int i = 0; i <= v; i++) {
        graph.add(new ArrayList<>());
      }

      // indegree
      int[] indegree = new int[v + 1];

      StringTokenizer sta = new StringTokenizer(br.readLine());
      for (int i = 0; i < e; i++) {
        int a = Integer.parseInt(sta.nextToken());
        int b = Integer.parseInt(sta.nextToken());
        graph.get(a).add(b);
        indegree[b]++;
      }

      // 큐
      Queue<Integer> queue = new LinkedList<>();

      // 초기 진입차수 0인 경우
      for (int i = 1; i <= v; i++) {
        if (indegree[i] == 0) {
          queue.offer(i);
        }
      }
      while (!queue.isEmpty()) {

        int p = queue.poll();
        result.add(p);
        for (int c : graph.get(p)) {
          indegree[c] -= 1;
          if (indegree[c] == 0) {

            queue.offer(c);
          }
        }
      }

      StringBuilder sb = new StringBuilder();

      for (int i : result) {
        sb.append(i).append(" ");
      }

      System.out.println("#" + t + " " + sb);
    }
  }

}

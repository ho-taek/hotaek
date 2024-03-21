import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _창용마을무리의개수 {
  static boolean[] visited;
  static List<List<Integer>> graph;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int t = 1; t <= T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      //그래프 및 기초 세팅
      graph = new ArrayList<>();
      visited = new boolean[n+1];
      for(int i =0; i <(n+1); i++){
        graph.add(new ArrayList<>());
      }
      for(int i =0; i < m; i++){
        StringTokenizer stg = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stg.nextToken());
        int b = Integer.parseInt(stg.nextToken());
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      int result = 0;

      for(int i=1; i< n+1; i++){
        if(!visited[i]){
          result ++;
          bfs(i);
        }
      }
      System.out.println("#"+t+" "+result);
    }
  }

  public static void bfs(int start){
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while(!queue.isEmpty()){
      Integer q = queue.poll();

      for(int i : graph.get(q)){
        if(!visited[i]){
          visited[i] = true;
          queue.offer(i);
        }
      }


    }

  }


}

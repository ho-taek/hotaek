package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _최적경로 {
  
  static class Node{
    int x,y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  static Node[] graph;
  static Node home;
  static int result;
  static int n;
  static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <= T; t++){
      n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      //회사, 집
      Node cp = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      //그래프
      graph = new Node[n+1];
      graph[0] = cp;
      for(int i = 1; i<= n; i++){
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph[i] = new Node(x,y);
      }
      visited = new boolean[n+1];
      result = Integer.MAX_VALUE;
      dfs(visited,0, 0, cp);

      System.out.println("#"+t+" "+result);
    }
  }
  public static void dfs(boolean[] visited, int depth, int tmp, Node node ){
    if(depth == n){
      tmp += cal(node.x,node.y, home.x, home.y);
      if(tmp < result){
        result = tmp;
      }
      return;
    }

    for(int i =1; i <= n; i++ ){
      if(!visited[i]){
        int check = tmp +  cal(node.x, node.y, graph[i].x, graph[i].y);
        if(check < result){
          visited[i] = true;
          dfs(visited, depth+1,check, graph[i]);
          visited[i] = false;
        }
      }
    }
  }

  public static int cal(int x, int y, int nx, int ny){
    return Math.abs(x-nx)+ Math.abs(y-ny);
  }
}

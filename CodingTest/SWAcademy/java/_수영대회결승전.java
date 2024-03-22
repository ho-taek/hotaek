package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _수영대회결승전 {
  static int[][] graph;
  static int[][] visited;
  static int n;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};
  static class Node{
    int x,y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <= T ; t++){
      n = Integer.parseInt(br.readLine());
      
      //그래프생성
      graph = new int[n][n];
      visited = new int[n][n];
      for(int i =0; i < n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j < n; j++){
          int value = Integer.parseInt(st.nextToken());
          graph[i][j] = value;
        }
      }
      String[] sts = br.readLine().split(" ");
      Node start = new Node(Integer.parseInt(sts[0]), Integer.parseInt(sts[1]));
      String[] ste = br.readLine().split(" ");

      bfs(start);
      int ex = Integer.parseInt(ste[0]);
      int ee = Integer.parseInt(ste[1]);
      int result = (visited[ex][ee] == 0) ? 0 : visited[ex][ee];
      System.out.println("#"+t+" "+(result-1));
    
    }
  }

  public static void bfs(Node start){
    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited[start.x][start.y] = 1;


    while(!queue.isEmpty()){

      Node q = queue.poll();
      for(int i =0; i < 4; i++){
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];

        if(check(nx,ny)) continue;

        if(graph[nx][ny] == 1) continue;

        int dist = 0;

        if(graph[nx][ny] == 2){
          dist = visited[q.x][q.y] + (3-(visited[q.x][q.y]%3))%3+1;
        }else{
          dist = visited[q.x][q.y] + 1;
        }


        if(visited[nx][ny] != 0){
          if(visited[nx][ny] > dist){
            visited[nx][ny] = dist;
            queue.offer(new Node(nx,ny));
          }
          continue;
        }
        visited[nx][ny] = dist;
        queue.offer(new Node(nx,ny));
      }
    }
    
  }

  public static boolean check(int nx, int ny){
    return nx < 0 || nx >= n || ny < 0 || ny >= n;
  }
}

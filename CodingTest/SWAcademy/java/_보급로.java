package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class _보급로 {
  
  static int[][] graph;
  static int[][] visited;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};
  static int n;
  public static class Node{
    int x,y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t= 1; t <= T; t++){
      n = Integer.parseInt(br.readLine());

      graph = new int[n][n];
      visited = new int[n][n];
      for(int i = 0; i < n; i++){
        int[] array = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        graph[i] = array;
      }

      bfs(new Node(0,0));

      System.out.println("#"+t+" "+(visited[n-1][n-1]-1));
    }
  }

  public static void bfs(Node start){
    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited[start.x][start.y] = 1;

    while(!queue.isEmpty()){
      Node q = queue.poll();

      for(int i=0; i <4;i++){
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];

        if(check(nx,ny)) continue;

        int dist = visited[q.x][q.y] + graph[nx][ny];
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

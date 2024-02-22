package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class _2573 {
  static int[][] graph;
  static boolean[][] visited;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};
  static int time = 0;
  static class Node{
    int x, y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      StringTokenizer sta = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(sta.nextToken());
      }
    }
    boolean flag = true;
    while(flag){
      int answer = 0;
      time++;
      for(int i =0; i < n ; i++){
        Arrays.fill(visited[i], false);
      }
      for(int i=0; i < n; i++){
        for(int j=0; j < m; j++){
          if(!visited[i][j] && graph[i][j] == 0){
            bfs(new Node(i,j),n,m);
            answer ++;
          }
        }
      }
      for(int i=0; i < n; i++){
        System.out.println(Arrays.toString(graph[i]));
      }
      change(n,m);
      if(getCount(n, m) == n*m){
        flag = false;
        break;
      }
      if(answer >= 2){
        flag = false;
        break;
      }

    }
    System.out.println(time);
  }

  public static void bfs(Node start, int n, int m){
    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited[start.x][start.y] = true;

    while(!queue.isEmpty()){
      Node q = queue.poll();
      for(int i=0; i < 4; i ++){
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];
        System.out.println("확인");
        if(nx>=0 && nx < n && ny >= 0 && ny < m){
          if(graph[nx][ny] >0){
            graph[nx][ny] -= 1;
            if(graph[nx][ny] <= 0){
              graph[nx][ny] = -1;
            }
          }else if(graph[nx][ny] == 0 && !visited[nx][ny]){
            queue.offer(new Node(nx,ny));
            visited[nx][ny] = true;
          }
        }
      }
    }
  }

  //0갯수 세기
  public static int getCount(int n, int m){
    int count =0;
    for(int i=0; i < n ; i++){
      for(int j=0; j < m; j ++){
        if(graph[i][j] == 0){
          count ++;
        }
      }
    }
    return count;
  }

  //-1 -> 0으로 변환
  public static void change(int n, int m){
    for(int i = 0 ; i < n; i++){
      for(int j=0; j < m; j++){
        if(graph[i][j] == -1){
          graph[i][j] = 0;
        }
      }
    }
  }
}

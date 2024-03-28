import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _홈방법서비스 {
  static int[][] graph;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};
  static int n;
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

    for(int t =1 ; t <= T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
  
      //그래프 및 집 리스트 넣기
      graph = new int[n][n];
      List<Node> node = new ArrayList<>();
      for(int i = 0; i < n; i++){
        StringTokenizer stg = new StringTokenizer(br.readLine());
        for(int j = 0; j < n;j ++){
          int value = Integer.parseInt(stg.nextToken());
          graph[i][j] = value;
          if(value == 1){
            node.add(new Node(i,j));
          }
        }
      }
      int result = 1;
      for(int k=n+1; k >=2; k--){
        if(calcM(k) - (node.size()*m) > 0) continue;
        for(int i = 0; i < n; i++){
          for(int j = 0; j <n; j++){
            int tmp = bfs(new Node(i,j), k);
            if(calcM(k) - (tmp*m) > 0) continue;
            
            if(result < tmp){
              result = tmp;
            }
          }
        }
      }
      System.out.println("#"+t+" "+result);
    }
  }

  public static int bfs(Node start, int k){
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(start.x, start.y));
    int[][] visited = new int[n][n];
    visited[start.x][start.y] = 1;
    int house = 0;

    if(graph[start.x][start.y] == 1){
      house ++;
    }
    while(!queue.isEmpty()){
      Node q = queue.poll();
      for(int i=0; i < 4; i++){
        int nx = q.x+dx[i];
        int ny = q.y+dy[i];

        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

        if(visited[q.x][q.y]+1 > k) continue;

        if(visited[nx][ny] == 0){
          if(graph[nx][ny] == 1){
          house ++;
          }
          queue.add(new Node(nx,ny));
          visited[nx][ny] = visited[q.x][q.y] +1;
        }


      }
    }
    return house;
  }

  public static int calcM(int k){
    return k*k+(k-1)*(k-1);
  }
}

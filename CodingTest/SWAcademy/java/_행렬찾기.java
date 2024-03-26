import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _행렬찾기 {
  static int[][] graph;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};
  static boolean[][] visited;
  static class Node implements Comparable<Node>{ 
    int x,y, size;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }

    public Node(int x, int y, int size){
      this.x = x;
      this.y = y;
      this.size = size;
    }
    @Override
    public int compareTo(Node o) {
      if(this.size == o.size){
        return this.x - o.x;
      }
      return this.size - o.size;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int t=1; t <=T; t++){
      int n = Integer.parseInt(br.readLine());
      graph = new int[n][n];
      visited = new boolean[n][n];
      for(int i=0; i < n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0;j < n; j++){
          graph[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      PriorityQueue<Node> pq = new PriorityQueue<>();
      for(int i=0; i < n; i++){
        for(int j=0; j < n; j++){
          if(graph[i][j] != 0 && !visited[i][j]){
            Node node = bfs(new Node(i,j), n);
            pq.offer(node);
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      sb.append(pq.size());
      int pqSize = pq.size();
      for(int i=0 ; i < pqSize; i++){
        Node node = pq.poll();
        sb.append(" "+ node.x);
        sb.append(" "+ node.y);
      }

      System.out.println("#"+t+" "+sb);
    }
  }

  public static Node bfs(Node start, int n){
    Queue<Node> queue = new LinkedList<>();
    queue.offer(start);
    visited[start.x][start.y] = true;

    int endX = 0;
    int endY = 0;
    while(!queue.isEmpty()){
      Node q = queue.poll();

      for(int i=0; i < 4;i ++){
        int nx = q.x + dx[i];
        int ny = q.y + dy[i];

        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

        if(!visited[nx][ny] && graph[nx][ny] != 0){
          visited[nx][ny] = true;
          if(nx > endX){
            endX = nx;
          }
          if(ny > endY){
            endY = ny;
          }
          queue.offer(new Node(nx,ny));
        }
      }
    }    
    int value = (endX-start.x+1) * (endY-start.y+1);
   return new Node(endX-start.x+1, endY-start.y+1, value);
  }
}

package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1197 {
  static int[] parent;

  static class Edge implements Comparable<Edge>{
    int x, y, weight;

    public Edge(int x, int y, int weight){
      this.x = x;
      this.y = y;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    parent = new int[n+1];
    for(int i=1; i <= n; i++){
      parent[i] = i;
    }
    for(int i = 0; i < m; i++){
      StringTokenizer stg = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stg.nextToken());
      int b = Integer.parseInt(stg.nextToken());
      int c = Integer.parseInt(stg.nextToken());
      pq.offer(new Edge(a, b, c));
    }

    int weight = 0;
    while(!pq.isEmpty()){
      Edge e = pq.poll();
      if(find(e.x) != find(e.y)){
        union(e.x, e.y);
        weight += e.weight;
      }
    }
    System.out.println(weight);
    
  }

  public static void union(int x, int y){
    x = find(x);
    y = find(y);

    if(x < y)
    parent[y] = x;
    else
    parent[x] = y;
  }

  public static int find(int x){

    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class _하나로 {
  static int[] parent;
  static class Edge implements Comparable<Edge>{
    int from,to;
    double weight;

    public Edge(int from, int to, double weight){
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o){
      return  Double.compare(this.weight, o.weight);
    }

  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int t =1; t <= T; t++){
      
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Edge> pq = new PriorityQueue<>();
      parent = new int[n];
      for(int i=0; i < n; i++){
        parent[i] = i;
      }
      String[] x = br.readLine().split(" ");
      String[] y = br.readLine().split(" ");

      double e = Double.parseDouble(br.readLine());

      for(int i= 0; i < n-1; i++){
        for(int j = i+1; j < n; j++){
          pq.offer(new Edge(i, j, calWeight(Integer.parseInt(x[i]), Integer.parseInt(y[i]), Integer.parseInt(x[j]), Integer.parseInt(y[j]), e)));
        }
      }
      double weight = 0;
      while(!pq.isEmpty()){
        Edge cur = pq.poll(); 
        if(find(cur.from) != find(cur.to)){
          union(cur.from,  cur.to);
          weight += cur.weight;
        }
  
      }

      System.out.println("#"+t+" "+Math.round(weight));
    }

  



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

  public static double calWeight(double x, double y, double nx, double ny, double e){
      return ((Math.pow(Math.abs(x-nx),2)+Math.pow(Math.abs(y-ny), 2))*e) ;
  }
}

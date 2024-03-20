package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _동철이의일분배 {
  static double result;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <= T; t++){
      int n = Integer.parseInt(br.readLine());
      double[][] graph = new double[n][n];

      //그래프
      for(int i =0; i < n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j < n; j++){
          graph[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      //결과값
      result = Integer.MIN_VALUE;
      boolean[] visited = new boolean[n];
      dfs(0,n,graph, visited, 1.0);
      String results = String.format("%.6f",result*100);
      System.out.println("#"+t+" "+results);
    }
  }
  public static void dfs(int depth, int n, double[][] array, boolean[] visited, double tmp){
    if(depth == n){
      if(result < tmp){
        result = tmp;
      }
      return;
    }
    for(int i=0; i < n; i++){
      if(!visited[i]){
        double check = tmp * (array[depth][i]/100.0);
        if(check > result){
          visited[i] = true;
          dfs(depth+1, n, array, visited, tmp * (array[depth][i]/100.0));
          visited[i] = false;
        }
      }
    }
  }

  
}

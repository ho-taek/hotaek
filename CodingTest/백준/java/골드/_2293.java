package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2293 {
  static int[] graph;
  static int n;
  static int k;
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    graph = new int[n];

    for(int i=0; i <n; i++){
      graph[i] = Integer.parseInt(br.readLine());
    }

    int[][] dp = new int[n+1][k+1];
    
    for(int i = 1 ; i < n+1; i++){
      for(int j = 0; j < k+1; j++){
        //0일 경우
        if(j == 0){
          dp[i][j] = 1;
          continue;
        }
        //graph보다 j가 작을경우
        if(graph[i-1] > j){
          dp[i][j] = dp[i-1][j];
        }else{
          dp[i][j] = dp[i][j-graph[i-1]]+dp[i-1][j];
        }
      }
    }
    for(int i = 0 ; i< n+1; i++){
      System.out.println(Arrays.toString(dp[i]));
    }

    System.out.println(dp[n][k]);

  }

}

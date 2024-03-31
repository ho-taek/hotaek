package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    int[] arr = new int[n];
    dfs(0,arr);
 
    System.out.println();

  }

  public static void dfs(int count, int[] arr){

  }
}

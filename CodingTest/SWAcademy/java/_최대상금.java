package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class _최대상금 {
  static int size;
  static boolean[] visited;
  static String[] coin;
  static int n;
  static ArrayList<int[]> list;
  static int result;
  static int[] array;
  static int max;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t=1; t <= T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      coin = st.nextToken().split("");
      size = coin.length;
      
      n = Integer.parseInt(st.nextToken());
      result = Integer.MIN_VALUE;
      visited = new boolean[size];
      //조합
      list = new ArrayList<>();

      array = new int[2];
      comb(0,2);
      // for(int[] i : list){
      //   System.out.println(Arrays.toString(i));
      // }
      boolean [] perVisited = new boolean[list.size()];
      permIndex(coin,0, n, perVisited);

      System.out.println("#"+t+" "+result);
    }
  }

  public static void comb(int start, int r){
    if(r == 0){
      int [] test = array.clone();
      list.add(test);
      return;
    }
    for(int i = start; i < size; i ++){
      if(!visited[i]){
        visited[i] = true;
        array[r-1] = i;
        comb(i+1, r-1);
        visited[i] = false;
      }
    }
  }

  public static void permIndex(String[] coin, int start, int r, boolean[] permVisited){
    if(r == 0){
      int[] c = Stream.of(coin.clone()).mapToInt(Integer::parseInt).toArray();

      for(int i=0 ; i < permVisited.length; i++){
        if(permVisited[i]){
          int mid = c[list.get(i)[0]];
          c[list.get(i)[0]] = c[list.get(i)[1]];
          c[list.get(i)[1]] = mid;
        }
      }
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < size; i++){
        sb.append(c[i]);
      }
      int asset = Integer.parseInt(String.valueOf(sb));
      // System.out.println(Arrays.toString(permVisited));
      // System.out.println(asset);
      if(result < asset){
        result = asset;
      }
      return;
    }

    for(int i=start; i < list.size(); i ++){
        permVisited[i] = true;
        permIndex(coin, start+1, r-1, permVisited);
        permVisited[i] = false;
    }
  }



}

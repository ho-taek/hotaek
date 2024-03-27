import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _벌꿀채취 {
  static int[][] graph;
  static boolean[] visited;
  static List<int[]> li;
  static int m;
  static int c;
  static int result;
  static int first;
  static int second;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int t=1; t <=T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());

      //그래프 넣기
      graph = new int[n][n];      
      for(int i = 0 ; i < n ; i++){
        StringTokenizer stg = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < n ; j++){
          graph[i][j] = Integer.parseInt(stg.nextToken());
        }
      }
      
      //가능한 경우의 수
      li = new ArrayList<>();
      for(int i = 0; i < n ; i++){

        for(int j = 0; j < n; j++){
          int[] array = new int[2];
          if(j + m-1 >= n){
            break;
          }
          array[0] = i;
          array[1] = j;
          li.add(array);
        }
      }
      result = Integer.MIN_VALUE;

      visited = new boolean[li.size()];
      comb(0,2, li.size(),-1);

      System.out.println("#"+t+" "+result);
    }
  }

  public static void comb (int start, int r, int si, int y){
    if(r == 0){
      int s = -1;
      int e = -1;
      boolean flag = false;
      for(int i = 0 ; i < li.size(); i++){
        if(visited[i]){
          if(!flag){
            s = i;
          }else{
            e = i;
            break;
          }
          flag = true;
        }
      }
      calc(s,e);
      return;
    }

    for(int i = start ; i < si ; i++ ){
      if(visited[i]) continue;
      if(y != -1 && (li.get(y)[0] == li.get(i)[0]) && li.get(i)[1] < li.get(y)[1] + m) continue;

      visited[i] = true;
      comb(start+1, r-1, si, i);
      visited[i] = false;
  
    }
  }

  //result 값
  public static void calc(int start, int end){
    int[] sArray = new int[m];
    int[] eArray = new int[m];
    int sIndex = 0;
    for(int i = 0; i < m; i++){
      int sx = li.get(start)[0];
      int sy = li.get(start)[1]+i;
      int ex = li.get(end)[0];
      int ey = li.get(end)[1]+i;
      sArray[sIndex] = graph[sx][sy];
      eArray[sIndex] = graph[ex][ey];
      sIndex ++;
    }
    
    boolean[] visited = new boolean[m];
    first = -1;
    second = -1;
    powerSet(visited, 0, sArray , true);
    powerSet(visited, 0, eArray, false);
    if(result < (first+second)){
      result = (first+second);
    }
    return;
  }

  //두 배열 값들 중 최대값 구하기
  public static void powerSet(boolean[] visited, int idx, int[] array, boolean flag){
    if(idx == m){
      List<Integer> ch = new ArrayList<>();
      int tmp = 0;
      for(int i = 0; i < visited.length; i++){
        if(visited[i]){
          tmp += array[i];
          ch.add(array[i]);
        }
      }
      if(tmp <= c){

        int check = 0;
        for(int i : ch){
          check += Math.pow(i, 2);
        }
        if(flag){
          if(first < check){
            first = check;
          }
        }else{
          if(second < check){
            second = check;
          }
        }
      }
      return;
    }

    visited[idx] = true;
    powerSet(visited, idx+1, array,flag);
    visited[idx] = false;
    powerSet(visited, idx+1, array,flag);
  }



}

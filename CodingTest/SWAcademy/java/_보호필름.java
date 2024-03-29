import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class _보호필름 {
  static int[][] graph;
  static int d;
  static int w;
  static int k;
  static boolean flag;
  static List<Integer> changeList;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    int T = Integer.parseInt(br.readLine());
    for(int t = 1; t <=T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
 
      //d -> x , w -> y, k -> 연속합격
      d = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
       
      graph = new int[d][w];
 
      for(int i = 0; i <d;i++){
        StringTokenizer stg= new StringTokenizer(br.readLine());
        for(int j = 0; j <w;j++){
          graph[i][j] = Integer.parseInt(stg.nextToken());
        }
      }
      //바꾼 graph가 가능한지 확인
      flag = false;
      boolean[] visited = new boolean[d];
      for(int i =0; i <= d; i++){
        if(i==0){
          check(graph);
        }else{
          comb(0,visited, i);
        }
 
        if(flag){
          System.out.println("#"+t+" "+i);
          break;
        }
      }
 
    }
  }
 
 
  public static void comb(int start, boolean[] visited, int r){
    if(flag){
      return;
    }
 
    if(r == 0){
      changeList = new ArrayList<>();
      //바꿀 수 있는 x 넣기
      for(int i =0; i < d; i++){
        if(visited[i]){
          changeList.add(i);
        }
      }
      boolean[] changeVisited = new boolean[changeList.size()];
      combTwo(0, changeVisited);
 
      return;
    }
 
    if(start == d){
      return;
    }
 
    for(int i = start; i <d; i++){
      if(!visited[i]){
        visited[i] = true;
        comb(i+1, visited, r-1);
        visited[i] = false;
      }
    }
  }
  //연속된 k 확인하는 함수
  public static void check(int[][] graph){
    for(int i =0; i < w; i++){
      boolean calFlag = false;
      int tmp = 1;
      for(int j =1; j < d;j ++){
        if(graph[j][i] == graph[j-1][i]){
          tmp ++;
        }else{
          tmp = 1;
        }
        if(tmp >= k){
          calFlag = true;
          break;
        }
         
      }
      if(!calFlag){
        flag = false;
        return ;
      }
    }
    flag = true;
    return ;
  }
 
  public static void combTwo(int start, boolean[] output){
    if(flag){
      return;
    }
   if(start == output.length){
      int[][] graphCopy = new int[d][w];
     for(int i = 0; i <d;i++){
        graphCopy[i] = graph[i].clone();
     }
     int index = 0;
     for(int i : changeList){
      if(output[index]){
        Arrays.fill(graphCopy[i], 1);
      }else{
        Arrays.fill(graphCopy[i], 0);
      }
      index ++;
    }
      check(graphCopy);
      return;
    }
      output[start] = true;
      combTwo(start+1, output);
      output[start] = false;
      combTwo(start+1, output);
  }
}
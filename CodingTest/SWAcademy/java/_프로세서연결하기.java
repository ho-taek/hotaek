import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _프로세서연결하기 {
  static int[][] graph;
  static List<int[]> des;
  static int size;
  static int n;
  static int maxCore;
  static int result;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <=T; t++){
      n = Integer.parseInt(br.readLine());

      //그래프 및 1의 개수, 좌표 값 저장
      graph = new int[n][n];
      size = 0;
      des = new ArrayList<>();
      for(int i = 0; i < n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j =0; j < n; j++){
          int value = Integer.parseInt(st.nextToken());
          if(value == 1 && i != 0 && i != (n-1) && j != 0 && j != (n-1)){
            size ++;
          }

          if((i==0 || i == (n-1) || j == 0 || j == (n-1)) && value != 1){
            isDest(i, j);
          }
          graph[i][j] = value;
        }
      }

      for(int[] i : des){
        System.out.println(Arrays.toString(i));
      }
      
      //인덱스 저장값
      int[] index = new int[des.size()];
      for(int i = 0; i < des.size(); i++){
        index[i] = i;
      }

      maxCore = Integer.MIN_VALUE;
      result = Integer.MAX_VALUE;

      //방문
      boolean[] visited = new boolean[des.size()];
      comb(0, visited, size);
      // System.out.println(des);
      System.out.println("#"+t+" "+result);
    }
  }

  public static void comb(int start, boolean[] visited, int r){
    if(r == 0){
      boolean[][] checkVisit = new boolean[n][n];
      int count = 0;
      int maxTmp = 0;
      // System.out.println(Arrays.toString(visited));
      for(int i = 0 ; i< des.size(); i++){
        if(visited[i]){
          int[] tmp = des.get(i);
          int nx = tmp[0];
          int ny = tmp[1];
          int dist = tmp[2];
          // System.out.println("nx "+nx +" ny "+ ny+" dist "+dist);
          // 0 -> 하, 1 -> 상, 2 -> 좌, 3 -> 우
          while(true){
            if(nx < 0 || nx >= n || ny < 0 || ny >= n){
              break;
            }
            if(checkVisit[nx][ny]) break;

            checkVisit[nx][ny] = true;

            if(graph[nx][ny] == 1){
              maxTmp++;
              break;
            }

            if(dist == 0){
              nx ++;
              count ++; 
            }
            
            if(dist == 1){
              nx --;
              count ++;
            }
            if(dist == 2){
              ny --;
              count ++;
            }
            if(dist == 3){
              ny ++;
              count ++;
            }
          }  
        }
      }
      if(maxTmp >= maxCore){
        maxCore = maxTmp;
        if(count < result){
          System.out.println("요르 " + maxCore + "   "+count);
          result = count;
        }
        
      }
      return;
    }

    for(int i = start ; i < des.size() ; i++){
      if(!visited[i]){
        visited[i] = true;
        comb(start+1, visited, r-1);
        visited[i] = false;
      }
    }
  }

  public static void isDest(int x, int y){
    if(x == 0){
      des.add(new int[] {x,y,0});
    }
    if(y == 0){
      des.add(new int[] {x,y,3});
    }
    if(x == (n-1)){
      des.add(new int[] {x,y,1});
    }
    if(y == (n-1)){
      des.add(new int[] {x,y,2});
    }
  }
}

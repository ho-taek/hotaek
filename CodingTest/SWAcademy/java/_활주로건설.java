import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _활주로건설 {

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for(int t = 1; t <= T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      
      int[][] graph = new int[n][n];
      boolean[][] rVisited = new boolean[n][n];
      boolean[][] cVisited = new boolean[n][n];
      for(int i=0; i < n; i++){
        StringTokenizer stg= new StringTokenizer(br.readLine());
        for(int j=0; j < n; j++){
          graph[i][j] = Integer.parseInt(stg.nextToken());
        }
      }
  
      int result = 0;
  
      for(int i =0; i < n; i++){
        boolean row = true;
        boolean col = true;
        for(int j =0; j <(n-1); j++){
          //가로
          if((graph[i][j] - graph[i][j+1]) == -1){
            for(int k = 0; k < x; k++){
              int tmp =j-k;
              if(tmp < 0){
                row = false;
                break;
              }
              if(rVisited[i][tmp]){
                row = false;
                break;
              }
              if(graph[i][tmp] - graph[i][j+1] != -1){
                row = false;
                break;
              }
              rVisited[i][tmp] = true;
            }
          }else if(graph[i][j] - graph[i][j+1] == 1){
            for(int k = 1; k <= x; k++){
              int tmp = j+k;
              if(tmp >= n){
                row = false;
                break;
              }
              if(rVisited[i][tmp]){
                row = false;
                break;
              }
              if(graph[i][j] - graph[i][tmp] != 1){
                row = false;
                break;
              }
              rVisited[i][tmp] = true;
            }
          }else if(graph[i][j] - graph[i][j+1] > 1){
            row = false;
          }else if(graph[i][j] - graph[i][j+1] < -1){
            row = false;
          }

          

          //세로
          if(graph[j][i] - graph[j+1][i] == -1){
            for(int k = 0; k < x; k++){
              int tmp = j-k;
              if(tmp < 0){
                col = false;
                break;
              }
              if(cVisited[tmp][i]){
                col = false;
                break;
              }
              if(graph[tmp][i] - graph[j+1][i] != -1){
                col = false;
                break;
              }
              cVisited[tmp][i] = true;
            }
          }else if(graph[j][i] - graph[j+1][i] == 1){
            for(int k = 1; k <= x; k++){
              int tmp = j+k;
              if(tmp >= n){
                col = false;
                break;
              }
              if(cVisited[tmp][i]){
                col = false;
                break;
              }
              if(graph[j][i] - graph[tmp][i] != 1){
                col = false;
                break;
              }
              cVisited[tmp][i] = true;
            }
          }else if(graph[j][i] - graph[j+1][i] > 1){
            col = false;
          }else if(graph[j][i] - graph[j+1][i] < -1){
            col = false;
          }
        }

        if(row){
          result ++;
        } 
        if(col) {
          result ++;
       }
    }

      System.out.println("#"+t+" "+result);
    }

  }
}

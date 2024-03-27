import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _사람네트워크2 {
  static int[][] graph;
  static final int INF = 1000000000;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <= T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      graph = new int[n][n];

      for(int i=0; i <n; i++){
        Arrays.fill(graph[i], INF);
      }
      int row = 0;
      for(int i=0; i< n; i++){
        int col = 0;
        for(int j =0; j < n; j++){
          int value = Integer.parseInt(st.nextToken());
          if(i!=j && value == 0){
            value = INF;
          }
          graph[row][col] = value;
          col ++;
        }
        row ++;
      }

      for(int a = 0; a < n; a++){
        for(int b = 0; b < n; b++){
          for(int c = 0 ; c < n ; c++){
            if(b==c) continue;
            graph[b][c] = Math.min(graph[b][c], graph[b][a] + graph[a][c]);
          }
        }
      }
      int result = Integer.MAX_VALUE;
      for(int i =0; i < n; i++){
        int tmp = 0;
        for(int j =0; j <n; j++){
          tmp += graph[i][j];
        }
        if(result > tmp){
          result = tmp;
        }
      }
      System.out.println("#"+t+" "+result);
    }

  }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _요리사 {
  static int[][] graph;
  static boolean[] visited;
  static int result;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for(int t=1; t <= T ; t++){
      int n = Integer.parseInt(br.readLine());

      graph = new int[n][n];
      for(int i=0; i < n;i ++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j < n; j ++){
          graph[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      visited = new boolean[n];
      result = Integer.MAX_VALUE;

      comb(0, n/2, n);
      System.out.println("#"+t+" "+ result);
    }
  }

  public static void comb(int start, int r, int n){
    if(start == n){
      return;
    }
    if(r == 0){
      // System.out.println(Arrays.toString(visited));
      int[] arrayF = new int[n/2];
      int[] arrayT = new int[n/2];
      int fIndex = 0;
      int tIndex = 0;
      for(int i=0; i < n; i++){
        if(visited[i]){
          arrayF[fIndex] = i;
          fIndex++;
        }else{
          arrayT[tIndex] = i;
          tIndex++;
        }
      }
      int answer = calc(arrayF, arrayT);
      if(result > answer){
        result = answer;
      }
      return;
    }

        visited[start] = true;
        comb(start+1, r-1, n);
        visited[start] = false;
        comb(start+1, r, n);
      

      }



  public static int calc(int[] arrayF, int[] arrayT){
    int f = 0;
    int t = 0;
    for(int i = 0; i < arrayF.length-1; i++){
      for(int j = i+1; j < arrayF.length; j++ ){
        f += (graph[arrayF[i]][arrayF[j]] + graph[arrayF[j]][arrayF[i]]);
        t += (graph[arrayT[i]][arrayT[j]] + graph[arrayT[j]][arrayT[i]]);
      }
    }
    return Math.abs(f-t);
  }

}

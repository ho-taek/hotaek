import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _금속막대 {
  
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
   
    for(int t = 1; t <= T ; t++){

      int n = Integer.parseInt(br.readLine());
      int[][] array = new int[n][2];

      HashMap<Integer, Integer> xMap = new HashMap<>();
      HashMap<Integer, Integer> yMap = new HashMap<>();

      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i <n; i++){
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        array[i][0] = x;
        array[i][1] = y;
        xMap.put(x, i);
        yMap.put(y, i);
      }
      //start과 끝 구하기
      int start = -1;
      for(int i : xMap.keySet()){
        if(yMap.get(i) == null){
          start = i;
        }
      }

      StringBuilder sb = new StringBuilder();
      for(int i=0; i < n; i++){
        if(xMap.get(start) != null){
          sb.append(" "+array[xMap.get(start)][0]);
          sb.append(" "+array[xMap.get(start)][1]);
          start = array[xMap.get(start)][1];
          System.out.println(start);
        }
      }
      System.out.println("#"+t+sb);

    }

  }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _단순이진암호코드 {
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> cal = Arrays.asList("0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011","0110111","0001011");
    

    int T = Integer.parseInt(br.readLine());

    for(int t = 1; t <= T ; t++){
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      String[][] array = new String[n][m];

      for(int i =0; i < n; i ++){
        array[i] = br.readLine().split("");
      }
      int result = 0;
      //그래프 값


      for(int i =0; i < n; i++){
        boolean flag = false;
        int index = 0;
        Deque<Integer> list = new LinkedList<>();
        
        for(int j = m-1 ; j >=0 ; j--){
          if(flag){
            index ++;
            sb.append(array[i][j]);

          }
          if(array[i][j].equals("1") && !flag){
            flag = true;
            index ++;
            sb.append(array[i][j]);
          }

          if(index == 7 && cal.contains(String.valueOf(sb.reverse()))){
            list.addFirst(cal.indexOf(String.valueOf(sb)));
            index = 0;
            sb.setLength(0);
          }
        }
        if(flag){
          int odd = 0;
          int even = 0;
          int tmp = 1;
          for(int a : list){
            if(tmp % 2 == 0){
              even += a;
            }else{
              odd += a;
            }
            tmp++;
          }
  
          if((odd*3 + even) % 10 == 0){
            result = even+odd;
            break;
          }
        }
      }
      System.out.println("#"+t+" "+result);
    }
  
  }
}

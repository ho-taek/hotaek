import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class _k번째문자열 {
  static String result;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int t=1; t <= T; t++){
      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();

      int sSize = s.length();
      TreeSet<String> ts = new TreeSet<>();

      for(int i=sSize-1; i >=0 ; i--){
        for(int r=0; r < sSize-i; r++){
          String tmp = s.substring(r, r+i+1);
          // if(!pq.contains(tmp)){
            ts.add(tmp);
          // }
        }
      }

      if(n >= ts.size()){
        System.out.println("#"+t+" "+"none");
        continue;
      }
      
      for(int i=1; i <= n; i++){
        if(i == n){
          result = ts.pollFirst();
        }else{
          ts.pollFirst();
        }
      }
      if(result.equals(null)){
        System.out.println("#"+t+" "+"none");
      }else{
        System.out.println("#"+t+" "+result);
      }

    }

  }
}

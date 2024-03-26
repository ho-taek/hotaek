import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _문자열_2 {
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[][] st = new String[100][100];

    //가로
    // for(int t = 1; t <= 10; t++){
      int n = Integer.parseInt(br.readLine());
      int result = Integer.MIN_VALUE;
      for(int i=0; i< 100; i++){
        String value = br.readLine();
        st[i] = value.split("");
        
        for(int k=99; k >=0; k-- ){
          if(result > k){
            break;
          }
          for(int r=0; r < 100-k; r++){
            if(check(value.substring(r, k+r))){
              result = k;
            }
          }
        }
    }

    //세로
    String[][] rot = rotate(st);
    for(int i=0; i< 100; i++){
      String value = String.join("", rot[i]);
      for(int k=99; k >=0; k-- ){
        System.out.println(k);
        if(result > k){
          break;
        }
        for(int r=0; r < 100-k; r++){
          if(check(value.substring(r, k+r))){
            result = k;
          }
        }
      }
  // }

    System.out.println("#"+n+" "+ result);
  }




  }

  public static Boolean check(String sen){
    int senSize = sen.length();
  
    for(int i=0; i < senSize/2; i++){
      if(sen.charAt(i) != sen.charAt(senSize-1-i)){
        return false;
      }
    }
    return true;
  }

  static String[][] rotate(String[][] arr) {

    String[][] rotate = new String[100][100];

    for (int i = 0; i < rotate.length; i++) {
        for (int j = 0; j < rotate[i].length; j++) {
            rotate[i][j] = arr[100-1-j][i];
        }
    }

    return rotate;
}
}

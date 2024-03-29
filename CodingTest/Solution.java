import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        // System.out.println("0 ~ 100 사이의 난수 1개 발생 : " + (int) (Math.random() * 30));
        int r = 1;
        int n = 1;
        boolean[] array = new boolean[] {true,true,false};
        boolean[] output = new boolean[r];

        perm(0, array, output, r, n);
    }

    public static void perm(int depth , boolean[] array, boolean[] output, int r, int n){
      if(depth == r){
        System.out.println(Arrays.toString(output));
        return;
      }

      for(int i =0; i <n ; i++){
        output[depth] = true;
        perm(depth+1, array, output, r, n);
        output[depth] = false;
        perm(depth+1, array, output, r, n);


      }




    }
  


}
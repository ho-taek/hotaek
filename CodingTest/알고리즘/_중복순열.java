package 알고리즘;

import java.util.Arrays;

public class _중복순열 {
    
    public static void main(String[] args) {
        int n = 3;
        int[] arr = { 1, 2, 3 };
        int[] output = new int[2];
    
        perm(arr, output, 0, 2);
      }

      public static void perm(int[] arr , int[] output, int depth, int r){
        if(depth == r){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i = 0; i < arr.length; i ++){
            output[depth] = arr[i];
            perm(arr, output, depth+1, r);
        }


      }
}

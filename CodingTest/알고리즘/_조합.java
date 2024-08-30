package 알고리즘;

import java.io.IOException;
import java.util.Arrays;

public class _조합 {
    
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        int[] arr = new int[] {0,1,2,3,4,5};
        int[] output = new int[3];
        visited = new boolean[6];

        comb(arr, output, 0,0, 6, 3);
    }

    public static void comb(int[] arr, int[] output, int start, int depth, int n, int r){
        if(depth == r){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i = start; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                comb(arr,output,i,depth+1,n,r);
                visited[i] = false;
            }
        }
    }
}

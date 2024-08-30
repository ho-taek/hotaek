package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650_N과M_2 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] output = new int[m];
        boolean[] visited = new boolean[n+1];
        comb(output, visited, 1, 0, n, m);
    }


    public static void comb(int[] output, boolean[] visited, int start, int depth, int n , int r){
        if(depth == r){
            for(int i =0; i < output.length; i++){
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start ; i <= n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = i;
                comb(output, visited, i, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
}

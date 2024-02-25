package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1010 {
    static int[][] graph = new int[31][31];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int t=0; t < n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int result = 0;
            result +=comb(row, col);
            
            System.out.println(result);

        }
    
    }

    public static int comb(int n, int r){
        if(graph[n][r] > 0){
            return graph[n][r];
        }
        if(n == r || r == 0){
            graph[n][r] = 1;
            return graph[n][r];
        }
        if(graph[n][r] ==0){
            return graph[n][r] = comb(n-1,r-1) + comb(n-1, r);
        }
        return 0;
    }
}

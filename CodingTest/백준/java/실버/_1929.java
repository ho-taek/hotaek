package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1929 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[m+1];
        
        isPrime[0] = isPrime[1] = true;
        for(int i=2; i <= Math.sqrt(m); i++){
            if(isPrime[i] == false){
                for(int j = i*i; j <= m; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        
        for(int i=n; i < m+1; i++){
            if(!isPrime[i]){
                
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}

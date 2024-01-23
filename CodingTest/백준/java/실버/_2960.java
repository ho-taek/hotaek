package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2960 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n+1];
        int result = 0;
        int answer = 0;
        Loop1 :
        for(int i = 2; i<= n; i++){
             if(!isPrime[i]){
                for(int j=i; j <= n; j+=i){
                    if(!isPrime[j]){
                        result ++;
                        isPrime[j] = true;
                        answer = j;
                        if(result == k){
                            break Loop1;
                        }
                    }
                }
             }
        }
        System.out.println(answer);
    }
}

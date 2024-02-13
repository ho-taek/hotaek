package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11659 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] array = new int[n+1];
        String[] input = br.readLine().split(" ");
        int result = 0;
        for(int i =0 ; i < n ; i++){
            result += Integer.parseInt(input[i]);
            array[i+1] = result;
        }
        
        for(int i=0; i < m; i++){
            String[] check = br.readLine().split(" ");
            int a = Integer.parseInt(check[0]);
            int b = Integer.parseInt(check[1]);

            if(a == 1){
                System.out.println(array[b]);
            }else{
                System.out.println((array[b]-array[a-1]));
            }
        }

    }
}

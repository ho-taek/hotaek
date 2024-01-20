package 백준.java.브론즈;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10989 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i =0; i < n ; i++){
            array[i] = Integer.parseInt(br.readLine()); 
        }
        Arrays.sort(array);
        for(int i : array){
            System.out.println(i);
        }
        
        
    }
}

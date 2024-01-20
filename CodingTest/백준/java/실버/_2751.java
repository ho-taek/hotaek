package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class _2751 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
       ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0 ; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
         }
         Collections.sort(list);
         for(int i : list){
            sb.append(i).append('\n');
         }
         System.out.println(sb);
    }
}

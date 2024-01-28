package 백준.java.실버;

import java.util.*;
import java.io.*;

public class _1427 {
    
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] array = br.readLine().toCharArray();
        Arrays.sort(array);
        for(int i=0; i < array.length ; i++ ){
            sb.append(array[i]);
        }
        System.out.println(sb);


    }

}

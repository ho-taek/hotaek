package 백준.java.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10988 {
    
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        int size = str.length();
        int result = 1;
        for(int i=0; i < size/2; i++){
            char one = str.charAt(i);
            char two = str.charAt(size-1-i);

            if(one != two){
                result = 0;
            }


        }
        System.out.println(result);
    }
}

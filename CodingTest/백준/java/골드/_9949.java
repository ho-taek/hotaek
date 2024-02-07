package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9949 {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        char[] n = br.readLine().toCharArray();
        String m = br.readLine();
        int k = m.length();
        for(char s : n){
            sb.append(s);
            if(sb.length() >= m.length() && sb.substring(sb.length()-k).equals(m)){
                for(int i = 0; i < m.length(); i ++){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb.toString());
        }
        
    }
}

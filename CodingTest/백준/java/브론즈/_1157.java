package 백준.java.브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine().toUpperCase();
        
        

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n.length(); i++){
            String m = String.valueOf(n.charAt(i));
            if(map.containsKey(m)){
                map.replace(m, map.get(m) + 1);
            }else{
                map.put(m,1);
            }
        }
        Map.Entry<String,Integer> maxEntry = null;
            
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry.getKey());
    }
}

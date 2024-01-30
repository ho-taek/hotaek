package 백준.java.실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class _1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i < n ; i++){
            String k = br.readLine();
            map.put(k, map.getOrDefault(k,0)+1);
        }

        for(int j =0; j < m ; j++){
            String k = br.readLine();
            map.put(k, map.getOrDefault(k,0)+1);
        }
        List<String> list = new ArrayList();

        for( String a : map.keySet() ){
            if(map.get(a) == 2){
                list.add(a);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String i : list){
            System.out.println(i);
        }
        
    }
}

package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.*;

public class _1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet();
        
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int o1Length = o1.length();
                int o2Length = o2.length();
                int compared = o1Length > o2Length ? 1 : o1Length < o2Length ? -1 : 0;
                if(compared == 0){
                    return o1.compareTo(o2);
                }
                return compared;
            }
            
        });
        for(String st : list){
            System.out.println(st);
        }

        
    }
}

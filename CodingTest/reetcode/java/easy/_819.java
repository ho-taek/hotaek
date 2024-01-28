package reetcode.java.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _819 {

    public static void main(String[] args){
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob","hit"};

        System.out.println(mostCommonWord(paragraph, banned));
    }
    

    public static String mostCommonWord(String paragraph, String[] banned) {
        

        String[] array = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        Set<String> set = new HashSet<String>(Arrays.asList(banned));
        

        HashMap<String,Integer> map = new HashMap<>();

        
        for(String st : array ){
            if(!set.contains(st)){
                map.put(st, map.getOrDefault(st, 0)+1);
            }
        }
        
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

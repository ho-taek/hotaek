package reetcode.java.medium;

import java.util.List;
import java.util.*;
public class _49 {

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String,List<String>>();

        for(String st : strs){
            char[] chars = st.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(st);
        }
        return new ArrayList<>(map.values());
    }
    
}

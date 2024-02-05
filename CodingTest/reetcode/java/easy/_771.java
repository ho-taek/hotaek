package reetcode.java.easy;


import java.util.*;

public class _771 {

    public static void main(String[] args){
        numJewelsInStones("Aaa", "BDJKds");
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> js = new HashSet<>();
        for(char j : jewels.toCharArray()){
            js.add(j);
        }
        for(char s : stones.toCharArray()){
            if(js.contains(s)){
                count ++;
            }
        }
       
        
        return count;
    }
}

package 프로그래머스.java.LV1;
import java.util.*;
public class _완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap();
        
        for(String i : completion){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(String i : participant){
            if(!map.containsKey(i)){
                return i;
            }else if(map.get(i) == 0){
                return i;
            }else{
                map.put(i,map.get(i) - 1) ;
            }
        }
       
        
        return "";
    }
}

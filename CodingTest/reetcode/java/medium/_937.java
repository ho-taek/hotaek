package reetcode.java.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _937 {

    public static void main(String[] args){

    }

    public static String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<String>();
        List<String> digitLogs = new ArrayList<String>(); 

        // Int 배열일때
        for(String log : logs){
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }

        //문자배열 재배치
        Collections.sort(letterLogs, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                String[] s1x = o1.split(" ", 2);
                String[] s2x = o2.split(" ", 2);

                int compared = s1x[1].compareTo(s2x[1]);
                if(compared == 0){
                    return s1x[0].compareTo(s2x[0]);
                }
                return compared;
            }

        });
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
    
}

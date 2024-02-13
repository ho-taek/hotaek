package reetcode.java.easy;

import java.util.ArrayDeque;
import java.util.*;
public class _20 {
    
    public static void main(String[] args){
        String s= "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                stack.push(ch);
            }else if(stack.isEmpty() || stack.pop() != map.get(ch)){
                return false;
            }

            

        }
        
        
        return stack.size() == 0;
    }
}

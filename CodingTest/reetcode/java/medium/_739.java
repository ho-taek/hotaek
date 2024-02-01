package reetcode.java.medium;

import java.util.*;
public class _739 {
    
    public static void main(String[] args){
        int[] array = {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(array)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[] result = new int[temperatures.length];
        if(temperatures.length == 1){
            return new int[1];
        }
        for(int i =0; i < temperatures.length; i++){
            while(!stack.isEmpty() &&temperatures[stack.peek()] < temperatures[i]){
                int index = stack.pop();
                result[index] = i-index;
            }
      
                stack.push(i);
            
        }
        return result;
    }
}

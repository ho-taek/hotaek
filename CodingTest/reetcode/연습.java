package reetcode;

import java.util.*;
public class 연습 {
    
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(3);
        queue.add(5);
        queue.add(7);

        System.out.println(queue);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue);
        System.out.println(queue.poll());
        
    }
}

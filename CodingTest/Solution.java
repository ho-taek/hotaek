import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Deque<Integer> deque = new ArrayDeque<>();
        String[] s = new String[] { "2", "3" };
        
        String v = "sdf";
        
        System.out.println(s);
        deque.offer(0);
        deque.offer(1);
        System.out.println(deque.peekLast());
        System.out.println(deque.pollLast());

    }

}

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Deque<Integer> deque = new ArrayDeque<>();
        String[] s = new String[] { "2", "3" };
        deque.offer(1);
        deque.offer(2);

        System.out.println(deque.peek());
        System.out.println(deque.poll());
        List<String> li = new ArrayList<>();

    }

}

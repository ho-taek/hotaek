package reetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 연습 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        System.out.println(queue.poll());
    }
}

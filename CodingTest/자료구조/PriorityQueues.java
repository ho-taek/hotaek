package 자료구조;

import java.util.*;

public class PriorityQueues {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.offer(1);
        pq.offer(3);
        pq.offer(5);
        pq.offer(2);
        System.out.println(pq.poll());
        System.out.println(pq);

    }
}

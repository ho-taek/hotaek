import java.io.*;
import java.util.*;

public class Solution {

    static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Solution.Node o) {
            return this.x - o.x;
        
    }
}

    public static void main(String[] args) throws IOException {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 2));
        pq.add(new Node(2, 1));

        System.out.println(pq.poll().x);

    }

}

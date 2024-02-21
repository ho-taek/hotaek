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

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }
            
        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}

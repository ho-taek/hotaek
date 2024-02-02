package 프로그래머스.java.Lv2;

import java.util.PriorityQueue;
import java.util.*;
public class _더맵게 {
    
    public static void main(String[] args){
        int[] array = {1,2,7};
        System.out.println(solution(array, 19));
    }

     public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i< scoville.length ; i++){
            pq.add(scoville[i]);
        }
        if(pq.peek() >= K){
            return answer;
        }

        while(pq.peek() < K && pq.size() >1){
            answer ++;
            int n = pq.poll();
            int m = pq.poll();
            int a = n + (m*2);
            pq.add(a);
        }

        if(pq.size()==1 && pq.peek()<K){
            return -1;
        }
        return answer;
    }
}

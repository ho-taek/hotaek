package 프로그래머스.java.Lv3;

import java.util.*;

public class _야근지수 {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }

        for (int i = 0; i < n; i++) {

            int tmp = pq.poll();
            tmp -= 1;
            pq.offer(tmp);
        }

        for (int i : pq) {
            if (i > 0) {
                answer += i * i;
            }
        }

        return answer;
    }
}

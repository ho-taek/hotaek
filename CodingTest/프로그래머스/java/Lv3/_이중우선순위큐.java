package 프로그래머스.java.Lv3;

import java.util.*;

public class _이중우선순위큐 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minPq = new PriorityQueue();
        PriorityQueue<Integer> maxPq = new PriorityQueue(Collections.reverseOrder());
        int[] answer = { 0, 0 };

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            int tmp = Integer.MAX_VALUE;
            if (s.equals("I")) {
                minPq.offer(num);
                maxPq.offer(num);
            } else if (num > 0) {
                if (!maxPq.isEmpty()) {
                    tmp = maxPq.poll();
                }

            } else {
                if (!minPq.isEmpty()) {
                    tmp = minPq.poll();
                }

            }
            minPq.remove(tmp);
            maxPq.remove(tmp);
        }

        if (!maxPq.isEmpty() && !minPq.isEmpty()) {
            int max = maxPq.poll();
            int min = minPq.poll();
            answer[0] = max;
            answer[1] = min;
        }

        return answer;
    }
}

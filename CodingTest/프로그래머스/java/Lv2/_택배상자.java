package 프로그래머스.java.Lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class _택배상자 {
    public int solution(int[] order) {
        Deque<Integer> product = new ArrayDeque<>();

        Deque<Integer> stack = new ArrayDeque<>();

        // 스택 초기값
        for (int i = 1; i <= order.length; i++) {
            if (i < order[0]) {
                stack.offer(i);
            } else if (i > order[0]) {
                product.offer(i);
            }
        }
        int answer = 1;

        for (int i = 1; i < order.length; i++) {
            int now = order[i];

            if (stack.size() > 0) {
                if (stack.peekLast() == now) {
                    answer++;
                    stack.pollLast();
                    continue;
                } else if (stack.peekLast() > now) {
                    break;
                }
            }

            if (product.size() > 0) {
                while (product.peek() < now) {
                    stack.offer(product.poll());
                }

                if (product.peek() == now) {
                    answer++;
                    product.poll();
                }
            }
        }
        return answer;
    }
}

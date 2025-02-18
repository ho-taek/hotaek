package 프로그래머스.java.Lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _연속된부분수열의합 {
    public class Node implements Comparable<Node> {
        int start;
        int end;
        int length;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start;
        }

        @Override
        public int compareTo(Node no) {
            if (this.length == no.length) {
                return this.start - no.start;
            }
            return this.length - no.length;
        }
    }

    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        List<Node> li = new ArrayList<>();

        int start = 0;
        int end = 0;
        int sum = sequence[0]; // 현재 부분합

        while (end < len) {
            if (sum < k) {
                end++;
                if (end < len) {
                    sum += sequence[end];
                }
            } else if (sum == k) {
                li.add(new Node(start, end));
                sum -= sequence[start];
                start++;
            } else {
                sum -= sequence[start];
                start++;
            }
        }

        Collections.sort(li);

        Node node = li.get(0);

        return new int[] { node.start, node.end };
    }
}

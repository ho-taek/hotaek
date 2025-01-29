package 프로그래머스.java.Lv3;

import java.util.*;

public class _단어변환 {
    public static class Node {

        String s;
        int count;

        public Node(String s, int count) {
            this.s = s;
            this.count = count;
        }

    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new LinkedList();

        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node q = queue.poll();

            if (q.s.equals(target)) {

                answer = q.count;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                String tmp = words[i];
                int cnt = 0;
                for (int j = 0; j < tmp.length(); j++) {
                    if (q.s.charAt(j) == tmp.charAt(j)) {
                        cnt++;
                    }
                }

                if (cnt == tmp.length() - 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Node(tmp, q.count + 1));
                }
            }
        }

        return answer;
    }
}

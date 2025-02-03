package 프로그래머스.java.Lv3;

import java.util.*;

public class _단속카메라 {
    public class Node implements Comparable<Node> {
        int open;
        int close;

        public Node(int open, int close) {
            this.open = open;
            this.close = close;
        }

        @Override
        public int compareTo(Node o) {
            if (this.close == o.close) {
                return this.open - o.open;
            }
            return this.close - o.close;
        }
    }

    public int solution(int[][] routes) {
        int answer = 1;

        List<Node> li = new ArrayList();

        for (int i = 0; i < routes.length; i++) {
            li.add(new Node(routes[i][0], routes[i][1]));
        }

        Collections.sort(li);

        int minValue = li.get(0).close;

        for (Node node : li) {
            if (node.open > minValue) {
                minValue = node.close;
                answer++;
            }
        }

        return answer;
    }
}

package 백준.java.골드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class _2159_케잌배달 {
    static long infinite = Long.MAX_VALUE;

    static class Node {
        int[][] all;
        long[] direction;

        Node(int x, int y) {
            all = new int[][] { { x, y }, { x - 1, y }, { x + 1, y }, { x, y - 1 }, { x, y + 1 } };
            this.direction = new long[] { 0, 0, 0, 0, 0 }; // 중앙, 상, 하, 좌, 우
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Node> li = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        Node start = new Node(x, y);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            li.add(new Node(x, y));
        }
        long answer = infinite;
        // 중앙, 상, 하, 좌, 우

        // 처음
        Node node = li.get(0);
        for (int i = 0; i < 5; i++) {
            node.direction[i] = calculate(start.all[0][0], start.all[0][1], node.all[i][0], node.all[i][1]);
        }
        start = node;

        // 그 다음부터
        for (int k = 1; k < li.size(); k++) {
            for (int i = 0; i < 5; i++) { // 다음 노드의 중앙, 상, 하, 좌, 우
                int nextX = li.get(k).all[i][0];
                int nextY = li.get(k).all[i][1];

                // 시작 노드의 모든 방향에서 다음 위치로 이동하는 최소 비용 계산
                long tmp = infinite;
                for (int j = 0; j < 5; j++) { // 현재 노드의 모든 방향
                    int cost = calculate(start.all[j][0], start.all[j][1], nextX, nextY);
                    tmp = Math.min(tmp, start.direction[j] + cost);
                }
                li.get(k).direction[i] = tmp;
            }

            start = li.get(k);

        }
        for (int i = 0; i < 5; i++) {
            answer = Math.min(answer, start.direction[i]);
        }

        System.out.println(answer);
    }

    public static int calculate(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}

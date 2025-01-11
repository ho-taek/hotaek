package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _16946_벽부수고이동하기4 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int n;
    static int m;
    static int[][] graph;
    static int[][] answer;
    static int[][] zero;
    static Map<Integer, Integer> map = new HashMap<>(); // 그룹명 1,2,...

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        answer = new int[n][m];
        zero = new int[n][m];
        List<Node> oneLi = new ArrayList<>();
        List<Node> zeroLi = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 그래프 초기화 및 1인 애들 리스트에 담기
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(s[j]);
                graph[i][j] = value;
                if (value == 1) {
                    oneLi.add(new Node(i, j));
                } else if (value == 0) {
                    zeroLi.add(new Node(i, j));
                }
            }
        }
        int zeroNumber = 1;
        for (Node node : zeroLi) { // 0 그룹 만들기 및 카운팅
            if (zero[node.x][node.y] == 0) {
                int cnt = bfs(node, zeroNumber);
                map.put(zeroNumber, cnt);
                zeroNumber++;
            }
        }

        for (Node node : oneLi) {
            Set<Integer> groupCheck = new HashSet<>();
            int tmp = 0;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 | nx >= n | ny < 0 | ny >= m)
                    continue;

                if (!groupCheck.contains(zero[nx][ny])) {
                    tmp += map.getOrDefault(zero[nx][ny], 0);
                    groupCheck.add(zero[nx][ny]);
                }
            }
            answer[node.x][node.y] = (tmp + 1) % 10;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(answer[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(Node start, int number) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        zero[start.x][start.y] = number;
        int count = 1;
        while (!queue.isEmpty()) {
            Node q = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (graph[nx][ny] == 0 && zero[nx][ny] == 0) {
                    zero[nx][ny] = number;
                    queue.offer(new Node(nx, ny));
                    count++;
                }
            }
        }
        return count;
    }

}

package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16236_아기상어 {
    static int n;
    static int[][] graph;

    static int[] dx = { -1, 0, 1, 0 }; // 상, 좌, 하, 우
    static int[] dy = { 0, -1, 0, 1 };

    public static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish other) {
            if (this.distance != other.distance) {
                return this.distance - other.distance;
            }
            if (this.x != other.x) {
                return this.x - other.x;
            }
            return this.y - other.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        Node start = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 9) {
                    start = new Node(i, j, 0);
                    graph[i][j] = 0; // 시작 위치는 빈 칸으로 변경
                } else {
                    graph[i][j] = value;
                }
            }
        }

        System.out.println(bfs(start));
    }

    public static int bfs(Node start) {
        int sharkSize = 2;
        int eatenFish = 0;
        int totalTime = 0;

        while (true) {
            boolean[][] visited = new boolean[n][n];
            Queue<Node> queue = new LinkedList<>();
            PriorityQueue<Fish> fishQueue = new PriorityQueue<>();

            queue.offer(start);
            visited[start.x][start.y] = true;

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    int nd = current.distance + 1;

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;
                    if (visited[nx][ny])
                        continue;
                    if (graph[nx][ny] > sharkSize)
                        continue;

                    visited[nx][ny] = true;
                    if (graph[nx][ny] > 0 && graph[nx][ny] < sharkSize) {
                        fishQueue.offer(new Fish(nx, ny, nd));
                    }

                    queue.offer(new Node(nx, ny, nd));
                }
            }

            if (fishQueue.isEmpty()) {
                break; // 더 이상 먹을 수 있는 물고기가 없음
            }

            Fish fish = fishQueue.poll(); // 우선순위 큐에서 가장 우선순위가 높은 물고기 선택
            totalTime += fish.distance;
            eatenFish++;
            graph[fish.x][fish.y] = 0; // 물고기 먹기

            if (eatenFish == sharkSize) {
                sharkSize++;
                eatenFish = 0;
            }

            start = new Node(fish.x, fish.y, 0); // 상어의 새로운 위치
        }

        return totalTime;
    }
}

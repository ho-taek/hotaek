package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _17143_낚시왕 {

    static Shark[][] graph;
    static Shark[][] newGraph;
    static int answer = 0;
    static int r;
    static int c;

    static class Shark {
        int x;
        int y;
        int s;
        int d;
        int z;
        int num;

        Shark(int x, int y, int s, int d, int z, int num) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
            this.num = num;
        }

    }

    // 1 -> 위, 2 -> 아래, 3 -> 오른쪽, 4 -> 왼쪽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Shark[r + 1][c + 1];
        newGraph = new Shark[r + 1][c + 1];
        Queue<Shark> sharkList = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int sz = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(sr, sc, ss, sd, sz, i);
            sharkList.offer(shark);
            graph[sr][sc] = shark;
        }

        for (int i = 1; i <= c; i++) {
            // 낚시왕의 발걸음
            for (int j = 1; j <= r; j++) {
                if (graph[j][i] != null) {
                    answer += graph[j][i].z;
                    sharkList.remove(graph[j][i]);
                    graph[j][i] = null;
                    break;
                }
            }
            // 이제 남은 상어가 도저히 없을 때
            if (sharkList.isEmpty()) {
                break;
            }
            boolean[][] visited = new boolean[r + 1][c + 1];
            // 상어들의 대이동
            int count = sharkList.size();
            while (count > 0) {
                if (sharkList.isEmpty()) {
                    break;
                }

                Shark shark = sharkList.poll();
                int speed = shark.s;

                if (speed > 0) {
                    graph[shark.x][shark.y] = null;
                }

                while (speed > 0) {
                    if (shark.d == 1) { // 위
                        if (shark.x == 1) {
                            shark.x = 2;
                            shark.d = 2;
                        } else {
                            shark.x--;
                        }

                    } else if (shark.d == 2) { // 아래
                        if (shark.x == r) {
                            shark.x = r - 1;
                            shark.d = 1;
                        } else {
                            shark.x++;
                        }

                    } else if (shark.d == 4) { // 왼쪽
                        if (shark.y == 1) {
                            shark.y = 2;
                            shark.d = 3;
                        } else {
                            shark.y--;
                        }

                    } else if (shark.d == 3) { // 오른쪽
                        if (shark.y == c) {
                            shark.y = c - 1;
                            shark.d = 4;
                        } else {
                            shark.y++;
                        }
                    }
                    speed--;
                }
                // 이미 방문한 상어가 있을 때
                if (newGraph[shark.x][shark.y] == null || newGraph[shark.x][shark.y].z < shark.z) {
                    newGraph[shark.x][shark.y] = shark;
                }
                count--;
            }

            for (int x = 1; x <= r; x++) {
                for (int y = 1; y <= c; y++) {
                    if (newGraph[x][y] != null) {
                        sharkList.offer(newGraph[x][y]);
                        graph[x][y] = newGraph[x][y];
                        newGraph[x][y] = null;
                    }

                }
            }

        }
        System.out.println(answer);
    }
}

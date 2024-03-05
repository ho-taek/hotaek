package SWAcademy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _점심_식사시간 {
    static class People {
        int x, y, dist, stair;

        public People(int x, int y, int dist, int stair) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.stair = stair;
        }

        public String toString() {
            return "x " + x + " y " + y;
        }
    }

    static class Stair {
        int x, y, count;

        public Stair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int n;
    static int[][] graph;
    static boolean[] visited;
    static List<People> people;
    static List<Stair> stair;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            // 그래프 생성
            graph = new int[n][n];
            people = new ArrayList<>();
            stair = new ArrayList<>();
            answer = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                StringTokenizer stg = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(stg.nextToken());
                    graph[i][j] = value;
                    if (value == 1) {
                        people.add(new People(i, j, 0, 0));
                    } else if (value > 1) {
                        stair.add(new Stair(i, j, value));
                    }
                }
            }

            for (int i = 0; i <= people.size() / 2; i++) {
                visited = new boolean[people.size()];
                comb(i, 0);
            }
            System.out.println("#" + t + " " + answer);
        }
    }

    public static void comb(int r, int start) {
        if (r == 0) {
            List<People> peopleA = new ArrayList<>();
            List<People> peopleB = new ArrayList<>();
            divPeople(peopleA, peopleB, stair, true);
            divPeople(peopleB, peopleA, stair, false);
            return;
        }

        for (int i = start; i < people.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(r - 1, start + 1);
                visited[i] = false;
            }
        }
    }

    public static void divPeople(List<People> a, List<People> b, List<Stair> stair, boolean flag) {
        for (int i = 0; i < people.size(); i++) {
            int distX = people.get(i).x;
            int distY = people.get(i).y;
            if (flag) {
                if (visited[i]) {
                    int stairX = stair.get(0).x;
                    int stairY = stair.get(0).y;
                    int stairCount = stair.get(0).count;
                    int dist = Math.abs(distX - stairX) + Math.abs(distY - stairY);
                    People p = new People(distX, distY, dist, stairCount);
                    a.add(p);
                } else {
                    int stairX = stair.get(1).x;
                    int stairY = stair.get(1).y;
                    int stairCount = stair.get(1).count;
                    int dist = Math.abs(distX - stairX) + Math.abs(distY - stairY);
                    People p = new People(distX, distY, dist, stairCount);
                    b.add(p);
                }
            } else {
                if (!visited[i]) {
                    int stairX = stair.get(0).x;
                    int stairY = stair.get(0).y;
                    int stairCount = stair.get(0).count;
                    int dist = Math.abs(distX - stairX) + Math.abs(distY - stairY);
                    People p = new People(distX, distY, dist, stairCount);
                    a.add(p);
                } else {
                    int stairX = stair.get(1).x;
                    int stairY = stair.get(1).y;
                    int stairCount = stair.get(1).count;
                    int dist = Math.abs(distX - stairX) + Math.abs(distY - stairY);
                    People p = new People(distX, distY, dist, stairCount);
                    b.add(p);
                }
            }
        }
        int tmp = result(a, b);
        if (answer > tmp) {
            answer = tmp;
        }
    }

    public static int result(List<People> a, List<People> b) {
        int time = 0;
        List<People> stairA = new ArrayList<>();
        List<People> stairB = new ArrayList<>();
        while (true) {
            if (a.isEmpty() && b.isEmpty() && stairA.isEmpty() && stairB.isEmpty()) {
                break;
            }
            time++;
            // 계단 A
            if (!stairA.isEmpty()) {
                List<People> removeStair = new ArrayList<>();
                for (People s : stairA) {
                    if (a.contains(s)) {
                        a.remove(s);
                    }
                    s.stair = s.stair - 1;
                    if (s.stair <= 0) {
                        removeStair.add(s);
                    }
                }
                if (!removeStair.isEmpty()) {
                    for (People s : removeStair) {
                        stairA.remove(s);
                    }
                }
            }
            // 계단 B
            if (!stairB.isEmpty()) {
                List<People> removeStair = new ArrayList<>();
                for (People s : stairB) {
                    if (b.contains(s)) {
                        b.remove(s);
                    }
                    s.stair = s.stair - 1;
                    if (s.stair <= 0) {
                        removeStair.add(s);
                    }
                }
                if (!removeStair.isEmpty()) {
                    for (People s : removeStair) {
                        stairB.remove(s);
                    }
                }

            }
            // A 넣기
            if (!a.isEmpty()) {
                for (People p : a) {
                    p.dist = p.dist - 1;
                    if (p.dist <= 0 && stairA.size() < 3) {
                        stairA.add(p);
                    }
                }
            }
            // B 넣기
            if (!b.isEmpty()) {
                for (People p : b) {
                    p.dist = p.dist - 1;
                    if (p.dist <= 0 && stairB.size() < 3) {
                        stairB.add(p);
                    }
                }
            }

        }

        return time;
    }

}

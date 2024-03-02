package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.*;

public class _17531 {
    static int[][] graph;
    static int n;
    static int m;
    static int d;
    static int[] sniper;
    static boolean[] visited;
    static int sr;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, 거리 값
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 스나이퍼 현재 행
        sr = n;

        // graph, sniper 생성
        graph = new int[n][m];
        sniper = new int[m];
        for (int i = 0; i < m; i++) {
            sniper[i] = i;
        }
        for (int i = 0; i < n; i++) {

            StringTokenizer stg = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(stg.nextToken());
            }
        }

        visited = new boolean[m];
        result = 0;
        comb(3, 0, n);

        System.out.println(result);
    }

    public static void comb(int r, int start, int n) {
        if (r == 0) {
            sr = n;
            int[] sniperValue = setSniper();
            int[][] copyGraph = copyGraph();
            int killTmp = 0;
            boolean[][] sVisited = new boolean[n][m];
            while (true) {
                if (checkCount()) {
                    break;
                }
                if (sr <= 0) {
                    break;
                }
                List<int[]> kill = new ArrayList<>();
                for (int sc : sniperValue) {
                    int[] min = new int[2];
                    int startC = (sc - d < 0) ? 0 : (sc - d);
                    int endC = ((sc + d) >= m) ? m : (sc + d);
                    int startR = (sr - d < 0) ? 0 : (sr - d);
                    int minD = Integer.MAX_VALUE;
                    boolean flag = false;
                    for (int j = startC; j < endC; j++) {
                        for (int i = startR; i < sr; i++) {
                            int tmp = Math.abs(sr - i) + Math.abs(sc - j);
                            if (copyGraph[i][j] == 1 && tmp <= d && minD > tmp) {
                                flag = true;
                                minD = tmp;
                                min[0] = i;
                                min[1] = j;
                            }
                        }
                    }
                    if (flag && !sVisited[min[0]][min[1]] && copyGraph[min[0]][min[1]] == 1) {
                        kill.add(min);
                        sVisited[min[0]][min[1]] = true;
                    }
                }
                if (!kill.isEmpty()) {
                    for (int[] s : kill) {
                        copyGraph[s[0]][s[1]] = 0;
                        killTmp++;
                    }
                }

                sr--;
            }
            if (killTmp > result) {
                result = killTmp;
            }
            return;
        }
        for (int i = start; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(r - 1, start + 1, n);
                visited[i] = false;
            }
        }
    }

    // 스나이퍼 현재 위치
    public static int[] setSniper() {
        int[] sniperValue = new int[3];
        int index = 0;

        for (int i = 0; i < m; i++) {
            if (visited[i]) {
                sniperValue[index] = i;
                index++;
            }
        }
        return sniperValue;
    }

    // 0확인
    public static boolean checkCount() {
        int count = 0;
        for (int i = 0; i < sr; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    count++;
                }
            }
        }

        if (count == (sr * m)) {
            return true;
        }
        return false;
    }

    // graph복사
    public static int[][] copyGraph() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = graph[i][j];
                copy[i][j] = value;
            }
        }
        return copy;
    }
}

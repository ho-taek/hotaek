package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14503_로봇청소기 {
    // 북 동 남 서
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1;
        visited[a][b] = true;

        while (true) {

            boolean flag = false;
            int dCheck = d;
            // 확인
            for (int i = 0; i < 4; i++) {
                int dValue = setD(dCheck);
                dCheck = dValue;
                int cx = a + dx[dCheck];
                int cy = b + dy[dCheck];

                if (visited[cx][cy] == false && graph[cx][cy] == 0) {
                    flag = true;
                    d = dCheck;
                    a = cx;
                    b = cy;
                    visited[a][b] = true;
                    answer++;
                    break;
                }
            }

            if (!flag) {
                a = a - dx[d];
                b = b - dy[d];
                if (graph[a][b] == 1) {
                    break;
                }
            }

        }
        System.out.println(answer);
    }

    public static int setD(int s) {
        int value = s - 1;
        if (value < 0) {
            value = 3;
        }

        return value;
    }
}

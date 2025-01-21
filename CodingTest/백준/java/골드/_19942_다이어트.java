package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _19942_다이어트 {

    static int n;
    static int[] min;
    static int answer = Integer.MAX_VALUE;
    static int[][] eat;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        min = new int[4];

        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        eat = new int[n][5];

        for (int i = 0; i < n; i++) { // 식단표 체크
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                eat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] menu = new int[5];
        visited = new boolean[n];
        dfs(visited, menu, 0);

        if (answer == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(answer + "\n");
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    bw.write((i + 1) + " ");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(boolean[] visit, int[] menu, int count) {
        if (check(menu) && answer > menu[4]) {
            answer = menu[4];
            visited = Arrays.copyOf(visit, visit.length);
            return;
        }

        for (int i = count; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                menu[0] += eat[i][0];
                menu[1] += eat[i][1];
                menu[2] += eat[i][2];
                menu[3] += eat[i][3];
                menu[4] += eat[i][4];

                dfs(visit, menu, i + 1);

                menu[0] -= eat[i][0];
                menu[1] -= eat[i][1];
                menu[2] -= eat[i][2];
                menu[3] -= eat[i][3];
                menu[4] -= eat[i][4];
                visit[i] = false;
            }
        }
    }

    public static boolean check(int[] menu) {
        return menu[0] >= min[0] && menu[1] >= min[1] && menu[2] >= min[2] && menu[3] >= min[3];
    }
}

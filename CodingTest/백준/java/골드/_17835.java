package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _17835 {
    static int[][] graph;
    static final int INF = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        // 무한으로 전체 그래프 초기화
        for (int i = 1; i < (n + 1); i++) {
            Arrays.fill(graph[i], INF);
        }
        // 자기 자신 0으로 넣기
        for (int i = 1; i < (n + 1); i++) {
            graph[i][i] = 0;
        }
        // 그래프에 값(도로 길이) 넣기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u][v] = c;
        }

        // 면접장 도시
        st = new StringTokenizer(br.readLine());
        int[] city = new int[k];

        for (int i = 0; i < k; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int c = 1; c <= n; c++) {
                    if (graph[i][j] > graph[i][c] + graph[c][j]) {
                        graph[i][j] = graph[i][c] + graph[c][j];
                    }

                }
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }

        // 결과 도시
        int resultCity = INF;
        // 가장 먼 도로 길이
        int bigRoad = 0;
        int[] tmpCheck = new int[2];
        for (int i = 1; i <= n; i++) {
            tmpCheck[0] = INF;
            tmpCheck[1] = 0;
            for (int j = 0; j < k; j++) {
                if (tmpCheck[0] >= graph[i][j]) {
                    tmpCheck[0] = graph[i][j];
                    tmpCheck[1] = i;
                }
            }

            if (bigRoad < tmpCheck[0]) {
                bigRoad = tmpCheck[0];
                resultCity = tmpCheck[1];
            } else if (bigRoad == tmpCheck[0] && tmpCheck[1] < resultCity) {
                resultCity = tmpCheck[1];
            }
        }
        System.out.println(resultCity + "\n" + bigRoad);
        br.close();
    }
}

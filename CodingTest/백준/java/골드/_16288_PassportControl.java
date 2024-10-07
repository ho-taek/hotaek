package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16288_PassportControl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        int[] road = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < m; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && road[j] > result) {
                    answer++;
                    visited[j] = true;
                    result = road[j];
                }
            }
        }

        if (answer == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

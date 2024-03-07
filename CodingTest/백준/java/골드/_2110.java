package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110 {
    static int[] graph;
    static boolean[] visited;
    static int n;
    static int m;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        result = Integer.MIN_VALUE;
        comb(m, 0);
        System.out.println(result);
    }

    public static void comb(int r, int start) {
        if (r == 0) {
            int answer = check();

            if (result < answer) {
                result = answer;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(r - 1, start + 1);
                visited[i] = false;
            }
        }

    }

    public static int check() {
        int[] visit = new int[m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                visit[index] = graph[i];
                index++;
            }
        }

        Arrays.sort(visit);

        int tmp = Integer.MAX_VALUE;

        for (int i = 0; i < (m - 1); i++) {
            if (tmp > (visit[i + 1] - visit[i])) {
                tmp = visit[i + 1] - visit[i];
            }
        }
        return tmp;
    }

}

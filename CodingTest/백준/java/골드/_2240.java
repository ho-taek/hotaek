package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2240 {
    static int[] array;
    static int t;
    static int answer;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기 데이터 입력 받기
        t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        array = new int[t];
        for (int i = 0; i < t; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[t + 1];

        answer = 0;
        dfs(w, 1, 0, true);
        System.out.println(answer);
    }

    // flag : true -> 1, false -> 2
    public static void dfs(int n, int depth, int result, boolean flag) {
        if (depth == t) {
            if (answer < result) {
                answer = result;
            }
            return;
        }
        if (flag) {
            if (array[depth] == 1) {
                result++;
            }
        } else {
            if (array[depth] == 2) {
                result++;
            }
        }

        if (n > 0) {
            dfs(n - 1, depth + 1, result, !flag);
        }
        dfs(n, depth + 1, result, flag);
    }
}

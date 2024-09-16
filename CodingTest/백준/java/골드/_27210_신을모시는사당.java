package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _27210_신을모시는사당 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];

        int[] dp = new int[n];

        int answer = 1;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cur = array[i] == 1 ? -1 : 1;
            if (i == 0) {
                dp[i] = cur;
            } else {
                dp[i] = Math.max(dp[i - 1] + cur, cur);
            }
            answer = Math.max(answer, dp[i]);
        }

        dp = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = array[i] == 2 ? -1 : 1;
            if (i == 0) {
                dp[i] = cur;
            } else {
                dp[i] = Math.max(dp[i - 1] + cur, cur);
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}

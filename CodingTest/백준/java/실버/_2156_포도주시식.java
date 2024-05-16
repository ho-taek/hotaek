package 백준.java.실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2156_포도주시식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][2];

        dp[1][0] = value[0];
        dp[1][1] = value[0];
        int result = 0;
        if (n == 1) {
            result = value[0];
        } else {
            for (int i = 2; i <= n; i++) {
                int first = dp[i - 2][1] + value[i - 1];
                int second = dp[i - 1][0] + value[i - 1];

                if (first > result) {
                    result = first;
                }
                if (second > result) {
                    result = second;
                }

                dp[i][0] = first;
                dp[i][1] = second;

            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(result);
    }
}

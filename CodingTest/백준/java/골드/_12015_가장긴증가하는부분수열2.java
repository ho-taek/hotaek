package 백준.java.골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        int cnt = 0;
        dp[cnt++] = array[0];

        for (int i = 1; i < n; i++) {
            if (dp[cnt - 1] < array[i]) {
                dp[cnt++] = array[i];
            } else {
                int s = 0;
                int e = cnt;

                while (s < e) {
                    int mid = (s + e) / 2;
                    if (dp[mid] < array[i]) {
                        s = mid + 1;
                    } else {
                        e = mid;
                    }
                }
                dp[e] = array[i];
            }
        }
        System.out.println(cnt);
    }
}

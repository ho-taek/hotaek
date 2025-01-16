package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _2208_보석줍기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) { // 배열 값 넣기
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }

        long[] s = new long[n + 1]; // 누적합

        for (int i = 1; i <= n; i++) { // 누적합 구하기
            s[i] = s[i - 1] + arr[i];
        }

        long answer = 0;
        long minS = Long.MAX_VALUE;

        for (int i = m; i <= n; i++) {
            minS = Math.min(minS, s[i - m]);
            answer = Math.max(answer, s[i] - minS);
        }

        System.out.println(answer);
    }
}

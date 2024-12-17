package 백준.java.골드;

import java.util.*;
import java.io.*;

public class _2056_작업 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] endTime = new int[n + 1];
        int answer = 0;

        // 첫 번째 작업
        st = new StringTokenizer(br.readLine());
        endTime[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i++) { // i는 작업 번호
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            int tmp = 0;
            for (int j = 2; j < (b + 2); j++) {
                int index = Integer.parseInt(s[j]);
                if (endTime[index] > tmp) {
                    tmp = endTime[index];
                }
            }
            endTime[i] = tmp + a;
            answer = Math.max(answer, endTime[i]);
        }

        System.out.println(answer);
    }
}
